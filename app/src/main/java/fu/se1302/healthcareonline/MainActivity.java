package fu.se1302.healthcareonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_appointments:
                        toolbar.setTitle("Appointments");
                        return true;
                    case R.id.navigation_qa:
                        toolbar.setTitle("Q&A");
                        return true;
                    case R.id.navigation_home:
                        toolbar.setTitle("Home");
                        HomeFragment homeFragment = HomeFragment.newInstance();
                        openFragment(homeFragment);
                        return true;
                    case R.id.navigation_notifications:
                        toolbar.setTitle("Notifications");
                        return true;
                    case R.id.navigation_profile:
                        toolbar.setTitle("Profile");
                        ProfileFragment profileFragment = ProfileFragment.newInstance();
                        openFragment(profileFragment);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        toolbar.setTitle("Home");
        HomeFragment homeFragment = HomeFragment.newInstance();
        openFragment(homeFragment);
    }
    private void openFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

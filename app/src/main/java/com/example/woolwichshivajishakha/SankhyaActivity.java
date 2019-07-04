package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SankhyaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sankhya);
        BottomNavigationView nav_bar = (BottomNavigationView) findViewById(R.id.nav_view);
        nav_bar.setOnNavigationItemSelectedListener(navListener);
        Fragment defaultFragment = new AddSankhya();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, defaultFragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item){
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case R.id.navigation_addSankhya:
                        selectedFragment = new AddSankhya();
                        break;

                    case R.id.navigation_viewSankhya:
                        selectedFragment = new ViewSankhya();
                        break;

                    case R.id.navigation_monitorSankhya:
                        selectedFragment = new MonitorSankhya();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, selectedFragment).commit();
                return true;
            }
            };
}

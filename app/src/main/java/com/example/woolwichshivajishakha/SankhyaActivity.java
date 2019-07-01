package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SankhyaActivity extends AppCompatActivity {

    private BottomNavigationView nav_bar;
    private AddSankhya addSankhyaFragment;
    private ViewSankhya viewSankhyaFragment;
    private MonitorSankhya monitorSankhyaFragment;
    private FrameLayout addFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sankhya);
        addFrame = (FrameLayout) findViewById(R.id.mainFrame);
        nav_bar = (BottomNavigationView) findViewById(R.id.nav_view);
        addSankhyaFragment = new AddSankhya();
        viewSankhyaFragment = new ViewSankhya();
        monitorSankhyaFragment = new MonitorSankhya();

        nav_bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_addSankhya:
                        setFragment(addSankhyaFragment);
                        return true;

                    case R.id.navigation_viewSankhya:
                        setFragment(viewSankhyaFragment);
                        return true;

                    case R.id.navigation_monitorSankhya:
                        setFragment(monitorSankhyaFragment);
                        return true;

                        default: return false;
                }
            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame,fragment);
    }

}

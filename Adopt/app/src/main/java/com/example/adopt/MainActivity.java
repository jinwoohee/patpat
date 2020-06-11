package com.example.adopt;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentSupport fragmentSupport = new FragmentSupport();
    private FragmentAdoption fragmentAdoption = new FragmentAdoption();
    private FragmentMypage fragmentMypage = new FragmentMypage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigationView);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentSupport);
        transaction.commit();
        //commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch(item.getItemId())
                {
                    case R.id.supportItem:
                        transaction.replace(R.id.frameLayout, fragmentSupport).commitAllowingStateLoss();
                        break;
                    case R.id.adoptionItem:
                        transaction.replace(R.id.frameLayout, fragmentAdoption).commitAllowingStateLoss();
                        break;
                    case R.id.mypageItem:
                        transaction.replace(R.id.frameLayout, fragmentMypage).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });
    }
}

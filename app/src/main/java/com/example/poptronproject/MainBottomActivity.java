package com.example.poptronproject;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBottomActivity extends AppCompatActivity {
    final Fragment homeFragment = new HomeFragment();
    final Fragment searchFragment = new SearchFragment();
    final Fragment newsFragment = new NewsFragment();
    final Fragment profileFragment = new ProfileFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottomactivity);
        fm.beginTransaction().add(R.id.fragment, profileFragment, "4").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.fragment, newsFragment, "3").hide(newsFragment).commit();
        fm.beginTransaction().add(R.id.fragment, searchFragment, "2").hide(searchFragment).commit();
        fm.beginTransaction().add(R.id.fragment, homeFragment, "1").commit();
        BottomNavigationView btm = findViewById(R.id.bottom_navigation);
        btm.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.home:
                fm.beginTransaction().hide(active).show(homeFragment).commit();
                active = homeFragment;
                return true;

            case R.id.search:
                fm.beginTransaction().hide(active).show(searchFragment).commit();
                active = searchFragment;
                return true;

            case R.id.news:
                fm.beginTransaction().hide(active).show(newsFragment).commit();
                active = newsFragment;
                return true;
            case R.id.profile:
                fm.beginTransaction().hide(active).show(profileFragment).commit();
                active = profileFragment;
                return true;

        }
        return false;
    };
}




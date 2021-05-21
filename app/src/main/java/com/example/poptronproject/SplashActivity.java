package com.example.poptronproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.poptronproject.Model.EntireSharedPreferences;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences shared;
    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        EntireSharedPreferences.cInitialize(SplashActivity.this);
        new Handler().postDelayed(() -> {
            Intent i;

            if (EntireSharedPreferences.onceViewpagerLoggedIn()) {
                EntireSharedPreferences.viewPagerDoesNotLogin(false);
                i = new Intent(SplashActivity.this, MyViewPager.class);
                startActivity(i);
                finish();
            } else {
                i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }

        }, SPLASH_TIME_OUT);


    }
}
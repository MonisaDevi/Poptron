package com.example.poptronproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MyViewPager extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter pageradapter;
    Button get_started;
    TabLayout tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //<create>
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        //<create>
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        viewPager = findViewById(R.id.viewpager);
        tab = (TabLayout) findViewById(R.id.tab_layout);
        pageradapter = new fragmentAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(pageradapter);
        get_started = findViewById(R.id.get_started);
        tab.setupWithViewPager(viewPager, true);


        get_started.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() + 1 <= 2) {
                    viewPager.setCurrentItem(getItem(+1), true);
                } //getItem(-1) for previous
                else {
                    Intent i = new Intent(MyViewPager.this, LoginActivity.class);
                    startActivity(i);
                    MyViewPager.this.finish();
                }
            }
        });
    }


    public void loginActivity(View view) {
        Intent i = new Intent(MyViewPager.this, LoginActivity.class);
        startActivity(i);
    }

    private int getItem(int i) {

        return viewPager.getCurrentItem() + i;
    }
}

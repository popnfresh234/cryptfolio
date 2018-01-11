package com.dmtaiwan.alexander.cryptfolio.main;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dmtaiwan.alexander.cryptfolio.R;

public class MainActivity extends AppCompatActivity{

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up ViewPager
        ViewPager viewPager = findViewById(R.id.view_pager_main);
        FragmentPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }


}

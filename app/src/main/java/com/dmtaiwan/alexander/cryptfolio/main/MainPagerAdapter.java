package com.dmtaiwan.alexander.cryptfolio.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Alexander on 1/8/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_FRAGMENTS = 2;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return OverviewFragment.newInstance();
            case 1:
                return SettingsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }
}

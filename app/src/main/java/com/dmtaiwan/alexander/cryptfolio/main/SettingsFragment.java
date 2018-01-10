package com.dmtaiwan.alexander.cryptfolio.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmtaiwan.alexander.cryptfolio.R;

/**
 * Created by Alexander on 1/8/2018.
 */

public class SettingsFragment extends Fragment{

    public static final String AUD = "AUD";
    public static final String BRL = "BRL";
    public static final String CAD = "CAD";
    public static final String CHF = "CHF";
    public static final String CLP = "CLP";
    public static final String CNY = "CNY";
    public static final String CZK = "CZK";
    public static final String DKK = "DKK";
    public static final String EUR = "EUR";
    public static final String GBP = "GBP";
    public static final String HKD = "HKD";
    public static final String HUF = "HUF";
    public static final String IDR = "IDR";
    public static final String ILS = "ILS";
    public static final String INR = "INR";
    public static final String JPY = "JPY";
    public static final String KRW = "KRW";
    public static final String MXN = "MXN";
    public static final String MYR = "MYR";
    public static final String NOK = "NOK";
    public static final String NZD = "NZD";
    public static final String PHP = "PHP";
    public static final String PKR = "PKR";
    public static final String PLN = "PLN";
    public static final String RUB = "RUB";
    public static final String SEK = "SEK";
    public static final String SGD = "SGD";
    public static final String THB = "THB";
    public static final String TRY = "TRY";
    public static final String TWD = "TWD";
    public static final String ZAR = "ZAR";

    public static SettingsFragment newInstance() {
        SettingsFragment settingsFragment = new SettingsFragment();
        return settingsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        return rootView;
    }
}

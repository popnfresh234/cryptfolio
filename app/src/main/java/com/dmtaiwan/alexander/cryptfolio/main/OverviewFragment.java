package com.dmtaiwan.alexander.cryptfolio.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.find_coin.FindCoinActivity;

/**
 * Created by Alexander on 1/8/2018.
 */

public class OverviewFragment extends android.support.v4.app.Fragment {

    public static OverviewFragment newInstance() {
        OverviewFragment overviewFragment = new OverviewFragment();
        return overviewFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_overview, container, false);
        FloatingActionButton floatingActionButton = rootView.findViewById(R.id.fab_add_transaction);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FindCoinActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}

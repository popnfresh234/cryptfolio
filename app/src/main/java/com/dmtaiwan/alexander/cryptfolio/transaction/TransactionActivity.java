package com.dmtaiwan.alexander.cryptfolio.transaction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.utilities.Utils;

/**
 * Created by Alexander on 1/8/2018.
 */

public class TransactionActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Intent intent = getIntent();
        Coin coin = intent.getParcelableExtra(Utils.KEY_COIN);
        Log.i("TEST", coin.getName());
        TransactionHistoryFragment fragment = TransactionHistoryFragment.newInstance(coin);
        getSupportFragmentManager().beginTransaction().replace(R.id.transaction_container, fragment);
    }
}

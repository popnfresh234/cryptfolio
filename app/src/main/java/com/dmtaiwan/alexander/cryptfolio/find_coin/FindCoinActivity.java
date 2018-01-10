package com.dmtaiwan.alexander.cryptfolio.find_coin;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBContract.CoinMarketCapEntry;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBHelper;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.utilities.Utils;

import java.util.ArrayList;

/**
 * Created by Alexander on 1/8/2018.
 */

public class FindCoinActivity extends AppCompatActivity{

    private static final String SORT_ORDER = CoinMarketCapEntry.COLUMN_RANK + " ASC";

    private RecyclerView recyclerView;
    private SearchView searchView;
    private FindCoinAdapter adapter;
    private ArrayList<Coin> coins;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_coin);

        //Set up recycler view
        recyclerView = findViewById(R.id.find_coin_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);


        //Load up initial data
        Cursor cursor = CryptfolioDBHelper.readDbCoins(FindCoinActivity.this, null, null, null, SORT_ORDER);
        coins = Utils.generateCoinsFromCursor(cursor);
        cursor.close();
        adapter = new FindCoinAdapter(this, coins);
        recyclerView.setAdapter(adapter);


        //Set up search view for finding coins
        searchView = findViewById(R.id.find_coin_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                Cursor cursor = CryptfolioDBHelper.querySimilarCoins(FindCoinActivity.this, query);
                coins = Utils.generateCoinsFromCursor(cursor);
                cursor.close();
                adapter.swapCursor(coins);
                return false;
            }
        });
    }
}

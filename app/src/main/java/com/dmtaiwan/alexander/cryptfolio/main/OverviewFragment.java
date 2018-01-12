package com.dmtaiwan.alexander.cryptfolio.main;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBContract;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBHelper;
import com.dmtaiwan.alexander.cryptfolio.find_coin.FindCoinActivity;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.models.Holding;
import com.dmtaiwan.alexander.cryptfolio.models.crypto_compare.Exchange;
import com.dmtaiwan.alexander.cryptfolio.networking.coin_market_cap.CoinMarketCapApiController;
import com.dmtaiwan.alexander.cryptfolio.networking.crypto_compare.CryptoCompareApiController;

import java.util.ArrayList;

/**
 * Created by Alexander on 1/8/2018.
 */

public class OverviewFragment extends android.support.v4.app.Fragment implements CoinsCallback {

    private HoldingAdapter adapter;

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

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_overview_fragment_holdings);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        adapter = new HoldingAdapter(getActivity());
        recyclerView.setAdapter(adapter);



        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        CryptfolioDBHelper helper = new CryptfolioDBHelper(getActivity());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(CryptfolioDBContract.HoldingEntry.TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Holding> holdings = CryptfolioDBHelper.createHoldingsFromCursor(cursor);

        //Test Retrofit Call
        CoinMarketCapApiController coinMarketCapApiController= new CoinMarketCapApiController();
        coinMarketCapApiController.getCoinList(this);

        CryptoCompareApiController cryptoCompareApiController = new CryptoCompareApiController();
        cryptoCompareApiController.fetchExchangeData(this);


        adapter.swapData(holdings);
    }

    @Override
    public void onCoinMarketCapRequestResult(ArrayList<Coin> coins) {
        CryptfolioDBHelper.bulkInsertCoins(getActivity(), coins);
        adapter.updateCoinData(coins);
    }

    @Override
    public void onCoinMarketCapRequestError(String errorMessage) {
        Log.e("COIN MARKET CAP ERROR:", errorMessage);
    }

    @Override
    public void onExchangeDataRequestReturn(ArrayList<Exchange> exchanges) {
        CryptfolioDBHelper.writeExchangeDataToDatabase(getActivity(), exchanges);
    }

    @Override
    public void onExchangeDataRequestError(String errorMessage) {
        Log.e("EXCHANGE DATA ERROR:", errorMessage);
    }
}

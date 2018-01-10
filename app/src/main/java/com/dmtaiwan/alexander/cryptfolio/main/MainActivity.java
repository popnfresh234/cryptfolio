package com.dmtaiwan.alexander.cryptfolio.main;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBHelper;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.models.crypto_compare.Exchange;
import com.dmtaiwan.alexander.cryptfolio.networking.coin_market_cap.CoinMarketCapApiController;
import com.dmtaiwan.alexander.cryptfolio.networking.crypto_compare.CryptoCompareApiController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CoinsCallback{

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Test Retrofit Call
        CoinMarketCapApiController coinMarketCapApiController= new CoinMarketCapApiController();
        coinMarketCapApiController.getCoinList(this, SettingsFragment.CAD);

        CryptoCompareApiController cryptoCompareApiController = new CryptoCompareApiController();
        cryptoCompareApiController.fetchExchangeData(this);

        //Set up ViewPager
        ViewPager viewPager = findViewById(R.id.view_pager_main);
        FragmentPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }



    @Override
    public void onCoinMarketCapRequestResult(ArrayList<Coin> coins) {
        CryptfolioDBHelper.bulkInsertCoins(this, coins);
    }

    @Override
    public void onCoinMarketCapRequestError(String errorMessage) {
        Log.e("COIN MARKET CAP ERROR:", errorMessage);
    }

    @Override
    public void onExchangeDataRequestReturn(ArrayList<Exchange> exchanges) {
        CryptfolioDBHelper.writeExchangeDataToDatabase(this, exchanges);
    }

    @Override
    public void onExchangeDataRequestError(String errorMessage) {
        Log.e("EXCHANGE DATA ERROR:", errorMessage);
    }
}

package com.dmtaiwan.alexander.cryptfolio.networking.coin_market_cap;

import com.dmtaiwan.alexander.cryptfolio.main.CoinsCallback;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alexander on 1/8/2018.
 */

public class CoinMarketCapApiController {

    private static final String BASE_URL = " https://api.coinmarketcap.com/v1/";

    private CoinsCallback coinsCallback;


    //Fetches a list of all coins from CoinMarketCap valued in USD, BTC, and the user's preferred currency
    public void getCoinList(final CoinsCallback coinsCallback, String preferredCurrency) {
        this.coinsCallback = coinsCallback;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CoinMarketCapApi coinMarketCapApi = retrofit.create(CoinMarketCapApi.class);
        Call<ArrayList<Coin>> call = coinMarketCapApi.getCoinList(preferredCurrency);
        call.enqueue(new Callback<ArrayList<Coin>>() {
            @Override
            public void onResponse(Call<ArrayList<Coin>> call, Response<ArrayList<Coin>> response) {
                coinsCallback.onCoinMarketCapRequestResult(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Coin>> call, Throwable t) {
                coinsCallback.onCoinMarketCapRequestError(t.getMessage());
            }
        });
    }
}

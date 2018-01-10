package com.dmtaiwan.alexander.cryptfolio.networking.coin_market_cap;

import com.dmtaiwan.alexander.cryptfolio.models.Coin;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alexander on 1/8/2018.
 */

public interface CoinMarketCapApi {
    @GET("ticker/")
    Call<ArrayList<Coin>> getCoinList(@Query("convert") String currency);
}

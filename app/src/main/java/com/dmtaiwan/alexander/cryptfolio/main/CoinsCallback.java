package com.dmtaiwan.alexander.cryptfolio.main;

import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.models.crypto_compare.Exchange;

import java.util.ArrayList;

/**
 * Created by Alexander on 1/8/2018.
 */

public interface CoinsCallback {
    void onCoinMarketCapRequestResult(ArrayList<Coin> coins);

    void onCoinMarketCapRequestError(String errorMessage);

    void onExchangeDataRequestReturn(ArrayList<Exchange> exchanges);

    void onExchangeDataRequestError(String errorMessage);
}

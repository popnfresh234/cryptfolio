package com.dmtaiwan.alexander.cryptfolio.networking.crypto_compare;


import com.dmtaiwan.alexander.cryptfolio.main.CoinsCallback;
import com.dmtaiwan.alexander.cryptfolio.models.crypto_compare.Crypto;
import com.dmtaiwan.alexander.cryptfolio.models.crypto_compare.Exchange;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alexander on 1/9/2018.
 */

public class CryptoCompareApiController {

    public static final String EXCHANGE_URL = "https://min-api.cryptocompare.com/data/all/exchanges";

    private CoinsCallback coinsCallback;


    public void fetchExchangeData(final CoinsCallback coinsCallback) {
        this.coinsCallback = coinsCallback;
        URL url;
        try {
            url = new URL(EXCHANGE_URL);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    coinsCallback.onExchangeDataRequestError(e.getMessage());
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        try {
                            extractExchanges(response.body().string());
                        } catch (JSONException e) {
                            coinsCallback.onExchangeDataRequestError(e.getMessage());
                        }
                    }
                }
            });


        } catch (java.io.IOException e) {
            coinsCallback.onExchangeDataRequestError(e.getMessage());
        }

    }

    private void extractExchanges(String string) throws JSONException {
        ArrayList<Exchange> exchanges = new ArrayList<>();
        JSONObject rootObject = new JSONObject(string);
        //Fetch all the exchange names from the JSON
        Iterator<String> exchangeNames = rootObject.keys();
        //Loop over exchanges
        while (exchangeNames.hasNext()) {
            String exchangeName = exchangeNames.next();
            //Fetch actual exchange
            JSONObject exchangeObject = rootObject.getJSONObject(exchangeName);
            ArrayList<Crypto> cryptos = new ArrayList<>();
            //Fetch all crypto currencies associated with each exchange
            Iterator<String> cryptoNames = exchangeObject.keys();
            //Loop over currencies
            while (cryptoNames.hasNext()) {
                String cryptoName = cryptoNames.next();
                JSONArray pairArray = exchangeObject.getJSONArray(cryptoName);
                ArrayList<String> tradingPairs = new ArrayList<>();
                for (int i = 0; i < pairArray.length(); i++) {
                    String pairName = pairArray.getString(i);
                    tradingPairs.add(pairName);
                }
                Crypto crypto = new Crypto(cryptoName, tradingPairs);
                cryptos.add(crypto);
            }
            Exchange exchange = new Exchange(exchangeName, cryptos);
            exchanges.add(exchange);
        }

        //Success, return results
        coinsCallback.onExchangeDataRequestReturn(exchanges);
    }
}

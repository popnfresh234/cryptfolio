package com.dmtaiwan.alexander.cryptfolio.utilities;

import android.database.Cursor;

import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBContract.CoinMarketCapEntry;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alexander on 1/8/2018.
 */

public class Utils {
    public static final String KEY_COIN = "com.dmtaiwan.alexander.coin";

    //Utility method for turning a cursor into an ArrayList<Coin>
    public static ArrayList<Coin> generateCoinsFromCursor(Cursor cursor) {
        ArrayList<Coin> coinList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_COIN_ID));
            String name = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_NAME));
            String symbol = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_SYMBOL));
            String rank = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_RANK));
            String priceUsd = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_USD));
            String priceBTC = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_BTC));
            String twentyFourHourVolume = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_24H_VOLUME_USD));
            String marketCapUsd = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_MARKET_CAP_USD));
            String availableSupply = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_AVAILABLE_SUPPLY));
            String totalSupply = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_TOTAL_SUPPLY));
            String percentChangeOneHour = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_1H));
            String percentChangeTwentyFourHours = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_24H));
            String percentChangeSevenDays = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_7D));
            String lastUpdated = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_LAST_UPDATED));
            String priceAud = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_AUD));
            String priceBrl = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_BRL));
            String priceCad = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_CAD));
            String priceChf = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_CHF));
            String priceClp = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_CLP));
            String priceCny = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_CNY));
            String priceCzk = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_CZK));
            String priceDkk = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_DKK));
            String priceEur = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_EUR));
            String priceGbp = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_GBP));
            String priceHkd = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_HKD));
            String priceHuf = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_HUF));
            String priceIdr = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_IDR));
            String priceIls = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_ILS));
            String priceInr = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_INR));
            String priceJpy = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_JPY));
            String priceKrw = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_KRW));
            String priceMxn = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_MXN));
            String priceMyr = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_MYR));
            String priceNok = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_NOK));
            String priceNzd = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_NZD));
            String pricePhp = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_PHP));
            String pricePkr = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_PKR));
            String pricePln = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_PLN));
            String priceRub = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_RUB));
            String priceSek = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_SEK));
            String priceSgd = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_SGD));
            String priceThb = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_THB));
            String priceTry = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_TRY));
            String priceTwd = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_TWD));
            String priceZar = cursor.getString(cursor.getColumnIndex(CoinMarketCapEntry.COLUMN_PRICE_ZAR));

            Coin coin = new Coin(id, name, symbol, rank, priceUsd, priceBTC, twentyFourHourVolume, marketCapUsd, availableSupply, totalSupply, percentChangeOneHour,
                    percentChangeTwentyFourHours, percentChangeSevenDays, lastUpdated, priceAud, priceBrl, priceCad, priceChf, priceClp, priceCny, priceCzk,
                    priceDkk, priceEur, priceGbp, priceHkd, priceHuf, priceIdr, priceIls, priceInr, priceJpy, priceKrw, priceMxn, priceMyr, priceNok, priceNzd,
                    pricePhp, pricePkr, pricePln, priceRub, priceSek, priceSgd, priceThb, priceTry, priceTwd, priceZar);
            coinList.add(coin);
        }
        return coinList;
    }

    public static String getFormattedDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy HH:mm a");
        return sdf.format(date);
    }
}

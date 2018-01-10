package com.dmtaiwan.alexander.cryptfolio.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBContract.CoinMarketCapEntry;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBContract.ExchangesEntry;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.models.crypto_compare.Crypto;
import com.dmtaiwan.alexander.cryptfolio.models.crypto_compare.Exchange;

import java.util.ArrayList;

/**
 * Created by Alexander on 1/8/2018.
 */

public class CryptfolioDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "cryptfolio.db";
    private static final int DB_VERSION = 1;

    public CryptfolioDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_COIN_MARKET_CAP_TABLE = "CREATE TABLE " + CryptfolioDBContract.CoinMarketCapEntry.TABLE_NAME + " ("
                + CryptfolioDBContract.CoinMarketCapEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_COIN_ID + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_NAME + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_SYMBOL + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_RANK + " INTEGER, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_USD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_BTC + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_24H_VOLUME_USD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_MARKET_CAP_USD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_AVAILABLE_SUPPLY + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_TOTAL_SUPPLY + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_1H + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_24H + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_7D + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_LAST_UPDATED + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_AUD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_BRL + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_CAD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_CHF + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_CLP + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_CNY + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_CZK + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_DKK + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_EUR + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_GBP + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_HKD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_HUF + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_IDR + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_ILS + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_INR + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_JPY + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_KRW + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_MXN + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_MYR + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_NOK + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_NZD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_PHP + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_PKR + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_PLN + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_RUB + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_SEK + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_SGD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_THB + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_TRY + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_TWD + " TEXT, "
                + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_PRICE_ZAR + " TEXT, "
                + "UNIQUE (" + CryptfolioDBContract.CoinMarketCapEntry.COLUMN_COIN_ID + ") on conflict replace" + ")";

        String SQL_CREATE_EXCHANGE_TABLE = "CREATE TABLE " + CryptfolioDBContract.ExchangesEntry.TABLE_NAME + " ("
                + CryptfolioDBContract.ExchangesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_EXCHANGE_NAME + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BTC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ETH + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XRP + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BCH + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ADA + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XEM + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_LTC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XLM + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_MIOTA + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DASH + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_NEO + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_TRX + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XMR + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_EOS + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ICX + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_QTUM + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BTG + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XRB + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ETC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_LSK + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XVG + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_OMG + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_SC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BCN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BCC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ZEC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_PPT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_STRAT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BTS + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DCN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BNB + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_KCS + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ARDR + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_USDT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DOGE + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_SNT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_STEEM + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_WAVES + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_VEN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_WAX + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DRGN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DGB + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ZRX + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ARK + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_REP + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DENT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_HSR + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_VERI + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_KMD + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_GNT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BAT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_SALT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ETN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DCR + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_KNC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_FUN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_PIVX + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ETHOS + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XP + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_SUB + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_QASH + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_AION + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_MED + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_RDD + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_KIN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_NXS + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ELF + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_FCT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_POWR + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_AE + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_GAS + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_REQ + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_NEBL + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DBC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BTM + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ICN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_MONA + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ENG + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_RHOC + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_NXT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_COB + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BTCD + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_MAID + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_GBYTE + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_STORM + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_SYS + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_DGD + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_GNO + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_LINK + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_SAN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XDN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_ACT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_QSP + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_TNB + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_BNT + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_RDN + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_GAME + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_PAY + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_VEE + " TEXT, "
                + CryptfolioDBContract.ExchangesEntry.COLUMN_XZC + " TEXT, "
                + "UNIQUE (" + CryptfolioDBContract.ExchangesEntry.COLUMN_EXCHANGE_NAME + ") on conflict replace" + ")";

        String SQL_CREATE_TRANSACTION_TABLE = "CREATE TABLE " + CryptfolioDBContract.TransactionEntry.TABLE_NAME + " ("
                + CryptfolioDBContract.TransactionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CryptfolioDBContract.TransactionEntry.COLUMN_CURRENCY + " TEXT, "
                + CryptfolioDBContract.TransactionEntry.COLUMN_EXCHANGE_NAME + " TEXT, "
                + CryptfolioDBContract.TransactionEntry.COLUMN_TRADING_PAIR + " TEXT, "
                + CryptfolioDBContract.TransactionEntry.COLUMN_PURCHASE_PRICE + " TEXT, "
                + CryptfolioDBContract.TransactionEntry.COLUMN_PURCHASE_AMOUNT + " TEXT, "
                + CryptfolioDBContract.TransactionEntry.COLUMN_PURCHASE_DATE + "TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_COIN_MARKET_CAP_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_EXCHANGE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TRANSACTION_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Method to insert list of Coin objects into the database
    public static void bulkInsertCoins(Context context, ArrayList<Coin> coins) {
        CryptfolioDBHelper dbHelper = new CryptfolioDBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();

        try {
            ContentValues cv = new ContentValues();
            for (Coin coin : coins) {
                cv.put(CoinMarketCapEntry.COLUMN_COIN_ID, coin.getId());
                cv.put(CoinMarketCapEntry.COLUMN_NAME, coin.getName());
                cv.put(CoinMarketCapEntry.COLUMN_SYMBOL, coin.getSymbol());
                cv.put(CoinMarketCapEntry.COLUMN_RANK, coin.getRank());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_USD, coin.getPrice_usd());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_BTC, coin.getPrice_btc());
                cv.put(CoinMarketCapEntry.COLUMN_24H_VOLUME_USD, coin.getTwenty_four_hour_volume_usd());
                cv.put(CoinMarketCapEntry.COLUMN_MARKET_CAP_USD, coin.getMarket_cap_usd());
                cv.put(CoinMarketCapEntry.COLUMN_AVAILABLE_SUPPLY, coin.getAvailable_supply());
                cv.put(CoinMarketCapEntry.COLUMN_TOTAL_SUPPLY, coin.getTotal_supply());
                cv.put(CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_1H, coin.getPercent_change_one_hour());
                cv.put(CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_24H, coin.getPercent_change_twenty_four_hour());
                cv.put(CoinMarketCapEntry.COLUMN_PERCENT_CHANGE_7D, coin.getPercent_change_seven_days());
                cv.put(CoinMarketCapEntry.COLUMN_LAST_UPDATED, coin.getLast_updated());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_AUD, coin.getPrice_aud());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_BRL, coin.getPrice_brl());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_CAD, coin.getPrice_cad());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_CHF, coin.getPrice_chf());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_CLP, coin.getPrice_clp());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_CNY, coin.getPrice_cny());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_CZK, coin.getPrice_czk());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_DKK, coin.getPrice_dkk());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_EUR, coin.getPrice_eur());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_GBP, coin.getPrice_gbp());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_HKD, coin.getPrice_hkd());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_HUF, coin.getPrice_huf());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_IDR, coin.getPrice_idr());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_ILS, coin.getPrice_ils());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_INR, coin.getPrice_inr());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_JPY, coin.getPrice_jpy());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_KRW, coin.getPrice_krw());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_MXN, coin.getPrice_mxn());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_MYR, coin.getPrice_myr());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_NOK, coin.getPrice_nok());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_NZD, coin.getPrice_nzd());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_PHP, coin.getPrice_php());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_PKR, coin.getPrice_pkr());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_PLN, coin.getPrice_pln());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_RUB, coin.getPrice_rub());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_SEK, coin.getPrice_sek());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_SGD, coin.getPrice_sgd());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_THB, coin.getPrice_thb());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_TRY, coin.getPrice_try());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_TWD, coin.getPrice_twd());
                cv.put(CoinMarketCapEntry.COLUMN_PRICE_ZAR, coin.getPrice_zar());
                db.insert(CoinMarketCapEntry.TABLE_NAME, null, cv);
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e("Error inserting:", e.toString());
        } finally {
            db.endTransaction();
        }
    }


    //General query method
    public static Cursor readDbCoins(Context context, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        CryptfolioDBHelper dbHelper = new CryptfolioDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                CoinMarketCapEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        return cursor;
    }

    //Query for coins with similar names
    public static Cursor querySimilarCoins(Context context, String term) {
        CryptfolioDBHelper dbHelper = new CryptfolioDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] args = new String[1];
        args[0] = term + '%';
        String query = "SELECT * FROM " + CoinMarketCapEntry.TABLE_NAME
                + " WHERE " + CoinMarketCapEntry.COLUMN_COIN_ID + " LIKE ? "
                + " ORDER BY " + CoinMarketCapEntry.COLUMN_RANK + " ASC";
        return db.rawQuery(query, args);
    }


    //Query method to allow us to search for specific coins
    public static Cursor rawQueryCoins(Context context, String[] selectionArgs) {
        CryptfolioDBHelper dbHelper = new CryptfolioDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM " + CoinMarketCapEntry.TABLE_NAME
                + " WHERE " + CoinMarketCapEntry.COLUMN_COIN_ID + " IN ( "
                + makePlaceholders(selectionArgs.length) + ")";


        return db.rawQuery(query, selectionArgs);
    }


    private static String makePlaceholders(int arrayLength) {
        if (arrayLength < 1) {
            throw new RuntimeException("No placeholders");
        } else {
            StringBuilder sb = new StringBuilder(arrayLength * 2 - 1);
            sb.append("?");
            for (int i = 1; i < arrayLength; i++) {
                sb.append(",?");
            }
            return sb.toString();
        }
    }

    //Exchange Data Methods
    public static void writeExchangeDataToDatabase(Context context, ArrayList<Exchange> exchanges) {
        CryptfolioDBHelper dbHelper = new CryptfolioDBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(ExchangesEntry.TABLE_NAME, null, null, null, null, null, null);
        db.beginTransaction();
        for (Exchange exchange : exchanges) {
            ContentValues cv = new ContentValues();
            cv.put(ExchangesEntry.COLUMN_EXCHANGE_NAME, exchange.getExchangeName());
            ArrayList<Crypto> cryptos = exchange.getCryptos();
            for (Crypto crypto : cryptos) {
                String sanitizedName = crypto.getCoinName().replace("*", "");
                Log.i("TEST", "symbol_" + sanitizedName);
                if (cursor.getColumnIndex("symbol_" + sanitizedName) != -1) {
                    cv.put("symbol_" + sanitizedName, crypto.getPairs().toString());
                }
            }
            db.insert(ExchangesEntry.TABLE_NAME, null, cv);
        }
        cursor.close();
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public static ArrayList<String> getExchangeNamesForSpinner(Context context, Coin coin) {
        ArrayList<String> exchangeNames = new ArrayList<>();
        CryptfolioDBHelper dbHelper = new CryptfolioDBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] projection = {ExchangesEntry.COLUMN_EXCHANGE_NAME};
        Cursor cursor = db.rawQuery("SELECT * FROM "
                + ExchangesEntry.TABLE_NAME + " WHERE "
                + "symbol_" + coin.getSymbol()
                + " IS NOT NULL ORDER BY "
                + ExchangesEntry.COLUMN_EXCHANGE_NAME
                + " ASC", null);

        while (cursor.moveToNext()) {
            String exchangeName = cursor.getString(cursor.getColumnIndex(ExchangesEntry.COLUMN_EXCHANGE_NAME));
            exchangeNames.add(exchangeName);
        }
        cursor.close();
        return exchangeNames;
    }
}

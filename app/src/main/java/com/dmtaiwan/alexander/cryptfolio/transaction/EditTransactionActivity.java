package com.dmtaiwan.alexander.cryptfolio.transaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBContract;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBHelper;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.utilities.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Alexander on 1/8/2018.
 */

public class EditTransactionActivity extends AppCompatActivity implements View.OnClickListener{

    private Coin coin;
    private TextView textViewCoinName;
    private TextView buttonBuy;
    private TextView buttonSell;
    private EditText editTextPrice;
    private EditText editTextAmount;
    private TextView textViewDate;
    private TextView buttonAddTransaction;

    //Spinners
    private Spinner exchangeSpinner;
    private Spinner tradingPairSpinner;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_transaction);

        //Get coin
        Intent intent = getIntent();
        coin = intent.getParcelableExtra(Utils.KEY_COIN);



        //Set up views
        textViewCoinName = findViewById(R.id.edit_transaction_text_view_coin_name);
        textViewCoinName.setText(coin.getName());

        buttonBuy = findViewById(R.id.edit_transaction_text_view_buy);
        buttonBuy.setOnClickListener(this);
        buttonSell = findViewById(R.id.edit_transaction_text_view_sell);
        buttonSell.setOnClickListener(this);
        editTextPrice = findViewById(R.id.edit_transaction_edit_text_price);
        editTextAmount = findViewById(R.id.edit_transaction_edit_text_amount);
        textViewDate = findViewById(R.id.edit_transaction_text_view_date);
        buttonAddTransaction = findViewById(R.id.edit_transaction_text_view_add_transaction);

        tradingPairSpinner = findViewById(R.id.edit_transaction_spinner_trading_pair);

        //Setup exchange spinner
        exchangeSpinner = findViewById(R.id.edit_transaction_spinner_exchanges);
        ArrayList<String> exchangeNames = CryptfolioDBHelper.getExchangeNamesForSpinner(this, coin);
        final ArrayAdapter exchangeAdapter = new ArrayAdapter(this, R.layout.spinner_item, exchangeNames);
        exchangeAdapter.setDropDownViewResource(R.layout.spinner_drop_down_item);
        exchangeSpinner.setAdapter(exchangeAdapter);
        exchangeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String exchange = (String) exchangeAdapter.getItem(i);
                setupTradingPairs(exchange);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_transaction_text_view_buy:
                buttonBuy.setBackgroundColor(getResources().getColor(R.color.colorTextBuy));
                buttonSell.setBackgroundColor(Color.TRANSPARENT);
                buttonAddTransaction.setBackgroundColor(getResources().getColor(R.color.colorTextBuy));
                break;
            case R.id.edit_transaction_text_view_sell:
                buttonSell.setBackgroundColor(getResources().getColor(R.color.colorTextSell));
                buttonBuy.setBackgroundColor(Color.TRANSPARENT);
                buttonAddTransaction.setBackgroundColor(getResources().getColor(R.color.colorTextSell));
                break;
        }
    }

    private void setupTradingPairs(String exchange) {
        String whereClause = CryptfolioDBContract.ExchangesEntry.COLUMN_EXCHANGE_NAME + "=?";
        String[] whereArgs = {exchange};
        CryptfolioDBHelper dbHelper = new CryptfolioDBHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(CryptfolioDBContract.ExchangesEntry.TABLE_NAME, null, whereClause, whereArgs, null, null, null);
        cursor.moveToFirst();

        //Fetch pairs
        String symbol = coin.getSymbol();
        String name = "symbol_" + symbol;
        String list = cursor.getString(cursor.getColumnIndex(name));
        if (list != null) {
            String sanitized = list.replace("[", "").replace("]", "").replace(" ", "");
            ArrayList<String> pairs = new ArrayList<>(Arrays.asList(sanitized.split(",")));
            ArrayList<String> completePairs = new ArrayList();
            for (String currency : pairs) {
                completePairs.add(coin.getSymbol() + "/" + currency);
            }
            //Sort currencies
            Collections.sort(completePairs, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return s.compareToIgnoreCase(t1);
                }
            });
            final ArrayAdapter tradingPairAdapter = new ArrayAdapter(this, R.layout.spinner_item, completePairs);
            tradingPairAdapter.setDropDownViewResource(R.layout.spinner_drop_down_item);
            tradingPairSpinner.setAdapter(tradingPairAdapter);
        }


        cursor.close();
    }
}

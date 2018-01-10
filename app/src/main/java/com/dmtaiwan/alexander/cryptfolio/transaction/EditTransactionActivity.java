package com.dmtaiwan.alexander.cryptfolio.transaction;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBHelper;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.utilities.Utils;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Alexander on 1/8/2018.
 */

public class EditTransactionActivity extends AppCompatActivity implements View.OnClickListener, android.app.DatePickerDialog.OnDateSetListener{

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

        //Get current time/date and set default value
        textViewDate.setText(Utils.getFormattedDate(Calendar.getInstance().getTime()));
        textViewDate.setOnClickListener(this);
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
            case R.id.edit_transaction_text_view_date:
                Calendar currentTime = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog(
                        this,
                        this,
                        currentTime.get(Calendar.YEAR),
                        currentTime.get(Calendar.MONTH),
                        currentTime.get(Calendar.DAY_OF_MONTH));
                dpd.show();
        }
    }

    private void setupTradingPairs(String exchange) {
        ArrayList<String> tradingPairs = CryptfolioDBHelper.createTradingPairs(exchange, coin.getSymbol(), this);
        final ArrayAdapter tradingPairAdapter = new ArrayAdapter(this, R.layout.spinner_item, tradingPairs);
        tradingPairAdapter.setDropDownViewResource(R.layout.spinner_drop_down_item);
        tradingPairSpinner.setAdapter(tradingPairAdapter);
    }



    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }
}

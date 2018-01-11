package com.dmtaiwan.alexander.cryptfolio.transaction;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBHelper;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.models.Transaction;
import com.dmtaiwan.alexander.cryptfolio.utilities.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Alexander on 1/8/2018.
 */

public class EditTransactionActivity extends AppCompatActivity implements View.OnClickListener, android.app.DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    private Coin coin;
    private TextView textViewCoinName;
    private TextView buttonBuy;
    private TextView buttonSell;
    private EditText editTextPrice;
    private EditText editTextAmount;
    private TextView textViewDate;
    private TextView buttonAddTransaction;
    private Calendar selectedTime;
    private String exchange;
    private String tradingPair;

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
        buttonAddTransaction.setOnClickListener(this);

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
                exchange = (String) exchangeAdapter.getItem(i);
                setupTradingPairs(exchange);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Get current time/date and set default value
        selectedTime = Calendar.getInstance();
        textViewDate.setText(Utils.getFormattedDate(selectedTime.getTime()));
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
                break;
            case R.id.edit_transaction_text_view_add_transaction:
                insertTransaction();
                break;
        }
    }

    private void setupTradingPairs(String exchange) {
        ArrayList<String> tradingPairs = CryptfolioDBHelper.createTradingPairs(exchange, coin.getSymbol(), this);
        final ArrayAdapter tradingPairAdapter = new ArrayAdapter(this, R.layout.spinner_item, tradingPairs);
        tradingPairAdapter.setDropDownViewResource(R.layout.spinner_drop_down_item);
        tradingPairSpinner.setAdapter(tradingPairAdapter);
        tradingPairSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tradingPair = (String) tradingPairAdapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void insertTransaction() {
        String currencyName = coin.getName();
        String symbol = coin.getSymbol();
        String exchangeName = exchange;
        String tradingPairName = tradingPair;
        String price = editTextPrice.getText().toString().trim();
        String amount = editTextAmount.getText().toString().trim();
        long timeInMillis = selectedTime.getTimeInMillis();
        if (exchangeName.isEmpty() || price.isEmpty() || amount.isEmpty() || tradingPairName.isEmpty()) {
            Log.i("FAIL", "FAIL");
        }else{
            BigDecimal decimalPrice = new BigDecimal(price);
            BigDecimal decimalAmount = new BigDecimal(amount);
            Transaction transaction = new Transaction(currencyName, symbol, exchangeName, tradingPairName, decimalPrice, decimalAmount, timeInMillis);
            CryptfolioDBHelper.insertTransactionIntoDatabase(transaction, this);
            finish();
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        selectedTime.set(year, month, dayOfMonth);
        Calendar currentTime = Calendar.getInstance();
        TimePickerDialog tpd = new TimePickerDialog(
                this,
                this,
                currentTime.get(Calendar.HOUR_OF_DAY),
                currentTime.get(Calendar.MINUTE),
                true);
        tpd.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        selectedTime.set(Calendar.MINUTE, minute);
        textViewDate.setText(Utils.getFormattedDate(selectedTime.getTime()));
    }
}

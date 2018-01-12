package com.dmtaiwan.alexander.cryptfolio.transaction;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.main.SettingsFragment;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.models.Transaction;
import com.dmtaiwan.alexander.cryptfolio.utilities.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by AlexThinkPad on 1/11/2018.
 */

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private ArrayList<Transaction> transactions;
    private Coin coin;
    private String preferredCurrency = SettingsFragment.CAD;

    public TransactionAdapter(Coin coin) {
        this.coin = coin;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rootView = inflater.inflate(R.layout.list_item_transaction, parent, false);
        ViewHolder holder = new ViewHolder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Transaction transaction = transactions.get(position);


        //Set price label & price
        holder.buyPriceLabel.setText(transaction.getCurrencySymbol() + " Buy Price");
        holder.buyPrice.setText(Utils.formatCurrency(transaction.getPurchasePrice().toPlainString(), preferredCurrency));

        //Set trading pair
        holder.tradingPair.setText(transaction.getTradingPair());

        //set amount purchased
        holder.amountPurchased.setText(transaction.getPurchaseAmount().toPlainString());

        //set current worth
        BigDecimal currentPrice = new BigDecimal(coin.getPrice_usd());
        BigDecimal amount = transaction.getPurchaseAmount();
        BigDecimal currentWorth = currentPrice.multiply(amount);
        holder.worth.setText(currentWorth.toPlainString());

        //set percent change
        BigDecimal purchasePrice = transaction.getPurchasePrice();
        BigDecimal purchaseWorth = purchasePrice.multiply(amount);
        BigDecimal percentChange = purchaseWorth.divide(currentWorth, 10, RoundingMode.HALF_UP);
        holder.percentChange.setText(Utils.formatPercentage(percentChange.toPlainString()));
    }

    @Override
    public int getItemCount() {
        if (transactions == null) {
            return 0;
        }
        return transactions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView buyPriceLabel;
        public TextView buyPrice;

        public TextView tradingPair;

        public TextView amountPurchased;

        public TextView worth;
        public TextView percentChange;

        public ViewHolder(View itemView) {
            super(itemView);
            buyPriceLabel = itemView.findViewById(R.id.list_item_transaction_crypto_buy_price_label);
            buyPrice = itemView.findViewById(R.id.list_item_transaction_crypto_buy_price);
            tradingPair = itemView.findViewById(R.id.list_item_transaction_trading_pair);
            amountPurchased = itemView.findViewById(R.id.list_item_transaction_amount);
            worth = itemView.findViewById(R.id.list_item_transaction_worth);
            percentChange = itemView.findViewById(R.id.list_item_transaction_percent_change);
        }
    }

    public void swapData(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
        notifyDataSetChanged();
    }

}

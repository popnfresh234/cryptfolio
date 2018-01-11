package com.dmtaiwan.alexander.cryptfolio.main;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.models.Holding;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Alexander on 1/10/2018.
 */

public class HoldingAdapter extends RecyclerView.Adapter<HoldingAdapter.ViewHolder> {

    private ArrayList<Holding> holdings;
    private ArrayList<Coin> coins;
    private Context context;

    public HoldingAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rootView = inflater.inflate(R.layout.list_item_holding, parent, false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (position % 2 == 0) {
            holder.rootView.setBackgroundColor(context.getResources().getColor(R.color.colorListViewAlternate));
        } else holder.rootView.setBackgroundColor(Color.TRANSPARENT);

        Holding holding = holdings.get(position);
        holder.currencyName.setText(holding.getCurrencyName());
        holder.cryptoAmount.setText(holding.getAmount().toPlainString());

        String symbol = holding.getCurrencySymbol();
        if (coins != null) {

            for (Coin coin : coins) {
                if (coin.getSymbol().equals(symbol)) {
                    holder.fiatPrice.setText(coin.getPrice_cad());
                    holder.percentChange.setText(coin.getPercent_change_twenty_four_hour());

                    //Calculate fiat change
                    BigDecimal bigDecimalPercentage = new BigDecimal(coin.getPercent_change_twenty_four_hour());
                    String fiatChange = bigDecimalPercentage.multiply(holding.getAmount()).toPlainString();
                    holder.fiatChange.setText(fiatChange);
                }
            }

        }
    }

    @Override
    public int getItemCount() {
        if (holdings == null) {
            return 0;
        }
        return holdings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout rootView;
        public TextView currencyName;
        public TextView fiatChange;
        public TextView cryptoAmount;
        public TextView fiatAmount;
        public TextView fiatPrice;
        public TextView percentChange;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView.findViewById(R.id.constraint_layout_holding_list_item);
            currencyName = itemView.findViewById(R.id.text_view_holding_list_item_currency_label);
            fiatChange = itemView.findViewById(R.id.text_view_holding_list_item_fiat_change);
            cryptoAmount = itemView.findViewById(R.id.text_view_holding_list_item_crypto_amount);
            fiatAmount = itemView.findViewById(R.id.text_view_holding_list_item_fiat_amount);
            fiatPrice = itemView.findViewById(R.id.text_view_holding_list_item_fiat_price);
            percentChange = itemView.findViewById(R.id.text_view_holding_list_item_percent_change);
        }
    }

    public void swapData(ArrayList<Holding> holdings) {
        this.holdings = holdings;
        notifyDataSetChanged();
    }

    public void updateCoinData(ArrayList<Coin> coins) {
        this.coins = coins;
        notifyDataSetChanged();
    }

}

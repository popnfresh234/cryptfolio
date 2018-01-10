package com.dmtaiwan.alexander.cryptfolio.find_coin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.transaction.EditTransactionActivity;
import com.dmtaiwan.alexander.cryptfolio.utilities.Utils;

import java.util.ArrayList;


/**
 * Created by Alexander on 1/8/2018.
 */

public class FindCoinAdapter extends RecyclerView.Adapter<FindCoinAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Coin> coins;

    public FindCoinAdapter(Context context, ArrayList<Coin> coins) {
        this.context = context;
        this.coins = coins;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rootView = inflater.inflate(R.layout.list_item_find_coin, parent, false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        final Coin coin = coins.get(position);
        //setup alternating colors for background
        if (position % 2 == 0) {
            holder.rootView.setBackgroundColor(context.getResources().getColor(R.color.colorListViewAlternate));
        } else holder.rootView.setBackgroundColor(Color.TRANSPARENT);


        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditTransactionActivity.class);
                intent.putExtra(Utils.KEY_COIN, coin);
                context.startActivity(intent);
            }
        });
        holder.coinName.setText(coin.getName());
        holder.coinSymbol.setText(coin.getSymbol());

    }

    @Override
    public int getItemCount(){
        if (coins == null) {
            return 0;
        }
        return coins.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView coinName;
        public TextView coinSymbol;
        public LinearLayout rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            coinName = itemView.findViewById(R.id.text_view_list_item_coin_name);
            coinSymbol = itemView.findViewById(R.id.text_view_list_item_coin_symbol);
            rootView = itemView.findViewById(R.id.linear_layout_find_coin);
        }
    }

    public void swapCursor(ArrayList<Coin> coins) {
        this.coins = coins;
        notifyDataSetChanged();
    }

}

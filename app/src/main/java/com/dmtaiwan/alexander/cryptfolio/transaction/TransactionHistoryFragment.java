package com.dmtaiwan.alexander.cryptfolio.transaction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmtaiwan.alexander.cryptfolio.R;
import com.dmtaiwan.alexander.cryptfolio.data.CryptfolioDBHelper;
import com.dmtaiwan.alexander.cryptfolio.models.Coin;
import com.dmtaiwan.alexander.cryptfolio.models.Transaction;
import com.dmtaiwan.alexander.cryptfolio.utilities.Utils;

import java.util.ArrayList;

/**
 * Created by Alexander on 1/8/2018.
 */

public class TransactionHistoryFragment extends Fragment{

    private Coin coin;
    private TransactionAdapter adapter;

    public static TransactionHistoryFragment newInstance(Coin coin) {
        TransactionHistoryFragment fragment = new TransactionHistoryFragment();
        Bundle args = new Bundle();
        args.putParcelable(Utils.KEY_COIN, coin);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Coin coin = getArguments().getParcelable(Utils.KEY_COIN);
        View rootView = inflater.inflate(R.layout.fragment_transaction_history, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.transaction_recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        TransactionAdapter adapter = new TransactionAdapter(coin);
        recyclerView.setAdapter(adapter);
        ArrayList<Transaction> transactions = CryptfolioDBHelper.getTransactionsForSpecificCoin(coin.getSymbol(), getActivity());
        adapter.swapData(transactions);


        return rootView;
    }
}

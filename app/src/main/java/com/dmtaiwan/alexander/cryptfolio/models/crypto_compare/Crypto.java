package com.dmtaiwan.alexander.cryptfolio.models.crypto_compare;

import java.util.ArrayList;

/**
 * Created by Alexander on 1/9/2018.
 */

public class Crypto {


    String coinName;
    ArrayList<String> pairs;


    public Crypto(String coinName, ArrayList<String> pairs) {
        this.coinName = coinName;
        this.pairs = pairs;
    }



    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public ArrayList<String> getPairs() {
        return pairs;
    }

    public void setPairs(ArrayList<String> pairs) {
        this.pairs = pairs;
    }
}

package com.dmtaiwan.alexander.cryptfolio.models.crypto_compare;

import java.util.ArrayList;

/**
 * Created by Alexander on 1/9/2018.
 */

public class Exchange {
    private String exchangeName;
    private ArrayList<Crypto> cryptos;

    public Exchange(String exchangeName, ArrayList<Crypto> cryptos) {
        this.exchangeName = exchangeName;
        this.cryptos = cryptos;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public ArrayList<Crypto> getCryptos() {
        return cryptos;
    }

    public void setCryptos(ArrayList<Crypto> cryptos) {
        this.cryptos = cryptos;
    }
}

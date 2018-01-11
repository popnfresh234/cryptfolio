package com.dmtaiwan.alexander.cryptfolio.models;

import java.math.BigDecimal;

/**
 * Created by Alexander on 1/10/2018.
 */

public class Holding {
    private String currencyName;
    private String currencySymbol;
    private BigDecimal amount;

    public Holding(String currencyName, String currencySymbol, BigDecimal amount) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.amount = amount;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

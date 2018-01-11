package com.dmtaiwan.alexander.cryptfolio.models;

import java.math.BigDecimal;

/**
 * Created by Alexander on 1/10/2018.
 */

public class Transaction {
    private String currencyName;
    private String currencySymbol;
    private String exchangeName;
    private String tradingPair;
    private BigDecimal purchasePrice;
    private BigDecimal purchaseAmount;
    private Long purchaseDate;

    public Transaction(String currencyName, String currencySymbol, String exchangeName, String tradingPair, BigDecimal purchasePrice, BigDecimal purchaseAmount, Long purchaseDate) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.exchangeName = exchangeName;
        this.tradingPair = tradingPair;
        this.purchasePrice = purchasePrice;
        this.purchaseAmount = purchaseAmount;
        this.purchaseDate = purchaseDate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getTradingPair() {
        return tradingPair;
    }

    public void setTradingPair(String tradingPair) {
        this.tradingPair = tradingPair;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}

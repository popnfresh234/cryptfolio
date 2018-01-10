package com.dmtaiwan.alexander.cryptfolio.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexander on 1/8/2018.
 */

public class Coin implements Parcelable {

    private String id;
    private String name;
    private String symbol;
    private String rank;
    private String price_usd;
    private String price_btc;

    @SerializedName("24h_volume_usd")
    private String twenty_four_hour_volume_usd;
    private String market_cap_usd;
    private String available_supply;
    private String total_supply;

    @SerializedName("percent_change_1h")
    private String percent_change_one_hour;

    @SerializedName("percent_change_24h")
    private String percent_change_twenty_four_hour;

    @SerializedName("percent_change_7d")
    private String percent_change_seven_days;

    private String last_updated;


    private String price_aud;
    private String price_brl;
    private String price_cad;
    private String price_chf;
    private String price_clp;
    private String price_cny;
    private String price_czk;
    private String price_dkk;
    private String price_eur;
    private String price_gbp;
    private String price_hkd;
    private String price_huf;
    private String price_idr;
    private String price_ils;
    private String price_inr;
    private String price_jpy;
    private String price_krw;
    private String price_mxn;
    private String price_myr;
    private String price_nok;
    private String price_nzd;
    private String price_php;
    private String price_pkr;
    private String price_pln;
    private String price_rub;
    private String price_sek;
    private String price_sgd;
    private String price_thb;
    private String price_try;
    private String price_twd;
    private String price_zar;

    public Coin(String id, String name, String symbol, String rank, String price_usd,
                String price_btc, String twenty_four_hour_volume_usd, String market_cap_usd,
                String available_supply, String total_supply, String percent_change_one_hour,
                String percent_change_twenty_four_hour, String percent_change_seven_days,
                String last_updated, String price_aud, String price_brl, String price_cad, String price_chf,
                String price_clp, String price_cny, String price_czk, String price_dkk, String price_eur,
                String price_gbp, String price_hkd, String price_huf, String price_idr, String price_ils,
                String price_inr, String price_jpy, String price_krw, String price_mxn, String price_myr,
                String price_nok, String price_nzd, String price_php, String price_pkr, String price_pln,
                String price_rub, String price_sek, String price_sgd, String price_thb, String price_try,
                String price_twd, String price_zar) {

        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.price_usd = price_usd;
        this.price_btc = price_btc;
        this.twenty_four_hour_volume_usd = twenty_four_hour_volume_usd;
        this.market_cap_usd = market_cap_usd;
        this.available_supply = available_supply;
        this.total_supply = total_supply;
        this.percent_change_one_hour = percent_change_one_hour;
        this.percent_change_twenty_four_hour = percent_change_twenty_four_hour;
        this.percent_change_seven_days = percent_change_seven_days;
        this.last_updated = last_updated;
        this.price_aud = price_aud;
        this.price_brl = price_brl;
        this.price_cad = price_cad;
        this.price_chf = price_chf;
        this.price_clp = price_clp;
        this.price_cny = price_cny;
        this.price_czk = price_czk;
        this.price_dkk = price_dkk;
        this.price_eur = price_eur;
        this.price_gbp = price_gbp;
        this.price_hkd = price_hkd;
        this.price_huf = price_huf;
        this.price_idr = price_idr;
        this.price_ils = price_ils;
        this.price_inr = price_inr;
        this.price_jpy = price_jpy;
        this.price_krw = price_krw;
        this.price_mxn = price_mxn;
        this.price_myr = price_myr;
        this.price_nok = price_nok;
        this.price_nzd = price_nzd;
        this.price_php = price_php;
        this.price_pkr = price_pkr;
        this.price_pln = price_pln;
        this.price_rub = price_rub;
        this.price_sek = price_sek;
        this.price_sgd = price_sgd;
        this.price_thb = price_thb;
        this.price_try = price_try;
        this.price_twd = price_twd;
        this.price_zar = price_zar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = price_usd;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(String price_btc) {
        this.price_btc = price_btc;
    }

    public String getTwenty_four_hour_volume_usd() {
        return twenty_four_hour_volume_usd;
    }

    public void setTwenty_four_hour_volume_usd(String twenty_four_hour_volume_usd) {
        this.twenty_four_hour_volume_usd = twenty_four_hour_volume_usd;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public String getAvailable_supply() {
        return available_supply;
    }

    public void setAvailable_supply(String available_supply) {
        this.available_supply = available_supply;
    }

    public String getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(String total_supply) {
        this.total_supply = total_supply;
    }

    public String getPercent_change_one_hour() {
        return percent_change_one_hour;
    }

    public void setPercent_change_one_hour(String percent_change_one_hour) {
        this.percent_change_one_hour = percent_change_one_hour;
    }

    public String getPercent_change_twenty_four_hour() {
        return percent_change_twenty_four_hour;
    }

    public void setPercent_change_twenty_four_hour(String percent_change_twenty_four_hour) {
        this.percent_change_twenty_four_hour = percent_change_twenty_four_hour;
    }

    public String getPercent_change_seven_days() {
        return percent_change_seven_days;
    }

    public void setPercent_change_seven_days(String percent_change_seven_days) {
        this.percent_change_seven_days = percent_change_seven_days;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getPrice_aud() {
        return price_aud;
    }

    public void setPrice_aud(String price_aud) {
        this.price_aud = price_aud;
    }

    public String getPrice_brl() {
        return price_brl;
    }

    public void setPrice_brl(String price_brl) {
        this.price_brl = price_brl;
    }

    public String getPrice_cad() {
        return price_cad;
    }

    public void setPrice_cad(String price_cad) {
        this.price_cad = price_cad;
    }

    public String getPrice_chf() {
        return price_chf;
    }

    public void setPrice_chf(String price_chf) {
        this.price_chf = price_chf;
    }

    public String getPrice_clp() {
        return price_clp;
    }

    public void setPrice_clp(String price_clp) {
        this.price_clp = price_clp;
    }

    public String getPrice_cny() {
        return price_cny;
    }

    public void setPrice_cny(String price_cny) {
        this.price_cny = price_cny;
    }

    public String getPrice_czk() {
        return price_czk;
    }

    public void setPrice_czk(String price_czk) {
        this.price_czk = price_czk;
    }

    public String getPrice_dkk() {
        return price_dkk;
    }

    public void setPrice_dkk(String price_dkk) {
        this.price_dkk = price_dkk;
    }

    public String getPrice_eur() {
        return price_eur;
    }

    public void setPrice_eur(String price_eur) {
        this.price_eur = price_eur;
    }

    public String getPrice_gbp() {
        return price_gbp;
    }

    public void setPrice_gbp(String price_gbp) {
        this.price_gbp = price_gbp;
    }

    public String getPrice_hkd() {
        return price_hkd;
    }

    public void setPrice_hkd(String price_hkd) {
        this.price_hkd = price_hkd;
    }

    public String getPrice_huf() {
        return price_huf;
    }

    public void setPrice_huf(String price_huf) {
        this.price_huf = price_huf;
    }

    public String getPrice_idr() {
        return price_idr;
    }

    public void setPrice_idr(String price_idr) {
        this.price_idr = price_idr;
    }

    public String getPrice_ils() {
        return price_ils;
    }

    public void setPrice_ils(String price_ils) {
        this.price_ils = price_ils;
    }

    public String getPrice_inr() {
        return price_inr;
    }

    public void setPrice_inr(String price_inr) {
        this.price_inr = price_inr;
    }

    public String getPrice_jpy() {
        return price_jpy;
    }

    public void setPrice_jpy(String price_jpy) {
        this.price_jpy = price_jpy;
    }

    public String getPrice_krw() {
        return price_krw;
    }

    public void setPrice_krw(String price_krw) {
        this.price_krw = price_krw;
    }

    public String getPrice_mxn() {
        return price_mxn;
    }

    public void setPrice_mxn(String price_mxn) {
        this.price_mxn = price_mxn;
    }

    public String getPrice_myr() {
        return price_myr;
    }

    public void setPrice_myr(String price_myr) {
        this.price_myr = price_myr;
    }

    public String getPrice_nok() {
        return price_nok;
    }

    public void setPrice_nok(String price_nok) {
        this.price_nok = price_nok;
    }

    public String getPrice_nzd() {
        return price_nzd;
    }

    public void setPrice_nzd(String price_nzd) {
        this.price_nzd = price_nzd;
    }

    public String getPrice_php() {
        return price_php;
    }

    public void setPrice_php(String price_php) {
        this.price_php = price_php;
    }

    public String getPrice_pkr() {
        return price_pkr;
    }

    public void setPrice_pkr(String price_pkr) {
        this.price_pkr = price_pkr;
    }

    public String getPrice_pln() {
        return price_pln;
    }

    public void setPrice_pln(String price_pln) {
        this.price_pln = price_pln;
    }

    public String getPrice_rub() {
        return price_rub;
    }

    public void setPrice_rub(String price_rub) {
        this.price_rub = price_rub;
    }

    public String getPrice_sek() {
        return price_sek;
    }

    public void setPrice_sek(String price_sek) {
        this.price_sek = price_sek;
    }

    public String getPrice_sgd() {
        return price_sgd;
    }

    public void setPrice_sgd(String price_sgd) {
        this.price_sgd = price_sgd;
    }

    public String getPrice_thb() {
        return price_thb;
    }

    public void setPrice_thb(String price_thb) {
        this.price_thb = price_thb;
    }

    public String getPrice_try() {
        return price_try;
    }

    public void setPrice_try(String price_try) {
        this.price_try = price_try;
    }

    public String getPrice_twd() {
        return price_twd;
    }

    public void setPrice_twd(String price_twd) {
        this.price_twd = price_twd;
    }

    public String getPrice_zar() {
        return price_zar;
    }

    public void setPrice_zar(String price_zar) {
        this.price_zar = price_zar;
    }

    protected Coin(Parcel in) {
        id = in.readString();
        name = in.readString();
        symbol = in.readString();
        rank = in.readString();
        price_usd = in.readString();
        price_btc = in.readString();
        twenty_four_hour_volume_usd = in.readString();
        market_cap_usd = in.readString();
        available_supply = in.readString();
        total_supply = in.readString();
        percent_change_one_hour = in.readString();
        percent_change_twenty_four_hour = in.readString();
        percent_change_seven_days = in.readString();
        last_updated = in.readString();
        price_aud = in.readString();
        price_brl = in.readString();
        price_cad = in.readString();
        price_chf = in.readString();
        price_clp = in.readString();
        price_cny = in.readString();
        price_czk = in.readString();
        price_dkk = in.readString();
        price_eur = in.readString();
        price_gbp = in.readString();
        price_hkd = in.readString();
        price_huf = in.readString();
        price_idr = in.readString();
        price_ils = in.readString();
        price_inr = in.readString();
        price_jpy = in.readString();
        price_krw = in.readString();
        price_mxn = in.readString();
        price_myr = in.readString();
        price_nok = in.readString();
        price_nzd = in.readString();
        price_php = in.readString();
        price_pkr = in.readString();
        price_pln = in.readString();
        price_rub = in.readString();
        price_sek = in.readString();
        price_sgd = in.readString();
        price_thb = in.readString();
        price_try = in.readString();
        price_twd = in.readString();
        price_zar = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(symbol);
        dest.writeString(rank);
        dest.writeString(price_usd);
        dest.writeString(price_btc);
        dest.writeString(twenty_four_hour_volume_usd);
        dest.writeString(market_cap_usd);
        dest.writeString(available_supply);
        dest.writeString(total_supply);
        dest.writeString(percent_change_one_hour);
        dest.writeString(percent_change_twenty_four_hour);
        dest.writeString(percent_change_seven_days);
        dest.writeString(last_updated);
        dest.writeString(price_aud);
        dest.writeString(price_brl);
        dest.writeString(price_cad);
        dest.writeString(price_chf);
        dest.writeString(price_clp);
        dest.writeString(price_cny);
        dest.writeString(price_czk);
        dest.writeString(price_dkk);
        dest.writeString(price_eur);
        dest.writeString(price_gbp);
        dest.writeString(price_hkd);
        dest.writeString(price_huf);
        dest.writeString(price_idr);
        dest.writeString(price_ils);
        dest.writeString(price_inr);
        dest.writeString(price_jpy);
        dest.writeString(price_krw);
        dest.writeString(price_mxn);
        dest.writeString(price_myr);
        dest.writeString(price_nok);
        dest.writeString(price_nzd);
        dest.writeString(price_php);
        dest.writeString(price_pkr);
        dest.writeString(price_pln);
        dest.writeString(price_rub);
        dest.writeString(price_sek);
        dest.writeString(price_sgd);
        dest.writeString(price_thb);
        dest.writeString(price_try);
        dest.writeString(price_twd);
        dest.writeString(price_zar);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Coin> CREATOR = new Parcelable.Creator<Coin>() {
        @Override
        public Coin createFromParcel(Parcel in) {
            return new Coin(in);
        }

        @Override
        public Coin[] newArray(int size) {
            return new Coin[size];
        }
    };
}
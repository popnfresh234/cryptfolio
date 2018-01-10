package com.dmtaiwan.alexander.cryptfolio.data;

import android.provider.BaseColumns;

/**
 * Created by Alexander on 1/8/2018.
 */

public class CryptfolioDBContract {
    private CryptfolioDBContract() {

        //Empty constructor so we don't instantiate this class
    }

    public static final class CoinMarketCapEntry implements BaseColumns {
        public static final String TABLE_NAME = "coin_market_cap";

        public static final String COLUMN_COIN_ID = "id";
        public static final String COLUMN_NAME = "coinName";
        public static final String COLUMN_SYMBOL = "symbol";
        public static final String COLUMN_RANK = "rank";
        public static final String COLUMN_PRICE_USD = "price_usd";
        public static final String COLUMN_PRICE_BTC = "price_btc";
        public static final String COLUMN_24H_VOLUME_USD = "twenty_four_hour_volume_usd";
        public static final String COLUMN_MARKET_CAP_USD = "market_cap_usd";
        public static final String COLUMN_AVAILABLE_SUPPLY = "available_supply";
        public static final String COLUMN_TOTAL_SUPPLY = "total_supply";
        public static final String COLUMN_PERCENT_CHANGE_1H = "percent_change_one_hour";
        public static final String COLUMN_PERCENT_CHANGE_24H = "percent_change_twenty_four_hour";
        public static final String COLUMN_PERCENT_CHANGE_7D = "percent_change_seven_day";
        public static final String COLUMN_LAST_UPDATED = "last_updated";
        public static final String COLUMN_PRICE_AUD = "price_aud";
        public static final String COLUMN_PRICE_BRL = "price_brl";
        public static final String COLUMN_PRICE_CAD = "price_cad";
        public static final String COLUMN_PRICE_CHF = "price_chf";
        public static final String COLUMN_PRICE_CLP = "price_clp";
        public static final String COLUMN_PRICE_CNY = "price_cny";
        public static final String COLUMN_PRICE_CZK = "price_czk";
        public static final String COLUMN_PRICE_DKK = "price_dkk";
        public static final String COLUMN_PRICE_EUR = "price_eur";
        public static final String COLUMN_PRICE_GBP = "price_gbp";
        public static final String COLUMN_PRICE_HKD = "price_hkd";
        public static final String COLUMN_PRICE_HUF = "price_huf";
        public static final String COLUMN_PRICE_IDR = "price_idr";
        public static final String COLUMN_PRICE_ILS = "price_ils";
        public static final String COLUMN_PRICE_INR = "price_inr";
        public static final String COLUMN_PRICE_JPY = "price_jpy";
        public static final String COLUMN_PRICE_KRW = "price_krw";
        public static final String COLUMN_PRICE_MXN = "price_mxn";
        public static final String COLUMN_PRICE_MYR = "price_myr";
        public static final String COLUMN_PRICE_NOK = "price_nok";
        public static final String COLUMN_PRICE_NZD = "price_nzd";
        public static final String COLUMN_PRICE_PHP = "price_php";
        public static final String COLUMN_PRICE_PKR = "price_pkr";
        public static final String COLUMN_PRICE_PLN = "price_pln";
        public static final String COLUMN_PRICE_RUB = "price_rub";
        public static final String COLUMN_PRICE_SEK = "price_sek";
        public static final String COLUMN_PRICE_SGD = "price_sgd";
        public static final String COLUMN_PRICE_THB = "price_thb";
        public static final String COLUMN_PRICE_TRY = "price_try";
        public static final String COLUMN_PRICE_TWD = "price_twd";
        public static final String COLUMN_PRICE_ZAR = "price_zar";
    }

    public static final class TransactionEntry implements BaseColumns {
        public static final String TABLE_NAME = "transaction_data";

        public static final String COLUMN_CURRENCY = "currency";
        public static final String COLUMN_EXCHANGE_NAME = "exchange_name";
        public static final String COLUMN_TRADING_PAIR = "trading_pair";
        public static final String COLUMN_PURCHASE_PRICE = "purchase_price";
        public static final String COLUMN_PURCHASE_AMOUNT = "purchase_amount";
        public static final String COLUMN_PURCHASE_DATE = "purchase_date";
    }

    public static final class ExchangesEntry implements BaseColumns {

        public static final String TABLE_NAME = "exchange_data";


        public static final String COLUMN_EXCHANGE_NAME = "exchange_name";

        public static final String COLUMN_BTC = "symbol_BTC";
        public static final String COLUMN_ETH = "symbol_ETH";
        public static final String COLUMN_XRP = "symbol_XRP";
        public static final String COLUMN_BCH = "symbol_BCH";
        public static final String COLUMN_ADA = "symbol_ADA";
        public static final String COLUMN_XEM = "symbol_XEM";
        public static final String COLUMN_LTC = "symbol_LTC";
        public static final String COLUMN_XLM = "symbol_XLM";
        public static final String COLUMN_MIOTA = "symbol_IOTA";
        public static final String COLUMN_DASH = "symbol_DASH";
        public static final String COLUMN_NEO = "symbol_NEO";
        public static final String COLUMN_TRX = "symbol_TRX";
        public static final String COLUMN_XMR = "symbol_XMR";
        public static final String COLUMN_EOS = "symbol_EOS";
        public static final String COLUMN_ICX = "symbol_ICX";
        public static final String COLUMN_QTUM = "symbol_QTUM";
        public static final String COLUMN_BTG = "symbol_BTG";
        public static final String COLUMN_XRB = "symbol_XRB";
        public static final String COLUMN_ETC = "symbol_ETC";
        public static final String COLUMN_LSK = "symbol_LSK";
        public static final String COLUMN_XVG = "symbol_XVG";
        public static final String COLUMN_OMG = "symbol_OMG";
        public static final String COLUMN_SC = "symbol_SC";
        public static final String COLUMN_BCN = "symbol_BCN";
        public static final String COLUMN_BCC = "symbol_BCC";
        public static final String COLUMN_ZEC = "symbol_ZEC";
        public static final String COLUMN_PPT = "symbol_PPT";
        public static final String COLUMN_STRAT = "symbol_STRAT";
        public static final String COLUMN_BTS = "symbol_BTS";
        public static final String COLUMN_BNB = "symbol_BNB";
        public static final String COLUMN_DCN = "symbol_DCN";
        public static final String COLUMN_ARDR = "symbol_ARDR";
        public static final String COLUMN_DOGE = "symbol_DOGE";
        public static final String COLUMN_USDT = "symbol_USDT";
        public static final String COLUMN_SNT = "symbol_SNT";
        public static final String COLUMN_STEEM = "symbol_STEEM";
        public static final String COLUMN_KCS = "symbol_KCS";
        public static final String COLUMN_WAVES = "symbol_WAVES";
        public static final String COLUMN_VEN = "symbol_VEN";
        public static final String COLUMN_WAX = "symbol_WAX";
        public static final String COLUMN_DRGN = "symbol_DRGN";
        public static final String COLUMN_ZRX = "symbol_ZRX";
        public static final String COLUMN_DGB = "symbol_DGB";
        public static final String COLUMN_REP = "symbol_REP";
        public static final String COLUMN_ARK = "symbol_ARK";
        public static final String COLUMN_DENT = "symbol_DENT";
        public static final String COLUMN_HSR = "symbol_HSR";
        public static final String COLUMN_VERI = "symbol_VERI";
        public static final String COLUMN_KMD = "symbol_KMD";
        public static final String COLUMN_BAT = "symbol_BAT";
        public static final String COLUMN_GNT = "symbol_GNT";
        public static final String COLUMN_SALT = "symbol_SALT";
        public static final String COLUMN_ETN = "symbol_ETN";
        public static final String COLUMN_DCR = "symbol_DCR";
        public static final String COLUMN_KNC = "symbol_KNC";
        public static final String COLUMN_FUN = "symbol_FUN";
        public static final String COLUMN_PIVX = "symbol_PIVX";
        public static final String COLUMN_ETHOS = "symbol_ETHOS";
        public static final String COLUMN_XP = "symbol_XP";
        public static final String COLUMN_SUB = "symbol_SUB";
        public static final String COLUMN_QASH = "symbol_QASH";
        public static final String COLUMN_AION = "symbol_AION";
        public static final String COLUMN_RDD = "symbol_RDD";
        public static final String COLUMN_NXS = "symbol_NXS";
        public static final String COLUMN_ELF = "symbol_ELF";
        public static final String COLUMN_KIN = "symbol_KIN";
        public static final String COLUMN_MED = "symbol_MED";
        public static final String COLUMN_FCT = "symbol_FCT";
        public static final String COLUMN_POWR = "symbol_POWR";
        public static final String COLUMN_AE = "symbol_AE";
        public static final String COLUMN_GAS = "symbol_GAS";
        public static final String COLUMN_REQ = "symbol_REQ";
        public static final String COLUMN_DBC = "symbol_DBC";
        public static final String COLUMN_BTM = "symbol_BTM";
        public static final String COLUMN_NEBL = "symbol_NEBL";
        public static final String COLUMN_ICN = "symbol_ICN";
        public static final String COLUMN_RHOC = "symbol_RHOC";
        public static final String COLUMN_MONA = "symbol_MONA";
        public static final String COLUMN_ENG = "symbol_ENG";
        public static final String COLUMN_MAID = "symbol_MAID";
        public static final String COLUMN_BTCD = "symbol_BTCD";
        public static final String COLUMN_GBYTE = "symbol_GBYTE";
        public static final String COLUMN_NXT = "symbol_NXT";
        public static final String COLUMN_STORM = "symbol_STORM";
        public static final String COLUMN_DGD = "symbol_DGD";
        public static final String COLUMN_COB = "symbol_COB";
        public static final String COLUMN_SYS = "symbol_SYS";
        public static final String COLUMN_GNO = "symbol_GNO";
        public static final String COLUMN_LINK = "symbol_LINK";
        public static final String COLUMN_XDN = "symbol_XDN";
        public static final String COLUMN_SAN = "symbol_SAN";
        public static final String COLUMN_ACT = "symbol_ACT";
        public static final String COLUMN_TNB = "symbol_TNB";
        public static final String COLUMN_QSP = "symbol_QSP";
        public static final String COLUMN_GAME = "symbol_GAME";
        public static final String COLUMN_BNT = "symbol_BNT";
        public static final String COLUMN_RDN = "symbol_RDN";
        public static final String COLUMN_PAY = "symbol_PAY";
        public static final String COLUMN_VEE = "symbol_VEE";
        public static final String COLUMN_XZC = "symbol_XZC";

    }


}

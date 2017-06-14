package com.firehook.bitcoinexchangerates;


import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {

    public String currencyName;

    public Rates() {
        currencyName = this.getClass().getSimpleName();
        Log.d("----->Rates data: ", currencyName);
    }



    @SerializedName("USD")
    @Expose
    public CurrencyData usd;

    @SerializedName("ISK")
    @Expose
    public CurrencyData isk;

    @SerializedName("HKD")
    @Expose
    public CurrencyData hkd;

    @SerializedName("TWD")
    @Expose
    public CurrencyData twd;

    @SerializedName("CHF")
    @Expose
    public CurrencyData chf;

    @SerializedName("EUR")
    @Expose
    public CurrencyData eur;

    @SerializedName("DKK")
    @Expose
    public CurrencyData dkk;

    @SerializedName("CLP")
    @Expose
    public CurrencyData clp;

    @SerializedName("CAD")
    @Expose
    public CurrencyData cad;

    @SerializedName("INR")
    @Expose
    public CurrencyData inr;

    @SerializedName("CNY")
    @Expose
    public CurrencyData cny;

    @SerializedName("THB")
    @Expose
    public CurrencyData thb;

    @SerializedName("AUD")
    @Expose
    public CurrencyData aud;

    @SerializedName("SGD")
    @Expose
    public CurrencyData sgd;

    @SerializedName("KRW")
    @Expose
    public CurrencyData krw;

    @SerializedName("JPY")
    @Expose
    public CurrencyData jpy;

    @SerializedName("PLN")
    @Expose
    public CurrencyData pln;

    @SerializedName("GBP")
    @Expose
    public CurrencyData gbp;

    @SerializedName("SEK")
    @Expose
    public CurrencyData sek;

    @SerializedName("NZD")
    @Expose
    public CurrencyData nzd;

    @SerializedName("BRL")
    @Expose
    public CurrencyData brl;

    @SerializedName("RUB")
    @Expose
    public CurrencyData rub;





}

package com.firehook.bitcoinexchangerates;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("ticker")
    Call<Rates> getCurrenciesRates();
}

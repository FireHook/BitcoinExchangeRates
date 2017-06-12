package com.firehook.bitcoinexchangerates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    public static final String TAG = "RETROFIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        API apiService = ApiClient.getClient().create(API.class);
        Call<Rates> rates = apiService.getCurrenciesRates();
        rates.enqueue(new Callback<Rates>() {
            @Override
            public void onResponse(Call<Rates> call, Response<Rates> response) {
                Rates r = response.body();
                if(r != null){
                    Log.d(TAG, r.usd.getBuy().toString() + " ");
                    Log.d(TAG, r.usd.getSymbol());

                    Log.d(TAG, r.eur.getBuy().toString() + " ");
                    Log.d(TAG, r.eur.getSymbol());
                }
            }

            @Override
            public void onFailure(Call<Rates> call, Throwable t) {

            }
        });

    }
}
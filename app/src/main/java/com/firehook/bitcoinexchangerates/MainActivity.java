package com.firehook.bitcoinexchangerates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    public static final String TAG = "RETROFIT";
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<CurrencyData> mRatesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewId);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mRatesData = new ArrayList<>();

        API apiService = ApiClient.getClient().create(API.class);
        Call<Rates> rates = apiService.getCurrenciesRates();
        rates.enqueue(new Callback<Rates>() {
            @Override
            public void onResponse(Call<Rates> call, Response<Rates> response) {
                Rates r = response.body();
                if(r != null){
                    mRatesData.add(r.usd);
                    mRatesData.add(r.aud);
                    mRatesData.add(r.brl);
                    mRatesData.add(r.cad);
                    mRatesData.add(r.chf);
                    mRatesData.add(r.clp);
                    mRatesData.add(r.cny);
                    mRatesData.add(r.dkk);
                    mRatesData.add(r.eur);
                    mRatesData.add(r.gbp);
                    mRatesData.add(r.hkd);
                    mRatesData.add(r.inr);
                    mRatesData.add(r.isk);
                    mRatesData.add(r.jpy);
                    mRatesData.add(r.krw);
                    mRatesData.add(r.nzd);
                    mRatesData.add(r.pln);
                    mRatesData.add(r.rub);
                    mRatesData.add(r.sek);
                    mRatesData.add(r.sgd);
                    mRatesData.add(r.thb);
                    mRatesData.add(r.twd);


                    recyclerViewAdapter = new RecyclerViewAdapter(mRatesData);
                    recyclerView.setAdapter(recyclerViewAdapter);

                }
            }

            @Override
            public void onFailure(Call<Rates> call, Throwable t) {

            }
        });

    }
}
package com.firehook.bitcoinexchangerates;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<Rates>{

    public static final String TAG = "RETROFIT";
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<CurrencyData> mRatesData;
    SwipeRefreshLayout swipeRefreshLayout;
    Call<Rates> ratesCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewId);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mRatesData = new ArrayList<>();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        //swipeRefreshLayout.setOnRefreshListener(this);

        final API apiService = ApiClient.getClient().create(API.class);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRatesData.clear();
                ratesCall = apiService.getCurrenciesRates();
                ratesCall.enqueue(MainActivity.this);
            }
        });

        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);

                mRatesData.clear();
                ratesCall = apiService.getCurrenciesRates();
                ratesCall.enqueue(MainActivity.this);
            }
        });

    }


    @Override
    public void onResponse(Call<Rates> call, Response<Rates> response) {
        swipeRefreshLayout.setRefreshing(true);
        mRatesData.clear();
        Rates r = response.body();
        if (r != null) {
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
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onFailure(Call<Rates> call, Throwable t) {
        swipeRefreshLayout.setRefreshing(false);
    }

}
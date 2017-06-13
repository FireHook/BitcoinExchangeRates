package com.firehook.bitcoinexchangerates;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.firehook.bitcoinexchangerates.MainActivity.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<CurrencyData> mDataset;

    public RecyclerViewAdapter(List<CurrencyData> mRatesData) {
        mDataset = mRatesData;
        Log.d(TAG, "Dataset size: " + mRatesData.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_list_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).getSymbol() + "- BUY: " + mDataset.get(position).getBuy().toString() +
                mDataset.get(position).getSymbol() + "/SELL: " + mDataset.get(position).getSell().toString() + mDataset.get(position).getSymbol());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView_rateRow);
        }
    }
}
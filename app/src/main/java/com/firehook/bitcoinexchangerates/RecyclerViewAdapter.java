package com.firehook.bitcoinexchangerates;


import android.graphics.Typeface;
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
        Log.d(TAG, "Dataset size: " + mDataset.size());
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
        if (position != 0){
            holder.mTextView.setTypeface(null, Typeface.NORMAL);
            holder.mTextView.setTextSize(16);
        }else {
            holder.mTextView.setTypeface(null, Typeface.BOLD);
            holder.mTextView.setTextSize(20);
        }
        holder.mTextView.setText(mDataset.get(position).getSymbol() + "- BUY: " + mDataset.get(position).getSymbol() + mDataset.get(position).getBuy().toString() +
                "/SELL: " + mDataset.get(position).getSymbol() + mDataset.get(position).getSell().toString());

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
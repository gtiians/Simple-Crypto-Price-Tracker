package com.gtiians.cryptotracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private ArrayList<CurrencyModal> currencyModalArrayList;
    private Context context;
    private static DecimalFormat df2= new DecimalFormat("#.##");

    public CurrencyAdapter(ArrayList<CurrencyModal> currencyModalArrayList, Context context) {
        this.currencyModalArrayList = currencyModalArrayList;
        this.context = context;
    }

    public void filterList(ArrayList<CurrencyModal> filteredList){
        currencyModalArrayList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.currency_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CurrencyModal currencyModal = currencyModalArrayList.get(position);
        holder.tVCurrencyName.setText(currencyModal.getName());
        holder.tVCurrencySymbol.setText(currencyModal.getSymbol());
        holder.tVCurrencyRate.setText("$ " + df2.format(currencyModal.getPrice()));
    }

    @Override
    public int getItemCount() {
        return currencyModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tVCurrencyName, tVCurrencySymbol, tVCurrencyRate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tVCurrencyName = itemView.findViewById(R.id.textViewCurrencyName);
            tVCurrencySymbol = itemView.findViewById(R.id.textViewCurrencySymbol);
            tVCurrencyRate = itemView.findViewById(R.id.textViewCurrencyRate);
        }
    }
}

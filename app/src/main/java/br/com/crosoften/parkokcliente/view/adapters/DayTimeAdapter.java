package br.com.crosoften.parkokcliente.view.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DayTimeAdapter extends RecyclerView.Adapter <DayTimeAdapter.DayTimeAdapterViewHolde> {
    @NonNull
    @Override
    public DayTimeAdapter.DayTimeAdapterViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DayTimeAdapter.DayTimeAdapterViewHolde holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DayTimeAdapterViewHolde extends RecyclerView.ViewHolder {


        public DayTimeAdapterViewHolde(@NonNull View itemView) {
            super(itemView);
        }
    }
}

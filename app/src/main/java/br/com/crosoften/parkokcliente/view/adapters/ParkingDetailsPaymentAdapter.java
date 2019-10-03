package br.com.crosoften.parkokcliente.view.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.crosoften.parkokcliente.R;

public class ParkingDetailsPaymentAdapter extends RecyclerView.Adapter<ParkingDetailsPaymentAdapter.ParkingDetailsViewHolde> {

    private List<String> payment = new ArrayList<>();
    private Context context;

    public ParkingDetailsPaymentAdapter(List<String> payments, Context context){
        this.payment = payments;
        this.context = context;

    }
    @NonNull
    @Override
    public ParkingDetailsPaymentAdapter.ParkingDetailsViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_details_payment, parent, false);
        ParkingDetailsViewHolde parkingDetailsPayment = new ParkingDetailsViewHolde(view);
        return parkingDetailsPayment;
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingDetailsPaymentAdapter.ParkingDetailsViewHolde holder, int position) {

        holder.payment.setText(payment.get(position));
    }

    @Override
    public int getItemCount() {
        return payment.size();
    }

    public class ParkingDetailsViewHolde extends RecyclerView.ViewHolder {

        TextView payment;

        public ParkingDetailsViewHolde(@NonNull View itemView) {
            super(itemView);

            payment = itemView.findViewById(R.id.tv_parking_payment);

        }
    }
}

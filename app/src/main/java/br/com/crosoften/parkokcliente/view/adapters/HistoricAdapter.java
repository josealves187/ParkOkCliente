package br.com.crosoften.parkokcliente.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.Historic;
import br.com.crosoften.parkokcliente.commom.MyCards;

import static br.com.crosoften.parkokcliente.utils.Constants.FORM_OF_PAYMENT_AMOUNT;
import static br.com.crosoften.parkokcliente.utils.Constants.FORM_OF_PAYMENT_APP;
import static br.com.crosoften.parkokcliente.utils.Constants.FORM_OF_PAYMENT_CARD;
import static br.com.crosoften.parkokcliente.utils.Utils.formatCurrency;
import static br.com.crosoften.parkokcliente.utils.Utils.getDayAndMonth;
import static br.com.crosoften.parkokcliente.utils.Utils.timeFormat;

public class HistoricAdapter extends RecyclerView.Adapter<HistoricAdapter.HistoricViewHolde>{


    private List<Historic> historics ;
    private Context context;


    public HistoricAdapter(List<Historic> historics, Context context) {
        this.historics = historics;
        this.context = context;
    }

    /***
     * O método onCreateViewHolder() serve para para inflar o layout do item.
     * Basicamente é chamado quando é necessário criar um novo item.
     * */

    @NonNull
    @Override
    public HistoricAdapter.HistoricViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_historic, parent, false);
        HistoricViewHolde historicViewHolde = new HistoricViewHolde(view);
        return historicViewHolde;
    }

    /***
     *  O método onBindViewHolder() tem a finalidade de definir os atributos de exibição com base
     *  nos dados. Basicamente é invocado quando um item precisa ser exibido para o usuário.
     * */
    @Override
    public void onBindViewHolder(@NonNull HistoricAdapter.HistoricViewHolde holder, final int position) {

        if (historics.get(position).getTypeService() ==1){
            holder.tvTypeService.setText("Desconto - Estacionamento Dias");
            holder.tvDiscount.setVisibility(View.VISIBLE);


        }else {
            holder.tvTypeService.setText("Bônus - Estacionamento Auto park");
            holder.tvDiscount.setVisibility(View.GONE);
            holder.tvAmountPaidHitoric.setVisibility(View.GONE);
            holder.tvAmount.setVisibility(View.VISIBLE);
            holder.tvAmount.setText("Valor pago");
            holder.tvFinalAmountPaid.setVisibility(View.GONE);
            holder.tvTypeOfPayment.setVisibility(View.GONE);
            holder.tvFormOfPaymentHistoric.setVisibility(View.GONE);
            holder.tvDiscount.setVisibility(View.VISIBLE);
            holder.tvDiscount.setText("Forma de pagametno");
            holder.tvTotalDiscount.setVisibility(View.VISIBLE + historics.get(position).getFormOfPayment());

        }
        holder.tvServiceDate.setText(getDayAndMonth(historics.get(position).getServiceDate(),context));
        holder.tvGrandTotal.setText(formatCurrency(context,historics.get(position).getAmount()));
        holder.tvTotalDiscount.setText(formatCurrency(context,historics.get(position).getAmountPaid()));



        switch (historics.get(position).getFormOfPayment()){
            case 1 :
                holder.tvTypeOfPayment.setText(FORM_OF_PAYMENT_APP);
                break;
            case 2:
                holder.tvTypeOfPayment.setText(FORM_OF_PAYMENT_AMOUNT);
                break;
            case 3:
                holder.tvTypeOfPayment.setText(FORM_OF_PAYMENT_CARD);
        }

    }

    //O método getItemCount  retorna a quantidade de itens no RecyclerView
    @Override
    public int getItemCount() {
        return historics.size();
    }

    public class HistoricViewHolde extends RecyclerView.ViewHolder {

        TextView tvAmountPaidHitoric;
        TextView tvAmount;
        TextView tvDiscount;
        TextView tvFormOfPaymentHistoric;
        TextView tvFinalAmountPaid;
        TextView tvGrandTotal;
        TextView tvPermanence;
        TextView tvServiceDate;
        TextView tvTimePermanence;
        TextView tvTotalDiscount;
        TextView tvTypeOfPayment;
        TextView tvTypeService;
        TextView tvTimeServic;
        View tvPastingHistory;


        public HistoricViewHolde(@NonNull View itemView) {
            super(itemView);

            tvServiceDate = itemView.findViewById(R.id.tv_service_date);
            tvTypeService = itemView.findViewById(R.id.tv_type_service);
            tvTimeServic = itemView.findViewById(R.id.tv_time_servic);
            tvPermanence = itemView.findViewById(R.id.tv_permanence);
            tvPastingHistory = itemView.findViewById(R.id.tv_pasting_history);
            tvAmount = itemView.findViewById(R.id.tv_amount);
            tvDiscount = itemView.findViewById(R.id.tv_discount);
            tvTimePermanence = itemView.findViewById(R.id.tv_time_permanence);
            tvGrandTotal = itemView.findViewById(R.id.tv_grand_total);
            tvTotalDiscount = itemView.findViewById(R.id.tv_total_discount);
            tvFormOfPaymentHistoric = itemView.findViewById(R.id.tv_form_of_payment_historic);
            tvAmountPaidHitoric = itemView.findViewById(R.id.tv_amount_paid_hitoric);
            tvTypeOfPayment = itemView.findViewById(R.id.tv_type_of_payment);
            tvFinalAmountPaid = itemView.findViewById(R.id.tv_final_amount_paid);

        }
    }
}

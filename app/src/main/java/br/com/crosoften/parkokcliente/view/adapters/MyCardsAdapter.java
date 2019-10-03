package br.com.crosoften.parkokcliente.view.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.MyCards;

public class MyCardsAdapter extends RecyclerView.Adapter<MyCardsAdapter.MyCardsViewHolde> {

    private List<MyCards> myCards;
    private Context context;

    private int lastSelectedPosition = -1;

    public MyCardsAdapter(List<MyCards> myCards, Context context) {
        this.myCards = myCards;
        this.context = context;
    }

    @NonNull
    @Override
    public MyCardsAdapter.MyCardsViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_my_cards, parent, false);
        MyCardsViewHolde myCardsViewHolde = new MyCardsViewHolde(view);
        return myCardsViewHolde;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCardsAdapter.MyCardsViewHolde holder, int position) {

        MyCards myCardsAdapter = myCards.get(position);
        holder.numero.setText(context.getString(R.string.amount_numero, String.valueOf(myCardsAdapter.getNumber())));

        switch (myCards.get(position).getIdImage()) {
            case 1:
                holder.cardImage.setImageResource(R.drawable.ic_visa);
                if (lastSelectedPosition == position) {
                    holder.cardImage.setColorFilter(ContextCompat.getColor(context, R.color.white));
                }else {
                    holder.cardImage.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent));
                    holder.cardImage.setColorFilter(ContextCompat.getColor(context, R.color.common_google_signin_btn_text_dark_disabled));
                }

                break;
            case 2:
                holder.cardImage.setImageResource(R.drawable.ic_mastercard);
                break;
            case 3:
                holder.cardImage.setImageResource(R.drawable.ic_diners_club);
                break;
            case 4:
                holder.cardImage.setImageResource(R.drawable.ic_elo);
                break;
        }


//        uma vez que apenas um botão de opção pode ser selecionado,
//        essa condição desmarca as seleções anteriores
        holder.selectionState.setChecked(lastSelectedPosition == position);


        if (lastSelectedPosition == position) {
            //laranja
            holder.mcwMyCards.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorTextView));
            holder.change.setTextColor(ContextCompat.getColor(context, R.color.white));
            holder.remove.setTextColor(ContextCompat.getColor(context, R.color.white));
            holder.numero.setTextColor(ContextCompat.getColor(context, R.color.white));



            if (Build.VERSION.SDK_INT >= 21) {

                ColorStateList colorState = new ColorStateList(
                        new int[][]{

                                new int[]{android.R.attr.state_enabled} //enabled
                        },
                        new int[]{

                                Color.WHITE //disabled
                        }
                );
                holder.selectionState.setButtonTintList(colorState);//set the color tint list
                holder.selectionState.invalidate(); //could not be necessary
            }


        } else {
            //branco

            holder.mcwMyCards.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
            holder.change.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.remove.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.numero.setTextColor(ContextCompat.getColor(context, R.color.black));


            if (Build.VERSION.SDK_INT >= 21) {

                ColorStateList colorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{-android.R.attr.state_enabled}, //disabled
                                new int[]{android.R.attr.state_enabled} //enabled
                        },
                        new int[]{
                                Color.BLACK //disabled
                                , Color.BLACK //enabled
                        }
                );

                holder.selectionState.setButtonTintList(colorStateList);//set the color tint list
                holder.selectionState.invalidate(); //could not be necessary
            }
        }

    }

    @Override
    public int getItemCount() {
        return myCards.size();
    }

    public class MyCardsViewHolde extends RecyclerView.ViewHolder {

        TextView numero;
        TextView change;
        TextView remove;
        RadioButton selectionState;
        ImageView cardImage;
        CardView mcwMyCards;


        public MyCardsViewHolde(@NonNull View itemView) {
            super(itemView);
            numero = itemView.findViewById(R.id.tv_number_adpter_cadt);
            change = itemView.findViewById(R.id.tv_change_adpter);
            remove = itemView.findViewById(R.id.tv_to_remove_adpter);
            cardImage = itemView.findViewById(R.id.iv_myCards);
            selectionState = itemView.findViewById(R.id.radioButton);
            mcwMyCards = itemView.findViewById(R.id.mcw_my_cards);

            selectionState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();

                }
            });
        }
    }
}

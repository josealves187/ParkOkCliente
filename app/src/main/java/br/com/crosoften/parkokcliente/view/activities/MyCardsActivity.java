package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.MyCards;
import br.com.crosoften.parkokcliente.view.adapters.MyCardsAdapter;

public class MyCardsActivity extends AppCompatActivity {

    private RecyclerView rcvPaymentCards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cards);
        initializeComponents();


        List<MyCards> myCards = new ArrayList<>();
        myCards.add( new MyCards(1444,"Jose", new Date(), 6,1));
        myCards.add( new MyCards(5555,"Jose", new Date(), 6,2));
        myCards.add( new MyCards(5565,"Jose", new Date(), 6,3));
        myCards.add( new MyCards(1472,"Jose", new Date(), 6,4));

        rcvPaymentCards.setLayoutManager(new LinearLayoutManager(this));
        rcvPaymentCards.setAdapter(new MyCardsAdapter(myCards,this));


    }

    private void initializeComponents() {

        rcvPaymentCards = findViewById(R.id.rcv_payment_cards);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_my_cards);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}

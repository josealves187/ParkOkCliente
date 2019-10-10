package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.view.adapters.ParkingDetailsPaymentAdapter;

public class ParkingDetailsActivity extends AppCompatActivity {

    private RecyclerView rcvPayment;
    private RecyclerView rcvDayTime;
    private MaterialToolbar mtToolbarParkingDetails;
    private MaterialCardView cmShare;
    private TextView tvParkingAndress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details);
        initializeComponents();
        eventButton();

        List<String> payment = new ArrayList<>();
        payment.add(("Dinheiro"));
        payment.add(("Cartão de crédito e débito"));
        payment.add(("Pelo app"));
        rcvPayment.setLayoutManager(new LinearLayoutManager(this));
        rcvPayment.setAdapter(new ParkingDetailsPaymentAdapter(payment,this));


        rcvDayTime.setLayoutManager(new LinearLayoutManager(this));
        rcvDayTime.setAdapter(new ParkingDetailsPaymentAdapter(payment,this));
    }

    private void eventButton() {
        mtToolbarParkingDetails.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        cmShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String share = tvParkingAndress.getText().toString();
                shareText(share);
            }
        });
    }

    private void initializeComponents() {
        rcvPayment = findViewById(R.id.rcv_payment);
        rcvDayTime = findViewById(R.id.rcv_day_time);
        mtToolbarParkingDetails = findViewById(R.id.mt_toolbar_parking_details);
        cmShare = findViewById(R.id.cm_check_share);
        tvParkingAndress = findViewById(R.id.tv_parking_andress);
        //display home
        setSupportActionBar(mtToolbarParkingDetails);


    }

    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 2);
        editor.commit();
        super.onBackPressed();
    }

    //metodo responsável para compartilhar código indicar amigos
    private void shareText(String text) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        sendIntent.setType("text/plain");
        //sendIntent.setPackage("com.whatsapp");//apenas whatsapp
        try {
            Intent chooserIntent = Intent.createChooser(sendIntent, "Escolha App de compartilhamento");
            if (chooserIntent == null) {
                onBackPressed();
                return;

            }
            startActivity(chooserIntent);
        } catch (Exception e) {
            startActivity(sendIntent);
            onBackPressed();

        }
    }

}

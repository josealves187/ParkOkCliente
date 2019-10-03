package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.view.adapters.ParkingDetailsPaymentAdapter;

public class ParkingDetailsActivity extends AppCompatActivity {

    private RecyclerView rcvPayment;
    private MaterialToolbar mtToolbarParkingDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details);
        initializeComponents();

        List<String> payment = new ArrayList<>();
        payment.add(new String("Dinheiro"));
        payment.add(new String("Cartão de crédito e débito"));
        payment.add(new String("Pelo app"));
        rcvPayment.setLayoutManager(new LinearLayoutManager(this));
        rcvPayment.setAdapter(new ParkingDetailsPaymentAdapter(payment,this));

        mtToolbarParkingDetails.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initializeComponents() {
        rcvPayment = findViewById(R.id.rcv_payment);
        mtToolbarParkingDetails = findViewById(R.id.mt_toolbar_parking_details);
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
}

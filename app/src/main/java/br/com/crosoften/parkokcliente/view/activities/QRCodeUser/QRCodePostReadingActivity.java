package br.com.crosoften.parkokcliente.view.activities.QRCodeUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.view.activities.ProfileActivity;

public class QRCodePostReadingActivity extends AppCompatActivity {
    private CardView cmQrcodeExti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_post_reading);
        initializecomponents();


        cmQrcodeExti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QRCodePostReadingActivity.this, QRCodeExitActivity.class);
                startActivity(i);

            }
        });
    }

    private void initializecomponents() {
        cmQrcodeExti = findViewById(R.id.cm_qrcode_exti);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_post_qrcode);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

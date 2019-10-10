package br.com.crosoften.parkokcliente.view.activities.QRCodeUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.QrCode;
import br.com.crosoften.parkokcliente.view.activities.ProfileActivity;

import static br.com.crosoften.parkokcliente.utils.MaskTextView.boad;
import static br.com.crosoften.parkokcliente.utils.Utils.dateFormat;
import static br.com.crosoften.parkokcliente.utils.Utils.timeFormat;

public class QRCodePostReadingActivity extends AppCompatActivity {

    private CardView cmQrcodeExti;
    private TextView tvTitleInputDate;
    private TextView tvBoard;
    private TextView tvHourInput;
    private TextView tvHourExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_post_reading);
        initializecomponents();
        eventButton();

        QrCode qrCodes = new QrCode(1,"jose",new Date(),new Date(),new Date(),"HYG8855");

        tvTitleInputDate.setText(dateFormat(qrCodes.getInput()));
        tvHourInput.setText(timeFormat(qrCodes.getInput()));
        tvHourExit.setText(timeFormat(qrCodes.getInput()));
        tvBoard.setText(boad(qrCodes.getBoad()));

    }

    private void eventButton() {
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
        tvTitleInputDate = findViewById(R.id.tv_title_input_date);
        tvBoard = findViewById(R.id.tv_board);
        tvHourInput = findViewById(R.id.tv_tlitle_hour_input);
        tvHourExit = findViewById(R.id.tv_tlitle_hour_exit);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_post_qrcode);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

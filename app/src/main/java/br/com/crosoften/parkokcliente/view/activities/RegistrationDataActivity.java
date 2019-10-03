package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;

public class RegistrationDataActivity extends AppCompatActivity {

    private MaterialButton btnChagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_data);
        initializeComponents();
        eventButton();

    }
    private void eventButton() {
        btnChagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationDataActivity.this, ChangeDataActivity.class);
                startActivity(i);
            }
        });
    }


    private void initializeComponents() {
        btnChagen = findViewById(R.id.btn_change);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_data_registrion);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}

package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;

public class ChangeDataActivity extends AppCompatActivity {

    private TextView tvChange;
    private EditText etnNegisterName;
    private MaterialButton mbChangeSalvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_data);
        initializecomponents();
        eventButton();


    }

    private void eventButton() {
        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calledChangePassword();
            }
        });

        mbChangeSalvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validCredential = true;
                if (etnNegisterName.getText().toString().equals("")) {
                    etnNegisterName.setError("Preencha o nome!");
                    etnNegisterName.requestFocus();
                }else if (validCredential){
                    Toast.makeText(ChangeDataActivity.this, "Nome alterado com sucesso", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


    private void calledChangePassword() {
        Intent i = new Intent(ChangeDataActivity.this, ChangePasswordActivity.class);
        startActivity(i);
    }

    private void initializecomponents() {
        tvChange = findViewById(R.id.tv_change_password);
        mbChangeSalvo = findViewById(R.id.mb_change_password);
        etnNegisterName = findViewById(R.id.et_change_password);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_change_registrion);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;

public class RecoverPasswordActivity extends AppCompatActivity {

    private EditText recoverPassword;
    private MaterialButton inputrecoverPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        initializesComponents();
        eventButton();




    }

    private void eventButton() {

        inputrecoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean validCredential = true;
                if (recoverPassword.getText().toString().equals("")) {
                    recoverPassword.setError("Preencha E-mail!");
                    recoverPassword.requestFocus();
                }else if (validCredential){
                    Toast.makeText(RecoverPasswordActivity.this, "Senha Enviada com sucesso", Toast.LENGTH_SHORT).show();
                    calledRegistrationScreen();
                }


            }
        });
    }

    private void calledRegistrationScreen() {
        Intent i = new Intent(RecoverPasswordActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void initializesComponents() {
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_recover_password);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recoverPassword =  findViewById(R.id.tv_screen_recover_password);
        inputrecoverPassword =  findViewById(R.id.btn_input_recover);

    }
}

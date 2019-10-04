package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText tvRecoverPassword;
    private MaterialButton inputChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initializesComponents();
        eventButton();




    }

    private void eventButton() {

        inputChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            checkUserName();


            }
        });
    }

    private void calledRegistrationScreen() {
        Intent i = new Intent(ChangePasswordActivity.this, ChangeDataActivity.class);
        startActivity(i);
    }

    private void initializesComponents() {
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_change_password);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvRecoverPassword =  findViewById(R.id.tv_screen_recover_password);
        inputChangePassword =  findViewById(R.id.input_change_password);

    }

    private void checkUserName() {
        String emailAddress = tvRecoverPassword.getText().toString().trim();
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            tvRecoverPassword.setError("Por favor insira o endereço de e-mail válido!");
            tvRecoverPassword.requestFocus();
        }
        if (tvRecoverPassword.getText().toString().equals("")) {
            tvRecoverPassword.setError("Digite o endereço de e-mail!");
            tvRecoverPassword.requestFocus();
        }

        String usernameValue = tvRecoverPassword.getText().toString().trim();
        boolean validCredential = true;
        if (!usernameValue.equals("teste@gmail.com")) {
            validCredential = false;
            tvRecoverPassword.setError("Email não cadastrado");
        }

        if (validCredential) {
            //everything checked we open new activity
            calledRegistrationScreen();

            Toast.makeText(this, "Senha enviada para seu Email", Toast.LENGTH_SHORT).show();
            //we close this activity
            this.finish();
        }
    }
}

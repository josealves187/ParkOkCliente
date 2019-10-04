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

    private EditText tvRecoverPassword;
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
                checkUserName();

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

        tvRecoverPassword =  findViewById(R.id.tv_screen_recover_password);
        inputrecoverPassword =  findViewById(R.id.btn_input_recover);

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
            //tudo verificado abrimos a nova atividade
            calledRegistrationScreen();

            Toast.makeText(this, "Senha enviada para seu Email", Toast.LENGTH_SHORT).show();
            //fechamos esta atividade
            this.finish();
        }
    }
}

package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;

public class LoginActivity extends AppCompatActivity {


    private MaterialButton btnRegister;
    private TextView tvForgotMyPassword;
    private Button bnt_send;

    private EditText tvEmail;
    private EditText tvPasswor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeComponents();
        eventoButton();


    }

    private void eventoButton() {
        tvForgotMyPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RecoverPasswordActivity.class);
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        bnt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String user = tvEmail.getText().toString();
//                String password = tvPasswor.getText().toString();
//                boolean validCredential = true;
//                if (!user.equals("teste@gmail.com")) {
//                    validCredential = false;
//                    tvEmail.setError("Informe seu e-mail.");
//                    tvEmail.requestFocus();
//                } else {
//                    tvEmail.setError(null);
//                }
//
//                if (!password.equals(("123456"))) {
//                    validCredential = false;
//                    tvPasswor.setError(("Digite sua senha primeiro!"));
//                    tvPasswor.requestFocus();
//                } else {
//                    tvPasswor.setError(null);
//                }
//
//                if (validCredential) {

                onBackPressed();
                calledScreen();
            }

//            }

        });
    }

    private void initializeComponents() {
        bnt_send = findViewById(R.id.btn_input);
        tvEmail = findViewById(R.id.tv_email);
        tvPasswor = findViewById(R.id.tv_Passwor);
        btnRegister = findViewById(R.id.btn_register);
        tvForgotMyPassword = findViewById(R.id.tv_title_forgot_my_password);
    }
    @Override
    public void onBackPressed(){
        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 1);
        editor.commit();
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(i);
        super.onBackPressed();
    }

    private void calledScreen() {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(i);
    }
}

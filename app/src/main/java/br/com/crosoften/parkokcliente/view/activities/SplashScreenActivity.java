package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.com.crosoften.parkokcliente.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abriAutenticacao();

            }
        }, 3000);
    }

    private void abriAutenticacao() {
        Intent i = new Intent(SplashScreenActivity.this,LoginActivity.class);
        startActivity(i);
        finish();
    }

}

package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.Users;

import static br.com.crosoften.parkokcliente.utils.MaskTextView.cpfRegistration;

public class RegistrationDataActivity extends AppCompatActivity {

    private MaterialButton btnChagen;

    private ImageView acivPhotoUserDetais;
    private TextView tvNameRegister;
    private TextView tvCpfRegister;
    private TextView tvEmaiRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_data);
        initializeComponents();
        eventButton();

        Users users = new Users(1, "José Alves", "14587965288", "jralves187@gmail.com");
        if (users != null){
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f").into(acivPhotoUserDetais);
            tvNameRegister.setText(users.getNameUser());
            tvCpfRegister.setText(cpfRegistration(users.getCpf()));
            tvEmaiRegister.setText(users.getEmail());
        }

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
        acivPhotoUserDetais = findViewById(R.id.aciv_photo_user_detais);
        tvNameRegister = findViewById(R.id.tv_name_register);
        tvCpfRegister = findViewById(R.id.tv_cpf_register);
        tvEmaiRegister = findViewById(R.id.tv_email_register_data);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_data_registrion);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}

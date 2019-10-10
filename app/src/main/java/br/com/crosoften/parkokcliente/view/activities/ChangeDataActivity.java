package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.Users;
import de.hdodenhof.circleimageview.CircleImageView;

import static br.com.crosoften.parkokcliente.utils.MaskTextView.cpfRegistration;

public class ChangeDataActivity extends AppCompatActivity {

    private TextView tvChange;
    private TextView btnTitleChagenPhoto;
    private EditText etnNegisterName;
    private MaterialButton mbChangeSalvo;
    private TextView tvChangeCpf;
    private TextView tvChangeEmail;
    private CircleImageView  acivPhotoUserChangeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_data);
        initializecomponents();
        eventButton();


        Users users = new Users(1, "José Alves", "14587965288", "jralves187@gmail.com");
        if (users != null){
            Glide.with(this)
                    .load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f")
                    .into(acivPhotoUserChangeData);
            tvChangeCpf.setText(cpfRegistration(users.getCpf()));
            tvChangeEmail.setText(users.getEmail());
        }

    }

    private void eventButton() {
        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calledChangePassword();
            }
        });

        btnTitleChagenPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChangeDataActivity.this, "Selecione imagen", Toast.LENGTH_SHORT).show();
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
        tvChangeCpf = findViewById(R.id.tv_change_cpf);
        tvChangeEmail = findViewById(R.id.tv_change_email);
        acivPhotoUserChangeData = findViewById(R.id.aciv_photo_change_data);
        btnTitleChagenPhoto = findViewById(R.id.btn_title__chagen_photo);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_change_registrion);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

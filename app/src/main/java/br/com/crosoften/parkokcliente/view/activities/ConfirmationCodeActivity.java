package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.view.custom.PinEntryEditText;

public class ConfirmationCodeActivity extends AppCompatActivity {

    private Dialog dialog;

    private MaterialButton bntCheck;
    private MaterialButton btnConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_code);
        initializecomponents();


        final PinEntryEditText txtPinEntry = findViewById(R.id.et_pin_entry);
        txtPinEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("1234")) {
                    Toast.makeText(ConfirmationCodeActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else if (s.length() == "1234".length()) {
                    Toast.makeText(ConfirmationCodeActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    txtPinEntry.setText(null);
                }
            }
        });




        bntCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean validCredential = true;
                if (txtPinEntry.getText().toString().equals("")) {
                    txtPinEntry.setError("Preencha código!");
                    txtPinEntry.requestFocus();
                }else if (validCredential){
                    abrirDialog();

                }

            }
        });

    }

    private void initializecomponents() {
        bntCheck = findViewById(R.id.bnt_check);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_confirmation_code);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void abrirDialog() {

        dialog = new Dialog(ConfirmationCodeActivity.this);
        dialog.setContentView(R.layout.registration_completed);
        btnConfirmation = dialog.findViewById(R.id.btn_confirmation);


        btnConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmationCodeActivity.this, HomeActivity.class);
                startActivity(i);
                dialog.dismiss();
                finish();

            }
        });
        dialog.show();
    }
}

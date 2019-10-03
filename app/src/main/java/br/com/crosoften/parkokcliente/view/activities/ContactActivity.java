package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;

import br.com.crosoften.parkokcliente.R;

public class ContactActivity extends AppCompatActivity {


    private MaterialToolbar mtContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initializecomponents();

    }

    private void initializecomponents() {
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_contact);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

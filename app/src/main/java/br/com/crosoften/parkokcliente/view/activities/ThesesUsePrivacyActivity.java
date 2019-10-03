package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import br.com.crosoften.parkokcliente.R;

import static br.com.crosoften.parkokcliente.utils.Constants.TEXT_USE;
import static br.com.crosoften.parkokcliente.utils.Constants.TITLE_TOOLBAR;

public class ThesesUsePrivacyActivity extends AppCompatActivity {

    private MaterialToolbar mtToolbar;
    private TextView tvText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theses_use_privacy);

        initializecomponents();
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String sMessageToolbar = getIntent().getExtras().getString(TITLE_TOOLBAR, "");
        String sText = getIntent().getExtras().getString(TEXT_USE, "");

        if (sMessageToolbar != "") {
            getSupportActionBar().setTitle(sMessageToolbar);
            tvText.setText(sText);
        }
    }
    private void initializecomponents() {
        setSupportActionBar(mtToolbar);
        mtToolbar = findViewById(R.id.mt_toolbar);
        tvText = findViewById(R.id.tv_text);
    }
}

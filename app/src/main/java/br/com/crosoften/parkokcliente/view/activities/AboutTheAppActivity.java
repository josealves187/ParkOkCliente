package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import br.com.crosoften.parkokcliente.R;

import static br.com.crosoften.parkokcliente.utils.Constants.SCREEN_ORIGEN;
import static br.com.crosoften.parkokcliente.utils.Constants.TEXT_USE;
import static br.com.crosoften.parkokcliente.utils.Constants.TITLE_TOOLBAR;

public class AboutTheAppActivity extends AppCompatActivity {

    private TextView tvTemos;
    private MaterialToolbar mtToolbarTermosUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_the_app);
        //inicializar componente
        initializeComponent();

        /***
         * acionar click do textview e direcionado os layout
         * */
        SpannableString ss = new SpannableString(getString(R.string.tilte_privacy_policies_and_terms));
        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent i = new Intent(AboutTheAppActivity.this, ThesesUsePrivacyActivity.class);
                i.putExtra(TITLE_TOOLBAR, getString(R.string.title_toolbar_privacy_policies));
                i.putExtra(TEXT_USE, getString(R.string.tv_text_privacy_policies));
                startActivity(i);

            }
        };

        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // do another thing
                Intent i = new Intent(AboutTheAppActivity.this, ThesesUsePrivacyActivity.class);
                i.putExtra(TITLE_TOOLBAR, getString(R.string.title_toolbar_terms_of_use));
                i.putExtra(TEXT_USE, getString(R.string.tv_text_terms_of_use));
                startActivity(i);
            }
        };

        /***
         * redirected screen
         * redirecionando telas Navigation da toolbar
         * */
        mtToolbarTermosUse.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
                editor.putInt(SCREEN_ORIGEN, 4);
                editor.commit();
            }
        });

        /***
         *
         * underlined text e  placed color com SpannableString
         * colocando cor e sublinhado o texto usando  SpannableString
         * */
        ss.setSpan(span1, 0, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 27, 40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 40, 0);
        // bold
        ss.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                24,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        ss.setSpan(
                new StyleSpan(Typeface.BOLD),
                27,
                40,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        tvTemos.setText(ss);
        tvTemos.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void initializeComponent() {
        mtToolbarTermosUse = findViewById(R.id.mt_toolbar_termos_use);
        tvTemos = findViewById(R.id.tv_temos);
    }
}

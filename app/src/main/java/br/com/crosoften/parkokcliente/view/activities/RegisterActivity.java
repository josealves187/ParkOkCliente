package br.com.crosoften.parkokcliente.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
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
import android.widget.CheckBox;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;

import static br.com.crosoften.parkokcliente.utils.Constants.TEXT_USE;
import static br.com.crosoften.parkokcliente.utils.Constants.TITLE_TOOLBAR;

public class RegisterActivity extends AppCompatActivity {

    private CheckBox cbTermsOfUse;
    private CheckBox cbPrivacyPpolicies;
    private MaterialButton CADASTRAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CADASTRAR= findViewById(R.id.btn_send);
        cbTermsOfUse = findViewById(R.id.ch_terms_of_use);
        cbPrivacyPpolicies = findViewById(R.id.cb_privacy_policies);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_recover_password);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        CADASTRAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, ConfirmationCodeActivity.class);
                startActivity(i);
            }
        });

        /***
         * acionar click do textview e direcionado os layout
         * */
        SpannableString ss = new SpannableString("Li e aceito os TERMOS DE USO");
        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // do another thing
                Intent i = new Intent(RegisterActivity.this, ThesesUsePrivacyActivity.class);
                i.putExtra(TITLE_TOOLBAR, getString(R.string.title_toolbar_terms_of_use));
                i.putExtra(TEXT_USE, getString(R.string.tv_text_terms_of_use));
                startActivity(i);

            }
        };
        SpannableString sss = new SpannableString("Li e aceito as POLÍTICAS DE PRIVACIDADE");
        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent i = new Intent(RegisterActivity.this, ThesesUsePrivacyActivity.class);
                i.putExtra(TITLE_TOOLBAR, getString(R.string.title_toolbar_privacy_policies));
                i.putExtra(TEXT_USE, getString(R.string.tv_text_privacy_policies));
                startActivity(i);

            }
        };

        /***
         *
         * underlined text e  placed color com SpannableString
         * colocando cor e sublinhado o texto usando  SpannableString
         * */

        ss.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 28, 0);
        sss.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 39, 0);
        // bold
        ss.setSpan(
                new StyleSpan(Typeface.BOLD),
                16,
                28,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        sss.setSpan(
                new StyleSpan(Typeface.BOLD),
                15,
                39,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        cbTermsOfUse.setText(ss);
        cbTermsOfUse.setMovementMethod(LinkMovementMethod.getInstance());

        cbPrivacyPpolicies.setText(sss);
        cbPrivacyPpolicies.setMovementMethod(LinkMovementMethod.getInstance());

    }

}

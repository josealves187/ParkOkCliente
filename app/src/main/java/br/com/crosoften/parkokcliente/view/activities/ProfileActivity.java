package br.com.crosoften.parkokcliente.view.activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.Users;

import static br.com.crosoften.parkokcliente.utils.Constants.TEXT_USE;
import static br.com.crosoften.parkokcliente.utils.Constants.TITLE_TOOLBAR;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    private Dialog dialog;
    private MaterialButton btnConfirmation;
    private MaterialButton btnCancel;
    private ImageView ivClose;
    private MaterialToolbar mtToolbarProfile;

    private ImageView civPhotoProfile;
    private TextView tvRegistrationDat;
    private TextView tvNameProfile;
    private TextView tvTitleMyCards;
    private TextView tvTitleContact;
    private TextView tvTitleAboutTheApp;
    private TextView tvTitlePrivacyTermsProfile;
    private TextView tvTitleExitProfile;
    private TextView tvTitlePrivacypolicies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //inicializar componente
        initializeComponent();
        implementationInstance();

        mtToolbarProfile.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Users users = new Users(1, "José Alves", "14587965288", "jralves187@gmail.com");
        if (users != null) {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f").into(civPhotoProfile);
            tvNameProfile.setText(users.getNameUser());


            SpannableString(users);
        }

    }

    /***
     * colocando cor no texto usando  SpannableString
     * */
    private void SpannableString(Users users) {
        SpannableString ss = new SpannableString(getString(R.string.helo_qrcode,users.getNameUser()));
        ss.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorNameTextView)), 0, 4, 0);
        tvNameProfile.setText(ss);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.profile_delete_account,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//         Lidar com o item da barra de ação clica aqui. A barra de ação será
//         manipula cliques automaticamente no botão Início / Para cima, por tanto tempo
//         enquanto você especifica uma atividade pai no AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_delete_account:
                abrirDialog();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeComponent() {
        tvRegistrationDat = findViewById(R.id.tv_registration_dat);
        tvTitleMyCards = findViewById(R.id.tv_title_my_cards);
        tvTitleContact = findViewById(R.id.tv_title_contact_us);
        tvTitleAboutTheApp = findViewById(R.id.tv_title_about_the_app);
        tvTitlePrivacyTermsProfile = findViewById(R.id.tv_title_use_terms_profile);
        tvTitlePrivacypolicies = findViewById(R.id.tv_title_privacy_policies);
        tvTitleExitProfile = findViewById(R.id.tv_title_exit_profile);
        civPhotoProfile = findViewById(R.id.civ_photo_profile);
        tvNameProfile = findViewById(R.id.tv_name_profile);
        mtToolbarProfile = findViewById(R.id.mt_toolbar_profile);
        setSupportActionBar(mtToolbarProfile);
    }

    private void implementationInstance() {
        tvTitleMyCards.setOnClickListener(this);
        tvRegistrationDat.setOnClickListener(this);
        tvTitleContact.setOnClickListener(this);
        tvTitleAboutTheApp.setOnClickListener(this);
        tvTitlePrivacyTermsProfile.setOnClickListener(this);
        tvTitleExitProfile.setOnClickListener(this);
        tvTitlePrivacypolicies.setOnClickListener(this);

    }

    /**
     * Isso é chamado quando o usuário toca no item (no modo de toque) ou atribui foco ao item com
     * as teclas de navegação ou o trackball e pressiona a tecla “enter” ou o pressiona no trackball.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_registration_dat:
                flameRegistration();
                break;

            case R.id.tv_title_my_cards:
                flameMyCards();
                break;

            case R.id.tv_title_contact_us:
                flamecontactUs();
                break;

            case R.id.tv_title_about_the_app:
                flameAboutTheApp();
                break;

            case R.id.tv_title_privacy_policies:
                flamePoliciesProfile(R.string.title_toolbar_privacy_policies, R.string.tv_text_privacy_policies);
                break;

            case R.id.tv_title_use_terms_profile:
                flamePoliciesProfile(R.string.title_toolbar_terms_of_use, R.string.tv_text_terms_of_use);
                break;
            case R.id.tv_title_exit_profile:
                flameLogin();
                break;
        }
    }

    private void flamePoliciesProfile(int p, int p2) {
        Intent i = new Intent(ProfileActivity.this, ThesesUsePrivacyActivity.class);
        i.putExtra(TITLE_TOOLBAR, getString(p));
        i.putExtra(TEXT_USE, getString(p2));
        startActivity(i);
    }

    private void flameRegistration() {

        Intent i = new Intent(ProfileActivity.this, RegistrationDataActivity.class);
        startActivity(i);
    }

    private void flameMyCards() {
        Intent i = new Intent(ProfileActivity.this, MyCardsActivity.class);
        startActivity(i);
    }

    private void flameLogin() {
        Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(i);
    }

    private void flamecontactUs() {

        Intent i = new Intent(ProfileActivity.this, ContactActivity.class);
        startActivity(i);
    }

    private void flameAboutTheApp() {
        Intent i = new Intent(ProfileActivity.this, AboutTheAppActivity.class);
        startActivity(i);
    }

    private void abrirDialog() {

        dialog = new Dialog(ProfileActivity.this);
        dialog.setContentView(R.layout.profile_delete_account);
        btnConfirmation = dialog.findViewById(R.id.btn_confirmation);
        btnCancel = dialog.findViewById(R.id.btn_cancel);
        ivClose = dialog.findViewById(R.id.iv_close);

        btnConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 1);
        editor.commit();
        super.onBackPressed();
    }
}
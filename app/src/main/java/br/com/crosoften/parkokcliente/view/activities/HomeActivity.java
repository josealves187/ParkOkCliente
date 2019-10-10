package br.com.crosoften.parkokcliente.view.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.view.adapters.HomeViewPagerAdapter;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mbnvMenu;
    private ViewPager mVpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initComponents();
        mbnvMenu.setOnNavigationItemSelectedListener(this);
        initViewPager();
    }

    private void initComponents() {
        mbnvMenu = findViewById(R.id.bnv_menu);
        mVpContent = findViewById(R.id.vp_content);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_qrcode:
                mVpContent.setCurrentItem(0, false);
                return true;

            case R.id.nav_map:
                mVpContent.setCurrentItem(1, false);
                return true;

            case R.id.nav_historic:
                mVpContent.setCurrentItem(2, false);
                return true;

            case R.id.nav_friend:
                mVpContent.setCurrentItem(3, false);
                return true;
        }
        return false;


    }

    private void initViewPager() {
        mVpContent.setAdapter(new HomeViewPagerAdapter(getSupportFragmentManager()));
        mVpContent.setCurrentItem(0, false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("PARKOK", MODE_PRIVATE);
        int screenOrigin = preferences.getInt("SCREEN_ORIGEN", 0);

        switch (screenOrigin) {
            case 1:
                mVpContent.setCurrentItem(0, false);
                break;

            case 2:
                mVpContent.setCurrentItem(1, false);
                break;

            case 3:
                mVpContent.setCurrentItem(2, false);
                break;

            case 4:
                mVpContent.setCurrentItem(3, false);
                break;

        }
    }

}



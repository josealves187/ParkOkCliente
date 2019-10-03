package br.com.crosoften.parkokcliente.view.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import br.com.crosoften.parkokcliente.view.fragmenst.HistoricFragment;
import br.com.crosoften.parkokcliente.view.fragmenst.MapFragment;
import br.com.crosoften.parkokcliente.view.fragmenst.QRcodeFragment;
import br.com.crosoften.parkokcliente.view.fragmenst.ReferFriendFragment;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    public HomeViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new QRcodeFragment();
            case 1:
                return new MapFragment();
            case 2:
                return new HistoricFragment();
            case 3:
                return new ReferFriendFragment();

        }
        return new QRcodeFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}

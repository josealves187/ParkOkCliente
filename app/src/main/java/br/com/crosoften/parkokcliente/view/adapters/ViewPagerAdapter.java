package br.com.crosoften.parkokcliente.view.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import br.com.crosoften.parkokcliente.view.fragmenst.FriendFragment;
import br.com.crosoften.parkokcliente.view.fragmenst.IndicatesParkingFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FriendFragment();

            case 1:
                return new IndicatesParkingFragment();

            default:
                return new FriendFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

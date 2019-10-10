package br.com.crosoften.parkokcliente.view.fragmenst;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.view.adapters.ViewPagerAdapter;
import br.com.crosoften.parkokcliente.view.custom.ViewPagerCustom;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReferFriendFragment extends Fragment {


    private TabLayout tlReferFriend;
    private ViewPagerCustom vpView;
    private MaterialToolbar mt_toolbar_refer_friends;

    public ReferFriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_refer_friend, container, false);
        initializeComponents(view);


        return view;
    }

    private void initializeComponents(View view) {
        tlReferFriend = view.findViewById(R.id.tl_refer_friend);
        vpView = view.findViewById(R.id.vp_view);
        mt_toolbar_refer_friends = view.findViewById(R.id.mt_toolbar_refer_friends);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupTabLayout();

    }

    /**
     * Método responsável por seta o TabLayout com os fragments de Idicação de amigo e de estacionamento
     */
    private void setupTabLayout() {
        tlReferFriend = getActivity().findViewById(R.id.tl_refer_friend);
        vpView = getActivity().findViewById(R.id.vp_view);


        tlReferFriend.addTab(tlReferFriend.newTab().setText(getString(R.string.refer_friend)));
        tlReferFriend.addTab(tlReferFriend.newTab().setText(getString(R.string.referpack)));
        vpView.setOffscreenPageLimit(2);
        vpView.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

        tlReferFriend.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(
                        vpView
                )
        );

        vpView.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(
                        tlReferFriend
                )
        );
    }

}

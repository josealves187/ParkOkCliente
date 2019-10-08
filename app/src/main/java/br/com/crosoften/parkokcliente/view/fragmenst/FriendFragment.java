package br.com.crosoften.parkokcliente.view.fragmenst;


import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {

    private MaterialButton btnActivateCode;
    private TextView tvActivateCode;


    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        btnActivateCode = view.findViewById(R.id.btn_activate_code);
        tvActivateCode = view.findViewById(R.id.tv_activate_code);
        eventButton();
        return view;
    }

    private void eventButton() {


        btnActivateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validCredential = true;
                if (tvActivateCode.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Entre com código", Toast.LENGTH_SHORT).show();
                }else if (validCredential){
                    Toast.makeText(getActivity(), "Cógigo ativado", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}

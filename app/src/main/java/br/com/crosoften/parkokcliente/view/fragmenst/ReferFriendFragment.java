package br.com.crosoften.parkokcliente.view.fragmenst;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.view.activities.ChangeDataActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReferFriendFragment extends Fragment {

    private MaterialButton btnActivateCode;
    private TextView tvActivateCode;

    public ReferFriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_refer_friend, container, false);

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
                    tvActivateCode.setError("Entre com código");
                    tvActivateCode.requestFocus();
                }else if (validCredential){
                    Toast.makeText(getActivity(), "Cógigo ativado", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}

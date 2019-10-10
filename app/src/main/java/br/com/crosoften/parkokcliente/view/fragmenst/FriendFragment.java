package br.com.crosoften.parkokcliente.view.fragmenst;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import br.com.crosoften.parkokcliente.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {

    private MaterialButton btnActivateCode;
    private MaterialButton btnShare;
    private TextView tvActivateCode;
    private TextView tvTitleCode;


    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        initializeComponent(view);
        eventButton();
        return view;
    }

    private void initializeComponent(View view) {
        btnActivateCode = view.findViewById(R.id.btn_activate_code);
        btnShare = view.findViewById(R.id.btn_share);
        tvActivateCode = view.findViewById(R.id.tv_activate_code);
        tvTitleCode = view.findViewById(R.id.tv_code);
    }

    private void eventButton() {


        btnActivateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validCredential = true;
                if (tvActivateCode.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Entre com código", Toast.LENGTH_SHORT).show();
                } else if (validCredential) {
                    Toast.makeText(getActivity(), "Cógigo ativado", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String share = tvTitleCode.getText().toString();
              shareText(share);
            }
        });


    }

    //metodo para compartilhar código indicar amigos
    private void shareText(String text) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        sendIntent.setType("text/plain");
        //sendIntent.setPackage("com.whatsapp");//apenas whatsapp
        try {
            Intent chooserIntent = Intent.createChooser(sendIntent, "Escolha App de compartilhamento");
            if (chooserIntent == null) {
                return;

            }
            startActivity(chooserIntent);
        } catch (Exception e) {
            startActivity(sendIntent);

        }
    }


}

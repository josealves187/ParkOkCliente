package br.com.crosoften.parkokcliente.view.fragmenst;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.crosoften.parkokcliente.R;


public class IndicatesParkingFragment extends Fragment {

    private TextView copy;
    private TextView tvTitleCode;

    public IndicatesParkingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_indicates_parking, container, false);
        initializeComponents(view);
        evetButton();
        return view;
    }

    private void initializeComponents(View view) {
        copy = view.findViewById(R.id.tv_copy);
        tvTitleCode = view.findViewById(R.id.tv_title_code);
    }

    private void evetButton() {
         final String codigoPromo = tvTitleCode.getText().toString().trim();
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) IndicatesParkingFragment.this.getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Código Promocional", codigoPromo);
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(IndicatesParkingFragment.this.getActivity(), "Copiado para área de transferência", Toast.LENGTH_LONG).show();
            }
        });
    }


}

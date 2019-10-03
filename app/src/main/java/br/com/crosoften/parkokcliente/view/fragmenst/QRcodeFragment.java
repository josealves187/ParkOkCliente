package br.com.crosoften.parkokcliente.view.fragmenst;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.QrCode;
import br.com.crosoften.parkokcliente.view.activities.ProfileActivity;
import br.com.crosoften.parkokcliente.view.activities.QRCodeUser.QRCodePostReadingActivity;
import br.com.crosoften.parkokcliente.view.adapters.listeners.QrCodeListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRcodeFragment extends Fragment implements QrCodeListener {

    private CardView cmProfile;
    private ImageView ivQRcodeInput;




    public QRcodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qrcode, container, false);
        cmProfile = view.findViewById(R.id.cm_profile);
        ivQRcodeInput = view.findViewById(R.id.iv_qr_code_input);
        eventoButton();
        homeQrcode();
        return view;

    }

    private void homeQrcode() {
//        pegando o valor de EditText para mosta na geração QRcode
//        String text = TextView.getText().toString();
//        if (text != null && !text.isEmpty())
            try {

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                BitMatrix bitMatrix = multiFormatWriter.encode("teste", BarcodeFormat.QR_CODE,500,500);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                ivQRcodeInput.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }

    }



    private void eventoButton() {
        cmProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ProfileActivity.class);
                startActivity(i);

            }
        });

        ivQRcodeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), QRCodePostReadingActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    public void qrCodeOnClick(QrCode attendence, int position) {

    }

}

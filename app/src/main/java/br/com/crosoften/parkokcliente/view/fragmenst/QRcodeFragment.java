package br.com.crosoften.parkokcliente.view.fragmenst;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.QrCode;
import br.com.crosoften.parkokcliente.commom.Users;
import br.com.crosoften.parkokcliente.view.activities.ProfileActivity;
import br.com.crosoften.parkokcliente.view.activities.QRCodeUser.QRCodePostReadingActivity;
import br.com.crosoften.parkokcliente.view.adapters.listeners.QrCodeListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRcodeFragment extends Fragment implements QrCodeListener {

    private CardView cmProfile;
    private ImageView ivQRcodeInput;
    private CircleImageView acivPhotoProfile;
    private TextView tvNameProfile;




    public QRcodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qrcode, container, false);
        initializeComponents(view);
        eventoButton();
        homeQrcode();


        Users users = new Users(1, "José" , "14587965288", "jralves187@gmail.com");
        if (users != null) {
            Glide.with(this)
                    .load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f")
                    .into(acivPhotoProfile);
            tvNameProfile.setText(getString(R.string.helo_qrcode,users.getNameUser()));

            SpannableString(users);

        }
        return view;

    }

    /***
     * colocando cor no texto usando  SpannableString
     * */
    private void SpannableString(Users users) {
        SpannableString ss = new SpannableString(getString(R.string.helo_qrcode,users.getNameUser()));
        ss.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.colorNameTextView)), 0, 4, 0);

        tvNameProfile.setText(ss);
    }

    private void initializeComponents(View view) {
        cmProfile = view.findViewById(R.id.cm_profile);
        ivQRcodeInput = view.findViewById(R.id.iv_qr_code_input);
        tvNameProfile = view.findViewById(R.id.tv_hello_profile);
        acivPhotoProfile = view.findViewById(R.id.aciv_photo_profile);
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

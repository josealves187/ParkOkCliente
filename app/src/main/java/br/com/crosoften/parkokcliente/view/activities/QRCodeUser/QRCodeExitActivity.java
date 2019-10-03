package br.com.crosoften.parkokcliente.view.activities.QRCodeUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import br.com.crosoften.parkokcliente.R;

public class QRCodeExitActivity extends AppCompatActivity {

    private ImageView ivQRcodeExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_exit);
        initializeComponents();
        exitQrcode();
    }

    //
    private void exitQrcode() {
//        pegando o valor de EditText para mosta na geração QRcode
//        String text = TextView.getText().toString();
//        if (text != null && !text.isEmpty())
        try {

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode("teste", BarcodeFormat.QR_CODE,500,500);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            ivQRcodeExit.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    private void initializeComponents() {
        ivQRcodeExit = findViewById(R.id.iv_qr_code_input);
        //ADD Toobar
        Toolbar toolbar = findViewById(R.id.mt_toolbar_qrcode_exit);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

package com.idiots.smart_code_generater;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class genrate_qr extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genrate_qr);
        Button button = findViewById(R.id.generate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText name_text_view = findViewById(R.id.text_input);
                String text = name_text_view.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(genrate_qr.this, "please enter something", Toast.LENGTH_SHORT).show();
                } else {
                    generateORCode(text);
                }
            }
        });
        Button cbutton = findViewById(R.id.clear_button);
        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText name_text_view = findViewById(R.id.text_input);
                name_text_view.setText("");
            }
        });
    }

    private void generateORCode(String text) {
        if (text == null) {
            TextInputEditText name_text_view = findViewById(R.id.text_input);
            name_text_view.setError("please enter something");
        } else {
            String final_string = text;

            QRCodeWriter writer = new QRCodeWriter();
            try {
                BitMatrix bitMatrix = writer.encode(final_string, BarcodeFormat.QR_CODE, 512, 512);
                int width = bitMatrix.getWidth();
                int height = bitMatrix.getHeight();
                Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                    }
                }
                ((ImageView) findViewById(R.id.qr_code_image)).setImageBitmap(bmp);

            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
    }
}
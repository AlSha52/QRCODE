package com.example.qrcodetest;


import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class SecondActivity extends AppCompatActivity {

    public static TextView tvresult;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvresult = (TextView) findViewById(R.id.tvresult);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });
    }

   


}

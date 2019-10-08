package com.example.qrcodetest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity  {

   Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED ){

                    requestPermmision();

                }else{
//                    turnOnGPS();
                    Toast.makeText(MainActivity.this, "permission has granted!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
                }
            }
        });
    }

    private void requestPermmision() {
        ActivityCompat.requestPermissions(this
                ,new String[]{Manifest.permission.CAMERA},1234);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1234:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED ){
                    // Do_SOme_Operation();

//                    turnOnGPS();
                    Toast.makeText(this, "Permission has granted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
                }

            default:
                super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }

}

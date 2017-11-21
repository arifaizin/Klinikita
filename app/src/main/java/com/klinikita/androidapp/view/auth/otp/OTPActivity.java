package com.klinikita.androidapp.view.auth.otp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.chaos.view.PinView;
import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.home.HomeActivity;


public class OTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi);
        getSupportActionBar().hide();

        PinView pinView = (PinView) findViewById(R.id.pinView);
        pinView.setAnimationEnable(true);// start animation when adding text


    }

    public void submit(View view) {
        Intent intent = new Intent(OTPActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}

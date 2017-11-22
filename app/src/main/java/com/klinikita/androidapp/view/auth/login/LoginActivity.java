package com.klinikita.androidapp.view.auth.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.klinikita.androidapp.view.auth.register.RegisterActivity;
import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.auth.otp.OTPActivity;
import com.klinikita.androidapp.view.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

    }


    public void masuk(View view) {
//        Intent intent = new Intent(LoginActivity.this,OTPActivity.class);
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void daftar_disini(View view) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public void hubungi(View view) {
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}

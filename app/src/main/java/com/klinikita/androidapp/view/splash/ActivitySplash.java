package com.klinikita.androidapp.view.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.auth.login.LoginActivity;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivitySplash.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, 5000);
    }
}

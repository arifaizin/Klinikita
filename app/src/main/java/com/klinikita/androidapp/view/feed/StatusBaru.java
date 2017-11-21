package com.klinikita.androidapp.view.feed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.klinikita.androidapp.R;

public class StatusBaru extends AppCompatActivity {
ImageView iv_Foto, iv_video, iv_upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_baru);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        iv_Foto = (ImageView)findViewById(R.id.iv_foto);
        iv_video = (ImageView)findViewById(R.id.iv_video);
        iv_upload = (ImageView)findViewById(R.id.iv_upload);
        iv_Foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StatusBaru.this,FeedHomeFragment.class);
                startActivity(i);
            }
        });
        iv_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StatusBaru.this,FeedHomeFragment.class);
            }
        });

    }}

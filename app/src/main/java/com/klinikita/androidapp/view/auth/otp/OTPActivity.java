package com.klinikita.androidapp.view.auth.otp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.klinikita.androidapp.R;
import com.klinikita.androidapp.helper.Config;
import com.klinikita.androidapp.helper.Konstanta;
import com.klinikita.androidapp.rest.ApiService;
import com.klinikita.androidapp.rest.Client;
import com.klinikita.androidapp.view.auth.register.RegisterActivity;
import com.klinikita.androidapp.view.home.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OTPActivity extends AppCompatActivity {
    PinView pinView;
    private TextView tvKirimLagi;
    private TextView tvKodeSuara;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi);
        getSupportActionBar().hide();

        pinView = (PinView) findViewById(R.id.pinView);
        pinView.setAnimationEnable(true);// start animation when adding text

        initView();

        tvKirimLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kirimOTP();
            }
        });
    }

    public void submit(View view) {
        verivikasiOTP();
    }

    private void verivikasiOTP() {
        ApiService api = Client.getApiService(Config.BASE_URL_SMSNOTIF);
        Call<ResponseBody> call = api.verivikasiOTP(pinView.getText().toString(), "4");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    JSONObject json = null;
                    try {
                        json = new JSONObject(response.body().string());
                        String message = json.getString("message");
                        Toast.makeText(OTPActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(OTPActivity.this, HomeActivity.class);
                        startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    finish();
                } else {
                    Toast.makeText(OTPActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(OTPActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initView() {
        tvKirimLagi = (TextView) findViewById(R.id.tv_kirim_lagi);
        tvKodeSuara = (TextView) findViewById(R.id.tv_kode_suara);
    }


    private void kirimOTP() {
        SharedPreferences pref = getSharedPreferences(Konstanta.SETTING, MODE_PRIVATE);
        String nomertelp = pref.getString(Konstanta.NO_TELP,"08");
        final String nomer = "0" + nomertelp;
        ApiService api = Client.getApiService(Config.BASE_URL_SMSNOTIF);
        Call<ResponseBody> call = api.kirimOTP(nomer, "4");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(RegisterActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                    JSONObject json = null;
                    try {
                        json = new JSONObject(response.body().string());
                        String message = json.getString("message");
                        Toast.makeText(OTPActivity.this, "" + message, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(OTPActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(OTPActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

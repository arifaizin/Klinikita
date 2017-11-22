package com.klinikita.androidapp.view.auth.register;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.helper.Config;
import com.klinikita.androidapp.helper.Konstanta;
import com.klinikita.androidapp.rest.ApiService;
import com.klinikita.androidapp.rest.Client;
import com.klinikita.androidapp.view.auth.login.LoginActivity;
import com.klinikita.androidapp.view.auth.otp.OTPActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private TextInputEditText tvNama;
    private TextInputEditText tvNomer;
    private TextInputEditText tvEmail;
    private Button buttonDaftar;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        getSupportActionBar().hide();

        pref = getSharedPreferences(Konstanta.SETTING, MODE_PRIVATE);
        initView();

        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        String number = tm.getLine1Number();
        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
        alert.setTitle("Pakai nomer ini?");
        alert.setMessage(number);
        alert.show();
    }

    public void login(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void kirimOTP() {
        final String nomer = "0"+tvNomer.getText().toString();
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
                        Toast.makeText(RegisterActivity.this, ""+message, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString(Konstanta.NO_TELP, nomer);
                    editor.commit();

                } else {
                    Toast.makeText(RegisterActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void daftarNo(View view) {
        kirimOTP();
        Intent intent = new Intent(RegisterActivity.this, OTPActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void initView() {
        tvNama = (TextInputEditText) findViewById(R.id.tv_nama);
        tvNomer = (TextInputEditText) findViewById(R.id.tv_nomer);
        tvEmail = (TextInputEditText) findViewById(R.id.tv_email);
        buttonDaftar = (Button) findViewById(R.id.button_daftar);
        tvLogin = (TextView) findViewById(R.id.tv_login);
    }
}

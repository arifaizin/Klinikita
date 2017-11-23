package com.klinikita.androidapp.view.beliobat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.klinikita.androidapp.R;
import com.klinikita.androidapp.helper.Config;
import com.klinikita.androidapp.helper.Konstanta;
import com.klinikita.androidapp.rest.ApiService;
import com.klinikita.androidapp.rest.Client;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailObatActivity extends AppCompatActivity {
    //logt
    private static final String TAG = "DetailWisataActivity";

    String dataNama, dataAlamat, dataDeskripsi, dataGambar;
    Boolean isFavorit;
    SharedPreferences pref;
    FloatingActionButton fab;
    TextView hargaobat;
    int quantity = 1;
    String lat = "";
    String lng = "";
    private Button btnBeli;
    private String dataId;
    private String dataHarga;
    private TextView Obat;
    private TextView HargaObat;
    private TextView Deskripsi;
    private TextView tambahcatatan;
    private TextView jmlobat;
    private TextView perkiraanharga;
    private TextView biayaantar;
    private TextView totalharga;
    private TextView bayartunai;
    private Button btnPesan;
    private TextView tvPlaceAPI;
    // konstanta untuk mendeteksi hasil balikan dari place picker
    private int PLACE_PICKER_REQUEST = 1;
    private TextView alamat;
    private CardView placepicker;
    private TextView ubahLokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_obat);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        hargaobat = (TextView) findViewById(R.id.HargaObat);
        perkiraanharga = (TextView) findViewById(R.id.perkiraanharga);
        biayaantar = (TextView) findViewById(R.id.biayaantar);
        totalharga = (TextView) findViewById(R.id.totalharga);
        bayartunai = (TextView) findViewById(R.id.bayartunai);
        initView();
        //terima data
        dataId = getIntent().getExtras().getString(Konstanta.DATA_ID);
        dataNama = getIntent().getExtras().getString(Konstanta.DATA_NAMA);
        dataDeskripsi = getIntent().getExtras().getString(Konstanta.DATA_DESKRIPSI);
        dataGambar = getIntent().getExtras().getString(Konstanta.DATA_GAMBAR);
        dataHarga = getIntent().getExtras().getString(Konstanta.DATA_HARGA);

        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kirimNotif();
            }
        });

        hargaobat.setText("Rp. "+dataHarga);
        perkiraanharga.setText("Rp. "+dataHarga);
        biayaantar.setText("Rp. 5000");
        totalharga.setText("Rp. "+dataHarga);
        bayartunai.setText("Rp. "+dataHarga);
        Obat.setText(dataNama);
        Deskripsi.setText(dataDeskripsi);

        Log.d(TAG, "onCreate: " + dataId + dataNama + dataHarga + dataGambar + dataDeskripsi);

        ubahLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(DetailObatActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        if (requestCode == PLACE_PICKER_REQUEST && resultCode == RESULT_OK) {
            Place place = PlacePicker.getPlace(imageReturnedIntent, DetailObatActivity.this);
            String information = String.format("%s , %s", place.getName(), place.getAddress());
            lat = String.valueOf(place.getLatLng().latitude);
            lng = String.valueOf(place.getLatLng().longitude);
            alamat.setText(information);
        }
    }

    private void kirimNotif() {
        final ProgressDialog progress = new ProgressDialog(DetailObatActivity.this);
        progress.setTitle("Loading");
        progress.setMessage("Mohon Bersabar");
        progress.show();

        SharedPreferences pref = getSharedPreferences(Konstanta.SETTING, MODE_PRIVATE);
        String nomertelp = pref.getString(Konstanta.NO_TELP, "08");
//        Toast.makeText(this, ""+nomertelp, Toast.LENGTH_SHORT).show();

        ApiService api = Client.getApiService(Config.BASE_URL_SMSNOTIF);
        Call<ResponseBody> call = api.kirimNotif(nomertelp, "Terima kasih sudah melakukan pemesanan Obat di Klinik Kita. Silahkan lakukan pembayaran segera sejumlah " + bayartunai.getText().toString() + " ke Rek. 324424234 a.n Kalif Ardy sebelum pukul 16.00");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progress.dismiss();
                if (response.isSuccessful()) {
                    JSONObject json = null;
                    try {
                        json = new JSONObject(response.body().string());
                        String message = json.getString("message");
                        Toast.makeText(DetailObatActivity.this, "" + message, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//                    Toast.makeText(DetailObatActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailObatActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(DetailObatActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void kurang(View v) {
        if (quantity == 1) {
            Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        hargaobat.setText("Rp. " + Integer.parseInt(dataHarga) * quantity);
        perkiraanharga.setText("Rp. " + Integer.parseInt(dataHarga) * quantity);
        totalharga.setText("Rp. " + ((Integer.parseInt(dataHarga) * quantity) + 5000));
        bayartunai.setText("Rp. " + ((Integer.parseInt(dataHarga) * quantity) + 5000));

        display(quantity);
    }


    public void tambah(View v) {
        if (quantity == 100) {
            Toast.makeText(this, "pesanan maksimal 100", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;
        hargaobat.setText("Rp. " + Integer.parseInt(dataHarga) * quantity);
        perkiraanharga.setText("Rp. " + Integer.parseInt(dataHarga) * quantity);
        totalharga.setText("Rp. " + ((Integer.parseInt(dataHarga) * quantity) + 5000));
        bayartunai.setText("Rp. " + ((Integer.parseInt(dataHarga) * quantity) + 5000));

        display(quantity);
    }


    private void display(int number) {
        TextView jumlahobat = (TextView) findViewById(R.id.jmlobat);
        jumlahobat.setText("" + number);
    }

    private void initView() {
        btnBeli = (Button) findViewById(R.id.btnPesan);
        Obat = findViewById(R.id.Obat);
        HargaObat = findViewById(R.id.HargaObat);
        Deskripsi = findViewById(R.id.Deskripsi);
        tambahcatatan = findViewById(R.id.tambahcatatan);
        jmlobat = findViewById(R.id.jmlobat);
        perkiraanharga = findViewById(R.id.perkiraanharga);
        biayaantar = findViewById(R.id.biayaantar);
        totalharga = findViewById(R.id.totalharga);
        bayartunai = findViewById(R.id.bayartunai);
        btnPesan = findViewById(R.id.btnPesan);
        alamat = (TextView) findViewById(R.id.alamat);
        placepicker = (CardView) findViewById(R.id.placepicker);
        ubahLokasi = (TextView) findViewById(R.id.ubah_lokasi);
    }
}


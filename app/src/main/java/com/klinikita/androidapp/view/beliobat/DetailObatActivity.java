package com.klinikita.androidapp.view.beliobat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.klinikita.androidapp.R;
import com.klinikita.androidapp.helper.Konstanta;

import java.io.IOException;
import java.text.BreakIterator;

public class DetailObatActivity extends AppCompatActivity {
    //logt
    private static final String TAG = "DetailWisataActivity";

    String dataNama, dataAlamat, dataDeskripsi, dataGambar;
    Boolean isFavorit;
    SharedPreferences pref;
    FloatingActionButton fab;
    private Button btnBeli;
    private String dataId;
    private String dataHarga;
    TextView hargaobat;
    int quantity = 0;
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
    private int PICK_IMAGE_REQUEST;

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

        //terima data
        dataId = getIntent().getExtras().getString(Konstanta.DATA_ID);
        dataNama = getIntent().getExtras().getString(Konstanta.DATA_NAMA);
        dataDeskripsi = getIntent().getExtras().getString(Konstanta.DATA_DESKRIPSI);
        dataGambar = getIntent().getExtras().getString(Konstanta.DATA_GAMBAR);
        dataHarga = getIntent().getExtras().getString(Konstanta.DATA_HARGA);

        hargaobat.setText(dataHarga);
        perkiraanharga.setText(dataHarga);
        biayaantar.setText(dataHarga);
        totalharga.setText(dataHarga);
        bayartunai.setText(dataHarga);

        Log.d(TAG, "onCreate: " + dataId + dataNama + dataHarga + dataGambar + dataDeskripsi);
        tvPlaceAPI = (TextView) findViewById(R.id.alamat);

        tvPlaceAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(DetailObatActivity.this), 2);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }



//
//        //logd untuk menampilkan di logcat
//        Log.d(TAG, "onCreate: " + dataNama + dataGambar + dataDeskripsi + dataAlamat);
//
//        //ambil data dari sharedpreference
//        pref = getSharedPreferences(Konstanta.SETTING, MODE_PRIVATE);
//        isFavorit = pref.getBoolean(Konstanta.TAG_PREF+dataNama, false);
//
//
//        fab = (FloatingActionButton)findViewById(R.id.fab);
//        cekFavorit(isFavorit);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //simpan ke favorit jika pref false
//
//                if(isFavorit){
//                    //jika love penuh
//                    //hapus dari sqlite
//                    long id = database.delete(dataNama);
//
//                    if (id<=0){
//                        Snackbar.make(view, "Favorit gagal dihapus dari database", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                    } else {
//                        Snackbar.make(view, "Favorit dihapus dari database", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//
//                        //bikin false
//                        SharedPreferences.Editor editor = pref.edit();
//                        editor.putBoolean(Konstanta.TAG_PREF+dataNama, false);
//                        editor.commit();
//                        isFavorit = false;
//                    }
//
//                } else {
//                    //jika love kosong
//                    //simpan ke sqlite
//                    long id = database.insertData(dataNama,dataGambar, dataAlamat, dataDeskripsi, "12.232", "3.212");
//
//                    Log.d(TAG, "id kembalian: "+id);
//                    if (id<=0){
//                        Snackbar.make(view, "Favorit gagal ditambahkan ke database", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//                    } else {
//                        Snackbar.make(view, "Favorit ditambahkan ke database", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//
//                        //bikin true
//                        SharedPreferences.Editor editor = pref.edit();
//                        editor.putBoolean(Konstanta.TAG_PREF+dataNama, true);
//                        editor.commit();
//                        isFavorit = true;
//                    }
//
//                }
//
//                cekFavorit(isFavorit);
//
//            }
//        });
//
//
//
//        TextView tvAlamat = (TextView) findViewById(R.id.tv_detail_alamat);
//        TextView tvDeskripsi = (TextView) findViewById(R.id.tv_detail_deskripsi);
//        ImageView ivGambar = (ImageView) findViewById(R.id.iv_detail_gambar);
//
//        tvAlamat.setText(dataAlamat);
//        tvDeskripsi.setText(dataDeskripsi);
//        Glide.with(DetailObatActivity.this).load("http://52.187.117.60/wisata_semarang/img/wisata/"+dataGambar).into(ivGambar);
//
//        getSupportActionBar().setTitle(dataNama);

                initView();

                btnBeli.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        kirimNotif();
                    }
                });
            }
        });
    }
    String lat = "";
    String lng = "";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && imageReturnedIntent != null && imageReturnedIntent.getData() != null) {

            Uri uri = imageReturnedIntent.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                Log.d("TAG", String.valueOf(bitmap));


                ImageView imageView = null;
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            Place place = PlacePicker.getPlace(imageReturnedIntent, DetailObatActivity.this);
            String information = String.format("%s", place.getName());
            lat = String.valueOf(place.getLatLng().latitude);
            lng = String.valueOf(place.getLatLng().longitude);
            BreakIterator statusMaps=null;
            statusMaps.setText(information);
        }

    }




    private void kirimNotif() {

            }

            public void kurang(View v) {
                if (quantity == 1) {
                    Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                quantity = quantity - 1;
                hargaobat.setText("" + Integer.parseInt(dataHarga) * quantity);
                perkiraanharga.setText("" + Integer.parseInt(dataHarga) * quantity);
                biayaantar.setText("" + ((Integer.parseInt(dataHarga) * quantity) + 5000));
                totalharga.setText("" + ((Integer.parseInt(dataHarga) * quantity) + 5000));
                bayartunai.setText("" + ((Integer.parseInt(dataHarga) * quantity) + 5000));

                display(quantity);
            }

            public void tambah(View v) {
                if (quantity == 100) {
                    Toast.makeText(this, "pesanan maximal 100", Toast.LENGTH_SHORT).show();
                    return;
                }
                quantity = quantity + 1;
                hargaobat.setText("" + Integer.parseInt(dataHarga) * quantity);
                perkiraanharga.setText("" + Integer.parseInt(dataHarga) * quantity);
                biayaantar.setText("" + ((Integer.parseInt(dataHarga) * quantity) + 5000));
                totalharga.setText("" + ((Integer.parseInt(dataHarga) * quantity) + 5000));
                bayartunai.setText("" + ((Integer.parseInt(dataHarga) * quantity) + 5000));

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
            }
        }


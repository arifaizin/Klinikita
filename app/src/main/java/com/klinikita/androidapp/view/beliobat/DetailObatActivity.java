package com.klinikita.androidapp.view.beliobat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.helper.Konstanta;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_obat);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //terima data
        dataId = getIntent().getExtras().getString(Konstanta.DATA_ID);
        dataNama = getIntent().getExtras().getString(Konstanta.DATA_NAMA);
        dataDeskripsi = getIntent().getExtras().getString(Konstanta.DATA_DESKRIPSI);
        dataGambar = getIntent().getExtras().getString(Konstanta.DATA_GAMBAR);
        dataHarga = getIntent().getExtras().getString(Konstanta.DATA_HARGA);

        Log.d(TAG, "onCreate: "+ dataId+dataNama+dataHarga+dataGambar+dataDeskripsi);
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

    private void kirimNotif() {

    }

    private void initView() {
        btnBeli = (Button) findViewById(R.id.btnPesan);
    }
}
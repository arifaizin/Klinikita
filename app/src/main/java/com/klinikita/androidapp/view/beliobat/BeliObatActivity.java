package com.klinikita.androidapp.view.beliobat;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.rest.ApiService;
import com.klinikita.androidapp.rest.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeliObatActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ObatModel> listData;
    private static final String TAG = "BeliObatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_obat);
        recyclerView = (RecyclerView) findViewById(R.id.recyler_view);

        //Data
        listData = new ArrayList<>();

        ambilData();

//        for (int i = 0; i < 10; i++) {
//            listData.add(new ArrayList<ObatModel>("1", "Obat1 ", "2121", "dsddsdas", "1wAsZYdIONZECBIYnw2QHtRl9x1owfJly", "ewew"));
//        }
        //adapter
        ObatAdapter adapter = new ObatAdapter(listData, BeliObatActivity.this);
        recyclerView.setAdapter(adapter);

        // layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(BeliObatActivity.this));

    }

    private void ambilData() {
        final ProgressDialog progress = new ProgressDialog(BeliObatActivity.this);
        progress.setTitle("Loading");
        progress.setMessage("Mohon Bersabar");
        progress.show();

        ApiService api = Client.getApiService();
        Call<ListObatModel> call = api.ambilData();
        call.enqueue(new Callback<ListObatModel>() {
            @Override
            public void onResponse(Call<ListObatModel> call, Response<ListObatModel> response) {
                if (response.isSuccessful()){
                    progress.dismiss();
                    listData = response.body().getObat();

                    for (int i = 0; i < listData.size(); i++) {
                        ObatAdapter adapter = new ObatAdapter(listData, BeliObatActivity.this);
                        recyclerView.setAdapter(adapter);
                            Log.d(TAG, "onResponse: " + listData.get(i).getNamaObat());
                    }
                } else {
                    Toast.makeText(BeliObatActivity.this, "Respones is Not Succesfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListObatModel> call, Throwable t) {

            }
        });
    }
}
//        call.enqueue(new Callback<ArrayList<ListObatModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<ListObatModel>> call, Response<ArrayList<ListObatModel>> response) {
//                progress.hide();
//                if (response.isSuccessful()){
////                    if(response.body().getObat().toString().equals("true")){
//                    for (int i = 0; i < response.body().getObat().size(); i++) {
//                        listData = response.body().getObat().get();
//                        WisataAdapter adapter = new WisataAdapter(listData, BeliObatActivity.this);
//                        recyclerView.setAdapter(adapter);
//                        for (int i = 0; i < listData.size(); i++) {
//                            Log.d(TAG, "onResponse: " + listData.get(i).getGambarWisata());
//                        }
//                    }
//
//                    } else {
//                        Toast.makeText(BeliObatActivity.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(BeliObatActivity.this, "Respones is Not Succesfull", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<ListObatModel>> call, Throwable t) {
//                Toast.makeText(BeliObatActivity.this, "Response Failure", Toast.LENGTH_SHORT).show();
//            }
//        });
//}}}
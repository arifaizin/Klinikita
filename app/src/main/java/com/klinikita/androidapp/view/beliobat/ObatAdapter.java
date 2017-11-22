package com.klinikita.androidapp.view.beliobat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.klinikita.androidapp.R;
import com.klinikita.androidapp.helper.Konstanta;

import java.util.ArrayList;

/**
 * Created by keyalive on 21/11/2017.
 */

public class ObatAdapter extends  RecyclerView.Adapter<ObatAdapter.MyViewHolder> {
    private ArrayList<ObatModel> listData;
    private Context context;

    public ObatAdapter(ArrayList<ObatModel> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    //Mengubungkan dengan layout itemnya
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_obat_item_list, parent, false);
        return new MyViewHolder(itemView);
    }

    //Buat meset item RecyclerView
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tvNamaWisata.setText(listData.get(position).getNamaObat());
        holder.tvAlamatWisata.setText(listData.get(position).getDeskripsiObat());
        Glide.with(context)
                .load("https://drive.google.com/thumbnail?id="+listData.get(position).getGambarObat())
//                .placeholder(R.drawable.no_image_found)
//                .error(R.drawable.no_image_found)
                .into(holder.ivGambarWisata);

        ///untuk kirim data
        final Bundle datakiriman = new Bundle();
        datakiriman.putString(Konstanta.DATA_ID,listData.get(position).getIdObat());
        datakiriman.putString(Konstanta.DATA_NAMA,listData.get(position).getNamaObat());
        datakiriman.putString(Konstanta.DATA_GAMBAR,listData.get(position).getGambarObat());
        datakiriman.putString(Konstanta.DATA_DESKRIPSI,listData.get(position).getDeskripsiObat());
        datakiriman.putString(Konstanta.DATA_HARGA,listData.get(position).getHargaObat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailObatActivity.class);
                pindah.putExtras(datakiriman);
                context.startActivity(pindah);
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle data = new Bundle();
//                data.putString(Konstanta.DATA_ID, listData.get(position).getIdWisata());
//                data.putString(Konstanta.DATA_NAMA, listData.get(position).getNamaWisata());
//                data.putString(Konstanta.DATA_GAMBAR, listData.get(position).getGambarWisata());
//                data.putString(Konstanta.DATA_DESKRIPSI, listData.get(position).getDeksripsiWisata());
//                data.putString(Konstanta.DATA_ALAMAT, listData.get(position).getAlamatWisata());
//                data.putString(Konstanta.DATA_LAT, listData.get(position).getLatitudeWisata());
//                data.putString(Konstanta.DATA_LNG, listData.get(position).getLongitudeWisata());
//
//                Intent pindah = new Intent(context, DetailWisataActivity.class);
//                pindah.putExtras(data);
//                context.startActivity(pindah);
//            }
//        });
    }

    //Jumlah Item
    @Override
    public int getItemCount() {
        return listData.size();
    }

    //Inisialisasi Widger pada item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGambarWisata;
        TextView tvNamaWisata, tvAlamatWisata;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivGambarWisata = (ImageView) itemView.findViewById(R.id.iv_item_gambar);
            tvAlamatWisata = (TextView) itemView.findViewById(R.id.tv_item_alamat);
            tvNamaWisata = (TextView) itemView.findViewById(R.id.tv_item_nama);
        }
    }
}

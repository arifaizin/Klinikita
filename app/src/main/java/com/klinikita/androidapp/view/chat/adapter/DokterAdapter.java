package com.klinikita.androidapp.view.chat.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.chat.ObrolanKlinikita;

import java.util.ArrayList;

/**
 * Created by DELLL on 9/29/2017.
 */

public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.DokterViewHolder> {
    private Context context;
    private ArrayList<Dokter>listDokter;

    public DokterAdapter (Context context, ArrayList<Dokter>listDokter){
        this.context = context;
        this.listDokter = listDokter;
    }
    @Override
    public DokterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dokter_klinikita,parent,false);
        return new DokterViewHolder(view);
    }
    public class DokterViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageDokter;
        private TextView nameDokter, bidang,harga;
        public LinearLayout  llMore;
        public TextView tvseeMore, tvlessMore,btn_chat;

        public DokterViewHolder(View itemView) {
            super(itemView);
            imageDokter = (ImageView)itemView.findViewById(R.id.iv_dokter);
            nameDokter = (TextView)itemView.findViewById(R.id.tv_namaDokter);
            bidang =(TextView)itemView.findViewById(R.id.tv_bidang_dokter);
            harga = (TextView)itemView.findViewById(R.id.tv_status_dokter);
            llMore = (LinearLayout)itemView.findViewById(R.id.ll_more);
            tvseeMore = (TextView) itemView.findViewById(R.id.tv_see_more);
            tvlessMore = (TextView) itemView.findViewById(R.id.tv_less_more);
            btn_chat = (TextView)itemView.findViewById(R.id.button_chat);
            btn_chat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(),ObrolanKlinikita.class);
                    view.getContext().startActivity(i);


                }
            });


            tvseeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvseeMore.setVisibility(View.GONE);
                    llMore.setVisibility(View.VISIBLE);
                    tvlessMore.setVisibility(View.VISIBLE);


                }
            });

            tvlessMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvlessMore.setVisibility(View.GONE);
                    llMore.setVisibility(View.GONE);
                    tvseeMore.setVisibility(View.VISIBLE);
                }
            });

        }
    }

    @Override
    public void onBindViewHolder(DokterViewHolder holder, int position) {
        holder.imageDokter.setImageResource(listDokter.get(position).getGambarokter());
        holder.nameDokter.setText(listDokter.get(position).getNamaDokter());
        holder.bidang.setText(listDokter.get(position).getBidangDokter());
        holder.harga.setText(listDokter.get(position).getHarga());

    }

    @Override
    public int getItemCount() {
        return listDokter.size();
    }


}

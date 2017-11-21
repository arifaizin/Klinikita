package com.klinikita.androidapp.view.more.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.dompetkita.DompetKitaActivity;

import java.util.ArrayList;

/**
 * Created by DELLL on 9/13/2017.
 */

public class MoreRecyclerAdapter extends RecyclerView.Adapter<MoreRecyclerAdapter.MoreViewHolder> {
    private Context context;
    private ArrayList<String> moreData;
    private ArrayList<Integer> moreImage;


    public MoreRecyclerAdapter(Context context, ArrayList<String> moreData, ArrayList<Integer> moreImage) {
        this.context = context;
        this.moreData = moreData;
        this.moreImage = moreImage;
    }

    @Override
    public MoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_more, parent, false);
        return new MoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoreViewHolder holder, final int position) {
        holder.moreText.setText(moreData.get(position));
        holder.moreImage.setImageResource(moreImage.get(position));
        holder.moreLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DompetKitaActivity.class);
                Bundle b = new Bundle();
                b.putInt("gambar", moreImage.get(position));
                view.getContext().startActivity(i);
            }
        });
    }

    public static class MoreViewHolder extends RecyclerView.ViewHolder {

        private ImageView moreImage;
        private TextView moreText;
        private LinearLayout moreLL;

        public MoreViewHolder(View itemView) {
            super(itemView);
            moreImage = (ImageView) itemView.findViewById(R.id.iv_klinik);
            moreText = (TextView) itemView.findViewById(R.id.tv_klinik);
            moreLL = (LinearLayout) itemView.findViewById(R.id.ll_mater_more);
        }

    }

    @Override
    public int getItemCount() {
        return moreData.size();
    }
}
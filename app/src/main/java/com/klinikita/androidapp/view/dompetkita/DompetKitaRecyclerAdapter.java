package com.klinikita.androidapp.view.dompetkita;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DELLL on 9/20/2017.
 */


public class DompetKitaRecyclerAdapter extends RecyclerView.Adapter<DompetKitaRecyclerAdapter.DompetKitaViewHolder> {

    @Override
    public DompetKitaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(DompetKitaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DompetKitaViewHolder extends RecyclerView.ViewHolder {
        public DompetKitaViewHolder(View itemView) {
            super(itemView);
        }
    }
}

package com.klinikita.androidapp.view.chat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.klinikita.androidapp.R;

import java.util.ArrayList;

import me.himanshusoni.chatmessageview.ChatMessageView;

/**
 * Created by DELLL on 10/4/2017.
 */

public class ObrolanAdapter extends RecyclerView.Adapter<ObrolanAdapter.ObrolanViewHolder> {
    private Context context;
    private ArrayList<Obrolan>listObrolan;

    public ObrolanAdapter (Context context, ArrayList<Obrolan>listObrolan){
        this.context = context;
        this.listObrolan = listObrolan;

    }
    @Override
    public ObrolanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_obrolan,parent,false);
        return new ObrolanViewHolder(view);
    }
    public class ObrolanViewHolder extends RecyclerView.ViewHolder {
        private TextView tvObrolan, tvObrolan2;
        ChatMessageView ll,ll2;
        public ObrolanViewHolder(View itemView) {
            super(itemView);
            ll = (ChatMessageView)itemView.findViewById(R.id.messaage_chat);
            ll2 = (ChatMessageView)itemView.findViewById(R.id.messaage_chat2);
            tvObrolan = (TextView)itemView.findViewById(R.id.tv_text_obrolan);
            tvObrolan2 = (TextView)itemView.findViewById(R.id.tv_text_obrolan2);
        }
    }

    @Override
    public void onBindViewHolder(ObrolanViewHolder holder, int position) {
        holder.tvObrolan.setText(listObrolan.get(position).getTxtObrolan());
        holder.tvObrolan2.setText(listObrolan.get(position).getTxtObrolan());
//        if (position%2==0){
//            holder.ll.setHorizontalGravity(1);
//        }


    }

    @Override
    public int getItemCount() {
        return listObrolan.size();
    }


}

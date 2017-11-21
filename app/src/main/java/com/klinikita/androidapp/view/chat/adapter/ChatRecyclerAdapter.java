package com.klinikita.androidapp.view.chat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.klinikita.androidapp.R;

import java.util.ArrayList;

/**
 * Created by DELLL on 9/27/2017.
 */

public class ChatRecyclerAdapter extends RecyclerView.Adapter<ChatRecyclerAdapter.ChatViewHolder> {
    private Context context;
    private ArrayList<Chat> listChat;


    public ChatRecyclerAdapter(Context context, ArrayList<Chat> listChat) {
        this.context = context;
        this.listChat = listChat;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ChatViewHolder(view);
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        private ImageView chatImage;
        private TextView  username, history, jam, lingkaran;



        public ChatViewHolder(View itemView) {
            super(itemView);
            chatImage = (ImageView) itemView.findViewById(R.id.iv_klinikk);
            username = (TextView) itemView.findViewById(R.id.tv_username);
            history = (TextView) itemView.findViewById(R.id.tv_history);
            jam = (TextView) itemView.findViewById(R.id.tv_jam);
            lingkaran = (TextView) itemView.findViewById(R.id.tv_lingkaran);



        }
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        holder.chatImage.setImageResource(listChat.get(position).getGambarUser());
        holder.username.setText(listChat.get(position).getNamaUser());
        holder.history.setText(listChat.get(position).getHistorychat());
        holder.jam.setText(listChat.get(position).getTime());
        holder.lingkaran.setText(listChat.get(position).getLingkaran());

    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }


}

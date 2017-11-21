package com.klinikita.androidapp.view.feed.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.more.adapter.MoreRecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by DELLL on 9/13/2017.
 */

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.FeedViewHolder>{
    private Context context;
    private ArrayList<String> FeedText;
    private ArrayList<Integer> FeedImage;

    public FeedRecyclerAdapter (Context context, ArrayList<String>feedText, ArrayList<Integer>feedImage){
        this.context = context;
        this.FeedText = feedText;
        this.FeedImage = feedImage;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed,parent,false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.feedImage.setImageResource(FeedImage.get(position));
        holder.feedText.setText(FeedText.get(position));

    }

    @Override
    public int getItemCount() {
        return FeedImage.size();
    }


    public static class FeedViewHolder extends RecyclerView.ViewHolder {
        private ImageView feedImage;
        private TextView feedText;

        public FeedViewHolder(View itemView) {
            super(itemView);
            feedImage = (ImageView)itemView.findViewById(R.id.iv_feed);
            feedText = (TextView)itemView.findViewById(R.id.tv_username);
        }
    }
}


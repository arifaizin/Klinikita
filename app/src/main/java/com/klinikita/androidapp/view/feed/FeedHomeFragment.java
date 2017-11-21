package com.klinikita.androidapp.view.feed;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.feed.adapter.FeedRecyclerAdapter;
import com.klinikita.androidapp.view.home.HomeActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedHomeFragment extends Fragment {



    public FeedHomeFragment() {
        // Required empty public constructor
    }
    public static FeedHomeFragment newInstance(){
        FeedHomeFragment fragment = new FeedHomeFragment();
        return  fragment;
    }
    RecyclerView rv_feed;
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed_home, container, false);

        ArrayList<String> dataText;
        dataText = new ArrayList<>();
        dataText.add("Ian Ganteng");
        dataText.add("Hamim Ganteng");
        dataText.add("Edwin Ganteng");
        dataText.add("Roni Setiawan");
        dataText.add("Anak Alay");
        dataText.add("Paijo");

        ArrayList<Integer> dataImage;
        dataImage = new ArrayList<>();
        dataImage.add(R.drawable.akun);
        dataImage.add(R.drawable.ic_more_help);
        dataImage.add(R.drawable.ic_more_syaratketentuan);
        dataImage.add(R.drawable.ic_more_profil);
        dataImage.add(R.drawable.ic_more_pengaturan);
        dataImage.add(R.drawable.ic_more_logout);

        ArrayList<String> dataTextt;
        dataText = new ArrayList<>();
        dataText.add("Ian Ganteng");
        dataText.add("Hamim Ganteng");
        dataText.add("Edwin Ganteng");
        dataText.add("Roni Setiawan");
        dataText.add("Anak Alay");
        dataText.add("Paijo");



        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Feed");

        rv_feed = (RecyclerView) view.findViewById(R.id.rv_feed);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),StatusBaru.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_feed.setLayoutManager(linearLayoutManager);

        FeedRecyclerAdapter feedRecyclerAdapter = new FeedRecyclerAdapter(getActivity(),dataText,dataImage);

        rv_feed.setAdapter(feedRecyclerAdapter);




        return view;
    }
    public void postingan (View view){

    }

}

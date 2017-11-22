package com.klinikita.androidapp.view.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.beliobat.BeliObatActivity;
import com.klinikita.androidapp.view.chat.ChatKlinikita;
import com.klinikita.androidapp.view.chat.DokterKlinikita;
import com.klinikita.androidapp.view.chat.adapter.DokterAdapter;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;


public class MainHomeFragment extends Fragment {

    public static MainHomeFragment newInstance() {
        MainHomeFragment fragment = new MainHomeFragment();
        return fragment;
    }

    public MainHomeFragment() {
        // Required empty public constructor
    }

    MaterialRippleLayout cvPeriksa, rekammedis, beliObat, konsultasi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_home, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Klinikita Indonesia");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setElevation(0);

        cvPeriksa = (MaterialRippleLayout) view.findViewById(R.id.ripple_periksa);
        rekammedis = (MaterialRippleLayout) view.findViewById(R.id.ripple_rekam);
        beliObat = (MaterialRippleLayout) view.findViewById(R.id.ripple_beli);
        konsultasi = (MaterialRippleLayout) view.findViewById(R.id.ripple_konsul);


        cvPeriksa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "ke hatimu", Toast.LENGTH_SHORT).show();

            }
        });
        rekammedis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Ke Rekam Medis", Toast.LENGTH_SHORT).show();
            }
        });
        beliObat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(getContext(),BeliObatActivity.class);
                getContext().startActivity(i);
            }
        });
        konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),DokterKlinikita .class);
                getContext().startActivity(i);
            }
        });

        BannerSlider bannerSlider = (BannerSlider) view.findViewById(R.id.banner_slider1);

        List<Banner> banners = new ArrayList<>();
        //add banner using image url
//        banners.add(new RemoteBanner("Put banner image url here ..."));
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.pmdngn));
        banners.add(new DrawableBanner(R.drawable.pmandangan));
        banners.add(new DrawableBanner(R.drawable.pmdngn));
        bannerSlider.setBanners(banners);

        return view;
    }
}

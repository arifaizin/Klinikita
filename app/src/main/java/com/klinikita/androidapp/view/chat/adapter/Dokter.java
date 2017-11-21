package com.klinikita.androidapp.view.chat.adapter;

/**
 * Created by DELLL on 9/29/2017.
 */

public class Dokter  {
    private int gambardokter;
    private String namaDokter;
    private String bidangDokter;
    private String harga;

    public Dokter (int gambarokter, String namaDokter, String bidangDokter, String harga){
        this.gambardokter = gambarokter;
        this.namaDokter = namaDokter;
        this.bidangDokter = bidangDokter;
        this.harga = harga;

    }

    public int getGambarokter() {
        return gambardokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public String getBidangDokter() {
        return bidangDokter;
    }

    public String getHarga() {
        return harga;
    }
}

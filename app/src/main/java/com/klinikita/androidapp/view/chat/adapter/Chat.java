package com.klinikita.androidapp.view.chat.adapter;

/**
 * Created by DELLL on 9/27/2017.
 */

public class Chat {
    private String namaUser;
    private String historychat;
    private String time;
    private int gambarUser;
    private String lingkaran;

    public Chat(String namaUser, String historychat, String time, int gambarUser, String lingkaran) {
        this.namaUser = namaUser;
        this.historychat = historychat;
        this.time = time;
        this.gambarUser = gambarUser;
        this.lingkaran = lingkaran;

}
    public String getHistorychat() {
        return historychat;
    }

    public String getTime() {
        return time;
    }

    public String getLingkaran() {
        return lingkaran;
    }

    public String getNamaUser(){
        return namaUser;
    }
    public int getGambarUser(){
        return gambarUser;
    }
}

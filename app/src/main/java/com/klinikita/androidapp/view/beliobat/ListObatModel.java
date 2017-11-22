package com.klinikita.androidapp.view.beliobat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELLL on 11/22/2017.
 */

public class ListObatModel {
    @SerializedName("obat")
    @Expose
    private ArrayList<ObatModel> obat = new ArrayList<>();

    public ArrayList<ObatModel> getObat() {
        return obat;
    }

    public void setObat(ArrayList<ObatModel> obat) {
        this.obat = obat;
    }
}

package com.klinikita.androidapp.rest;

import com.klinikita.androidapp.helper.Config;
import com.klinikita.androidapp.view.beliobat.ListObatModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by idn on 8/12/2017.
 */

public interface ApiService {
    @GET(Config.URL_AMBIL_DATA)
    Call<ListObatModel> ambilData();



//
//    //    @FormUrlEncoded
//    @POST(Config.URL_UPDATE)
//    Call<Void> updatedataReg(@Query("id") String id,
//                             @Query("id_barcode") String id_barcode,
//                             @Query("registrasi") String registrasi);
//
//    @POST(Config.URL_UPDATE)
//    Call<Void> updatedataCert(@Query("id") String id,
//                              @Query("id_barcode") String id_barcode,
//                              @Query("sertifikat") String sertifikat);
////
//
//    @POST(Config.URL_UPDATE)
//    Call<Void> updatedataKit(@Query("id") String id,
//                             @Query("id_barcode") String id_barcode,
//                             @Query("seminarkit") String seminarkit);

//    @FormUrlEncoded
//    @POST("macros/s/AKfycbxnOQ61yI-vq5FyJi0ZP9XbQM6wFIRGrd2Lbzhy4WAj3-gdz8s/exec")
//    Call<ResponseBody> updatedatacert(@Field("id") String id,
//                                      @Field("id_barcode") String id_barcode,
//                                      @Field("registrasi") String registrasi,
//                                      @Field("sertifikat") String sertifikat,
//                                      @Field("seminarkit") String seminarkit);
//
//
//    @FormUrlEncoded
//    @POST("macros/s/AKfycbxnOQ61yI-vq5FyJi0ZP9XbQM6wFIRGrd2Lbzhy4WAj3-gdz8s/exec")
//    Call<ResponseBody> updatedatakit(@Field("id") String id,
//                                     @Field("id_barcode") String id_barcode,
//                                     @Field("registrasi") String registrasi,
//                                     @Field("sertifikat") String sertifikat,
//                                     @Field("seminarkit") String seminarkit);


}

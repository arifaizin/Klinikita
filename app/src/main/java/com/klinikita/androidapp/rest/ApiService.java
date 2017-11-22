package com.klinikita.androidapp.rest;

import com.klinikita.androidapp.helper.Config;
import com.klinikita.androidapp.view.beliobat.ListObatModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by idn on 8/12/2017.
 */

public interface ApiService {
    @GET(Config.URL_AMBIL_DATA)
    Call<ListObatModel> ambilData();

    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
            "Authorization: Bearer e99b343a687ede0cf5be50cc42b02cdf"
    })
    @FormUrlEncoded
    @POST("smsnotification/1.0.0/messages")
    Call<ResponseBody> kirimNotif(@Field("msisdn") String msisdn,
                                  @Field("content") String content);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
            "Authorization: Bearer e99b343a687ede0cf5be50cc42b02cdf"
    })
    @FormUrlEncoded
    @PUT("smsotp/1.0.1/otp/keplok2")
    Call<ResponseBody> kirimOTP (@Field("phoneNum") String phoneNum,
                                 @Field("digit") String digit);



    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
            "Authorization: Bearer e99b343a687ede0cf5be50cc42b02cdf"
    })
    @FormUrlEncoded
    @POST("smsotp/1.0.1/otp/keplok2/verifications")
    Call<ResponseBody> verivikasiOTP (@Field("otpstr") String otpstr,
                                 @Field("digit") String digit);
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

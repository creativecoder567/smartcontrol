package com.smart.myapplication.rest;


import com.smart.myapplication.model.machinedetail.Data;
import com.smart.myapplication.model.logindetail.Example;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    @POST("api/login")
    Call<Example> requestUserDetails(@Body RequestBody body);

    @Headers({"Content-Type: application/json","Accept:application/json"})
    @GET("api/assets")
    Call<com.smart.myapplication.model.machinedetail.Example> requestMachineDetails(@Header("Authorization") String authKey, @Query("page") String page, @Query("limit") String limit, @Query("company_id") String company_id);
  /*  @GET("wellwisher/getPatientsByWellwishernumber/{loginMobile}")
    Call<AllPatientsResponse> getPatientsByWellwishernumber(@Path("loginMobile") String loginMobile);
*/
}

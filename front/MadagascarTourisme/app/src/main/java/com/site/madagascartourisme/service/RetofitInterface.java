package com.site.madagascartourisme.service;

import com.google.gson.JsonObject;
import com.site.madagascartourisme.model.RegionModel;
import com.site.madagascartourisme.view.Login;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetofitInterface {


    @POST("/utilisateur/login")
    Call<JsonObject> executeLogin(@Body HashMap<String, String> map);

    @POST("/utilisateur/inscription")
    Call<Void> executeSignUp(@Body HashMap<String, String> map);

    @GET("/region/getRegion")
    Call<List<RegionModel>> getRegions();

    @GET("/evenement/getEvenement")
    Call<List<JsonObject>> getEvenement();

    @GET("/evenement/getEvenementById")
    Call<List<JsonObject>> getEvenementById(@Query("idEvenement") String idEvenement);


}

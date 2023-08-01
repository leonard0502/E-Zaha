package com.site.tourismemadagascar.sevice;


import com.site.tourismemadagascar.Login;
import com.site.tourismemadagascar.model.RegionModel;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetofitInterface {

    @POST("/utilisateur/login")
    Call<Login> executeLogin(@Body HashMap<String, String> map);

    @POST("/utilisateur/inscription")
    Call<Void> executeSignUp(@Body HashMap<String, String> map);

    @POST("/region/liste")
    Call<List<RegionModel>> getRegions();

}

package com.site.tourismemadagascar.model;

import androidx.room.Entity;

import com.site.tourismemadagascar.controller.BaseController;
import com.site.tourismemadagascar.sevice.RegionService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
@Entity(tableName = "region")
public class RegionModel {
    private String id;
    private String nom;

    public void getRegions(RegionService callback) {
        BaseController baseController = new BaseController();
        Call<List<RegionModel>> call = baseController.getRetofitInterface().getRegions();
        call.enqueue(new Callback<List<RegionModel>>() {
            @Override
            public void onResponse(Call<List<RegionModel>> call, Response<List<RegionModel>> response) {
                List<RegionModel> regions = response.body();
                if (regions != null) {
                    callback.onSuccess(regions);
                } else {
                    callback.onFailure(new Exception("Failed to get regions"));
                }
            }
            @Override
            public void onFailure(Call<List<RegionModel>> call, Throwable t) {
                callback.onFailure(t);
            }
        });

    }


}

package com.site.madagascartourisme.service;

import com.site.madagascartourisme.model.RegionModel;

import java.util.List;

public interface RegionService {

    void onSuccess(List<RegionModel> regions);
    void onFailure(Throwable t);
}

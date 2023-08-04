package com.site.tourismemadagascar.sevice;

import com.site.tourismemadagascar.model.RegionModel;

import java.util.List;

public interface RegionService {

    void onSuccess(List<RegionModel> regions);
    void onFailure(Throwable t);

}

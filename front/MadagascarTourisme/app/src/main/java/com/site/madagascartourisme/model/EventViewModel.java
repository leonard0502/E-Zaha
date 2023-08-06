package com.site.madagascartourisme.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class EventViewModel extends ViewModel {
    private MutableLiveData<List<EvenementModel>> eventListLiveData = new MutableLiveData<>();

    public LiveData<List<EvenementModel>> getEventListLiveData() {
        return eventListLiveData;
    }

    public void setEventList(List<EvenementModel> eventList) {
        eventListLiveData.setValue(eventList);
    }
}

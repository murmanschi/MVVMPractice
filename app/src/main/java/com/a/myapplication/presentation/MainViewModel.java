package com.a.myapplication.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.a.myapplication.App;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<String>> listMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLodaing = new MutableLiveData<>();

    LiveData<List<String>> networkData() {
        return listMutableLiveData;
    }

    LiveData<Boolean> isLodaing() {
        return isLodaing;
    }

    @Inject
    protected MainRepository mainRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        ((App) application).androidInjector().inject(this);
    }

    void requestData() {
        isLodaing.postValue(true);
        listMutableLiveData.postValue(mainRepository.getNetworkData());
        isLodaing.postValue(false);
    }


}

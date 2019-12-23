package com.a.myapplication.presentation;

import com.a.myapplication.domain.NetworkMock;

import java.util.List;

import javax.inject.Inject;

public class MainRepository {

    private NetworkMock networkMock;

    @Inject MainRepository(NetworkMock networkMock){
        this.networkMock = networkMock;
    }


   public List<String> getNetworkData(){
        return networkMock.getStringList();
    }


}

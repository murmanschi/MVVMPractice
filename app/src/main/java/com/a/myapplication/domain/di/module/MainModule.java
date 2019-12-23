package com.a.myapplication.domain.di.module;

import com.a.myapplication.domain.NetworkMock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Singleton
    @Provides
    NetworkMock provideNetworkMock(){
        return new NetworkMock();
    }

}

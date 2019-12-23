package com.a.myapplication.domain.di.module;

import com.a.myapplication.presentation.MainActivity;
import com.a.myapplication.presentation.MainViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ViewMOdelBuilderMOdule {

    @ContributesAndroidInjector
    abstract MainViewModel contributeMainViewModel();

}

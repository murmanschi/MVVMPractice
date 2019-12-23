package com.a.myapplication.domain.di.module;

import com.a.myapplication.presentation.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderMOdule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

}

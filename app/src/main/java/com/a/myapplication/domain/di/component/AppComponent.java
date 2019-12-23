package com.a.myapplication.domain.di.component;

import android.app.Application;

import com.a.myapplication.App;
import com.a.myapplication.domain.di.module.ActivityBuilderMOdule;
import com.a.myapplication.domain.di.module.MainModule;
import com.a.myapplication.domain.di.module.ViewMOdelBuilderMOdule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        MainModule.class,
        ActivityBuilderMOdule.class,
        ViewMOdelBuilderMOdule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application app);

        AppComponent build();

    }

}

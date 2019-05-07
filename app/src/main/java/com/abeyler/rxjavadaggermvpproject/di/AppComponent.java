package com.abeyler.rxjavadaggermvpproject.di;

import android.app.Application;

import com.abeyler.rxjavadaggermvpproject.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<MyApplication>
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

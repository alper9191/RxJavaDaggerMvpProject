package com.abeyler.rxjavadaggermvpproject;

import com.abeyler.rxjavadaggermvpproject.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MyApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector()
    {
        return DaggerAppComponent.builder().application(this).build();
    }
}

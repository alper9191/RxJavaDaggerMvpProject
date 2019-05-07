package com.abeyler.rxjavadaggermvpproject.di;

import com.abeyler.rxjavadaggermvpproject.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule
{
    @PerActivity
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    public abstract MainActivity provideMainActivity();
}

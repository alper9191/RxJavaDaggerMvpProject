package com.abeyler.rxjavadaggermvpproject.di;

import com.abeyler.rxjavadaggermvpproject.Const;
import com.abeyler.rxjavadaggermvpproject.services.IMovieService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule
{
    @Provides
    @Singleton
    public IMovieService provideRetrofitInstance()
    {
        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(IMovieService.class);
    }
}

package com.abeyler.rxjavadaggermvpproject.di;

import com.abeyler.rxjavadaggermvpproject.MainActivity;
import com.abeyler.rxjavadaggermvpproject.presenter.MoviePresenter;
import com.abeyler.rxjavadaggermvpproject.services.IMovieService;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule
{
    @Provides
    @PerActivity
    public MoviePresenter provideMoviePresenter(IMovieService movieService, MainActivity mainActivity)
    {
        return new MoviePresenter(movieService, mainActivity);
    }
}

package com.abeyler.rxjavadaggermvpproject.presenter;

import com.abeyler.rxjavadaggermvpproject.Const;
import com.abeyler.rxjavadaggermvpproject.contract.IMovieContract;
import com.abeyler.rxjavadaggermvpproject.model.Movie;
import com.abeyler.rxjavadaggermvpproject.services.IMovieService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviePresenter implements IMovieContract.Presenter {

    IMovieContract.View mView;
    IMovieService service;

    public MoviePresenter(IMovieService service, IMovieContract.View view)
    {
        this.mView = view;
        this.service = service;
    }

    @Override
    public void start() {

        mView.init();
    }

    @Override
    public void fetchMovies() {

        // singleton in dagger 2
        /*IMovieService iMovieService = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(IMovieService.class);*/


        service.getMovieList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Movie>>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                                   mView.showProgress();
                               }

                               @Override
                               public void onNext(List<Movie> movieList) {

                                   mView.hideProgress();
                                   mView.loadList(movieList);
                               }

                               @Override
                               public void onError(Throwable e) {
                                   mView.showError(e.toString());
                               }

                               @Override
                               public void onComplete() {

                               }
                           }
                );
    }
}

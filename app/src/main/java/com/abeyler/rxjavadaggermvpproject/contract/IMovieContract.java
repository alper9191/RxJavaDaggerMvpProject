package com.abeyler.rxjavadaggermvpproject.contract;

import com.abeyler.rxjavadaggermvpproject.model.Movie;

import java.util.List;

public interface IMovieContract {

    interface View {

        void init();
        void showProgress();
        void hideProgress();
        void showError(String errorMsg);
        void loadList(List<Movie> movieList);

    }


    interface Presenter {
        void start();
        void fetchMovies();
    }
}

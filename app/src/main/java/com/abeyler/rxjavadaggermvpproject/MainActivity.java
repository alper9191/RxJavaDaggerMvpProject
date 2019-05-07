package com.abeyler.rxjavadaggermvpproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.abeyler.rxjavadaggermvpproject.adapters.MoviesAdapter;
import com.abeyler.rxjavadaggermvpproject.contract.IMovieContract;
import com.abeyler.rxjavadaggermvpproject.model.Movie;
import com.abeyler.rxjavadaggermvpproject.presenter.MoviePresenter;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements IMovieContract.View {

    @Inject MoviePresenter moviePresenter;

    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ayrıca new ile presenter yaratmak yerine dagger kullanmak mantıklı. bağımlılıkları azaltmak için
        //moviePresenter = new MoviePresenter(this);
        moviePresenter.start();
    }


    @Override
    public void init() {
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        moviePresenter.fetchMovies();
    }

    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {

        if(progressBar!=null && progressBar.isShown()){
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void loadList(List<Movie> movieList) {

        moviesAdapter = new MoviesAdapter(movieList,getApplicationContext());
        recyclerView.setAdapter(moviesAdapter);
    }
}

package com.abeyler.rxjavadaggermvpproject.services;

import com.abeyler.rxjavadaggermvpproject.model.Movie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMovieService {
    @GET("json/movies.json")
    Observable<List<Movie>> getMovieList();
}

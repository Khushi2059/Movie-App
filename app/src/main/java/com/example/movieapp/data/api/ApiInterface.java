package com.example.movieapp.data.api;

import static com.example.movieapp.data.api.ApiKey.apiKey;

import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movie/popular?api_key=" + apiKey)
    Observable<PopularMoviesData> getPopularMovies();

    @GET("movie/top_rated?api_key=" + apiKey)
    Observable<TopRatedMoviesData> getTopRatedMovies();

    @GET("tv/popular?api_key=" + apiKey)
    Observable<PopularTvShowsData> getPopularTvShows();

    @GET("tv/top_rated?api_key=" + apiKey)
    Observable<TopRatedTvShowsData> getTopRatedTvShows();

    @GET("movie/upcoming?api_key=" + apiKey)
    Observable<UpComingMoviesData> getUpComingMovies();
}

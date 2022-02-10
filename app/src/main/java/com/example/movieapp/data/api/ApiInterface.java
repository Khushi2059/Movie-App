package com.example.movieapp.data.api;

import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movie/popular?")
    Call<PopularMoviesData> getPopularMovies();

    @GET("movie/top_rated?")
    Call<TopRatedMoviesData> getTopRatedMovies();

    @GET("tv/popular?")
    Call<PopularTvShowsData> getPopularTvShows();

    @GET("tv/top_rated?")
    Call<TopRatedTvShowsData> getTopRatedTvShows();

    @GET("movie/upcoming?")
    Call<UpComingMoviesData> getUpComingMovies();
}

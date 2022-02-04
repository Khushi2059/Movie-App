package com.example.movieapp.data.api;

import static com.example.movieapp.data.api.ApiKey.apiKey;

import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movie/popular?api_key=" + apiKey)
    Call<PopularMoviesData> getPopularMovies();

    @GET("movie/top_rated?api_key=" + apiKey)
    Call<TopRatedMoviesData> getTopRatedMovies();

    @GET("tv/popular?api_key=" + apiKey)
    Call<PopularTvShowsData> getPopularTvShows();

    @GET("tv/top_rated?api_key=" + apiKey)
    Call<TopRatedTvShowsData> getTopRatedTvShows();

    @GET("movie/upcoming?api_key=" + apiKey)
    Call<UpComingMoviesData> getUpComingMovies();
}

package com.example.movieapp.data.api;

import static com.example.movieapp.data.api.ApiKey.apiKey;

import com.example.movieapp.data.model.HomeData;
import com.example.movieapp.data.model.KidsData;
import com.example.movieapp.data.model.MovieResp;
import com.example.movieapp.data.model.TvResp;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movie/popular?api_key=" + apiKey)
    Observable<MovieResp> getMovieResp();

    @GET("movie/top_rated?api_key=" + apiKey)
    Observable<HomeData> getHomeResp();

    @GET("tv/popular?api_key=" + apiKey)
    Observable<TvResp> getTvResp();

    @GET("tv/top_rated?api_key=" + apiKey)
    Observable<KidsData> getWatchNext();
}

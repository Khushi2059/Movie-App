package com.example.movieapp.retrofit;

import static com.example.movieapp.retrofit.ApiKey.apiKey;

import com.example.movieapp.model.HomeResp;
import com.example.movieapp.model.KidsResp;
import com.example.movieapp.model.MovieResp;
import com.example.movieapp.model.TvResp;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
   @GET("movie/popular?api_key=" + apiKey)
   Observable<MovieResp> getMovieResp();

   @GET("movie/top_rated?api_key=" + apiKey)
   Observable<HomeResp> getHomeResp();

   @GET("tv/popular?api_key=" + apiKey)
   Observable<TvResp> getTvResp();

   @GET("tv/top_rated?api_key=" + apiKey)
   Observable<KidsResp> getWatchNext();

}

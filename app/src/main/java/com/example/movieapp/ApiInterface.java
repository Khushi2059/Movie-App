package com.example.movieapp;

import static com.example.movieapp.retrofit.ApiKey.apiKey;

import com.example.movieapp.model.HomeResp;
import com.example.movieapp.model.KidsResp;
import com.example.movieapp.model.MovieResp;
import com.example.movieapp.model.TvResp;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
<<<<<<< HEAD
    @GET("movie/popular?api_key=" + apiKey)
    Observable<MovieResp> getMovieResp();

    @GET("movie/top_rated?api_key=" + apiKey)
    Observable<HomeResp> getHomeResp();

    @GET("tv/popular?api_key=" + apiKey)
    Observable<TvResp> getTvResp();

    @GET("tv/top_rated?api_key=" + apiKey)
    Observable<KidsResp> getWatchNext();

}
=======
  //  @GET("https://api.themoviedb.org/3/movie/top_rated?api_key=232be951f20b306084f1a1bcc66a1081");
//    Observable<List<BannerMovies>> getAllBanners();
}
>>>>>>> Initial commit

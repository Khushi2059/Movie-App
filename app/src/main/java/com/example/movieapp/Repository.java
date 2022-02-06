package com.example.movieapp;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.movieapp.model.BannerMovies;
import com.example.movieapp.model.HomeResp;
import com.example.movieapp.model.KidsResp;
import com.example.movieapp.model.MainRecyclerRepo;
import com.example.movieapp.model.MovieResp;
import com.example.movieapp.model.TvResp;
import com.example.movieapp.retrofit.ApiInterface;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class Repository {
    private static final String TAG = "Repository";
    ApiInterface apiService;
    //MovieDao movieDao;
    DAO dao;
    @Inject
    public Repository(ApiInterface apiService, DAO dao, Context context) {
        this.apiService = apiService;
        this.dao = dao;
    }
    public Observable<MovieResp> getMovieResp(){
        return apiService.getMovieResp();
    }
    public Observable<HomeResp> getHomeResp(){
        return apiService.getHomeResp();
    }
    public Observable<KidsResp> getWatchNext(){
        return apiService.getWatchNext();
    }
    public Observable<TvResp> getTvResp(){
        return apiService.getTvResp();

    }
    public Observable<MainRecyclerRepo> geImgData(){
        return apiService.geImgData();

    }
    public void insertMovie(BannerMovies bannerMovies){
        Log.e(TAG, "insertMovie: " );
        dao.insert(bannerMovies);
    }
    public LiveData<List<BannerMovies>> getAllMovies(){
        return  dao.getAllMovies();
    }
    public void deleteMovie(){
        dao.deleteMovie();
    }

}

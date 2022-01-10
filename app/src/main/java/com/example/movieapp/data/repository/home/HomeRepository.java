package com.example.movieapp.data.repository.home;

import androidx.lifecycle.LiveData;

import com.example.movieapp.data.model.BannerMoviesData;

public interface HomeRepository {

    LiveData<BannerMoviesData> getHomeCategoryData();

    LiveData<BannerMoviesData> getTvShowsCategoryData();

    LiveData<BannerMoviesData> getMoviesCategoryData();

    LiveData<BannerMoviesData> getKidsCategoryData();
}
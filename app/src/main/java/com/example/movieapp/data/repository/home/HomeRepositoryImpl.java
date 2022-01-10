package com.example.movieapp.data.repository.home;

import androidx.lifecycle.LiveData;

import com.example.movieapp.data.model.BannerMoviesData;

public class HomeRepositoryImpl implements HomeRepository {

    @Override
    public LiveData<BannerMoviesData> getHomeCategoryData() {
        return null;
    }

    @Override
    public LiveData<BannerMoviesData> getTvShowsCategoryData() {
        return null;
    }

    @Override
    public LiveData<BannerMoviesData> getMoviesCategoryData() {
        return null;
    }

    @Override
    public LiveData<BannerMoviesData> getKidsCategoryData() {
        return null;
    }
}

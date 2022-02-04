package com.example.movieapp.data.repository.home;

import androidx.lifecycle.LiveData;

import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;
import com.example.movieapp.data.repository.base.BaseRepositoryImpl;

public class HomeRepositoryImpl extends BaseRepositoryImpl implements HomeRepository {

    @Override
    public LiveData<PopularMoviesData> getPopularMoviesData() {
        return null;
    }

    @Override
    public LiveData<TopRatedMoviesData> getTopRatedMoviesData() {
        return null;
    }

    @Override
    public LiveData<PopularTvShowsData> getPopularTvShowsData() {
        return null;
    }

    @Override
    public LiveData<TopRatedTvShowsData> getTopRatedTvShowsData() {
        return null;
    }

    @Override
    public LiveData<UpComingMoviesData> getUpComingMoviesData() {
        return null;
    }
}

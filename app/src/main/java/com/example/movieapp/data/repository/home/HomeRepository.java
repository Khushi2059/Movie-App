package com.example.movieapp.data.repository.home;

import androidx.lifecycle.LiveData;

import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;

public interface HomeRepository {

    LiveData<PopularMoviesData> getPopularMoviesData();

    LiveData<TopRatedMoviesData> getTopRatedMoviesData();

    LiveData<PopularTvShowsData> getPopularTvShowsData();

    LiveData<TopRatedTvShowsData> getTopRatedTvShowsData();

    LiveData<UpComingMoviesData> getUpComingMoviesData();
}
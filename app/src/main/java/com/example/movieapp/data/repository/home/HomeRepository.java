package com.example.movieapp.data.repository.home;

import androidx.lifecycle.LiveData;

import com.example.movieapp.data.api.Resource;
import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;

public interface HomeRepository {

    LiveData<Resource<PopularMoviesData>> getPopularMoviesData();

    LiveData<Resource<TopRatedMoviesData>> getTopRatedMoviesData();

    LiveData<Resource<PopularTvShowsData>> getPopularTvShowsData();

    LiveData<Resource<TopRatedTvShowsData>> getTopRatedTvShowsData();

    LiveData<Resource<UpComingMoviesData>> getUpComingMoviesData();
}
package com.example.movieapp.ui.main.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.movieapp.data.model.BannerMoviesData;
import com.example.movieapp.data.repository.home.HomeRepositoryImpl;
import com.example.movieapp.ui.base.BaseViewModel;

public class HomeViewModel extends BaseViewModel {

    private final HomeRepositoryImpl homeRepository;

    public HomeViewModel() {
        homeRepository = new HomeRepositoryImpl();
    }

    public LiveData<BannerMoviesData> getHomeData() {
        return homeRepository.getHomeCategoryData();
    }

    public LiveData<BannerMoviesData> getTvShowsData() {
        return homeRepository.getTvShowsCategoryData();
    }

    public LiveData<BannerMoviesData> getMoviesData() {
        return homeRepository.getMoviesCategoryData();
    }

    public LiveData<BannerMoviesData> getKidsData() {
        return homeRepository.getKidsCategoryData();
    }
}

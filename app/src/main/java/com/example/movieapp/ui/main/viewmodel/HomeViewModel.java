package com.example.movieapp.ui.main.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.data.model.MovieData;
import com.example.movieapp.data.repository.home.HomeRepositoryImpl;
import com.example.movieapp.ui.base.BaseViewModel;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class HomeViewModel extends BaseViewModel {

    private final HomeRepositoryImpl homeRepository;
    private CompositeDisposable compositeDisposable;

    public HomeViewModel() {
        homeRepository = new HomeRepositoryImpl();
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<List<MovieData>> getPopularMovies() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        homeRepository.getPopularMoviesData().observeForever(popularMoviesDataResource -> {
            if (popularMoviesDataResource != null && popularMoviesDataResource.data != null) {
                data.postValue(popularMoviesDataResource.data.getMoviesList());
            }
        });
        return data;
    }

    public LiveData<List<MovieData>> getTopRatedMovies() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        homeRepository.getTopRatedMoviesData().observeForever(topRatedMoviesDataResource -> {
            if (topRatedMoviesDataResource != null && topRatedMoviesDataResource.data != null) {
                data.postValue(topRatedMoviesDataResource.data.getMoviesList());
            }
        });
        return data;
    }

    public LiveData<List<MovieData>> getPopularTvShows() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        homeRepository.getPopularTvShowsData().observeForever(popularTvShowsDataResource -> {
            if (popularTvShowsDataResource != null && popularTvShowsDataResource.data != null) {
                data.postValue(popularTvShowsDataResource.data.getMoviesList());
            }
        });
        return data;
    }

    public MutableLiveData<List<MovieData>> getTopRatedTvShowsData() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        homeRepository.getTopRatedTvShowsData().observeForever(topRatedTvShowsDataResource -> {
            if (topRatedTvShowsDataResource != null && topRatedTvShowsDataResource.data != null) {
                data.postValue(topRatedTvShowsDataResource.data.getMoviesList());
            }
        });
        return data;
    }

    public LiveData<List<MovieData>> getUpComingMoviesData() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        homeRepository.getUpComingMoviesData().observeForever(upComingMoviesDataResource -> {
            if (upComingMoviesDataResource != null && upComingMoviesDataResource.data != null) {
                data.postValue(upComingMoviesDataResource.data.getMoviesList());
            }
        });
        return data;
    }
}

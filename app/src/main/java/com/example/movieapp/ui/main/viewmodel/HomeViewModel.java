package com.example.movieapp.ui.main.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.data.api.RetrofitClient;
import com.example.movieapp.data.model.MovieData;
import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;
import com.example.movieapp.data.repository.home.HomeRepositoryImpl;
import com.example.movieapp.ui.base.BaseViewModel;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel {

    private final HomeRepositoryImpl homeRepository;
    private CompositeDisposable compositeDisposable;

    public HomeViewModel() {
        homeRepository = new HomeRepositoryImpl();
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<List<MovieData>> getPopularMovies() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getPopularMovies()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<PopularMoviesData>() {
                    @Override
                    public void onNext(PopularMoviesData moviesResp) {
                        data.postValue(moviesResp.getMoviesList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d("bannerData", "");
                    }
                })

        );
        return data;
    }

    public LiveData<List<MovieData>> getTopRatedMovies() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getTopRatedMovies()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<TopRatedMoviesData>() {
                    @Override
                    public void onNext(TopRatedMoviesData homeResp) {
                        data.postValue(homeResp.getMoviesList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d("bannerData", "");
                    }
                })
        );
        return data;
    }

    public LiveData<List<MovieData>> getPopularTvShows() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getPopularTvShows()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<PopularTvShowsData>() {
                    @Override
                    public void onNext(PopularTvShowsData tvResp) {
                        data.postValue(tvResp.getMoviesList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d("bannerData", "");
                    }
                })

        );
        return data;
    }

    public MutableLiveData<List<MovieData>> getTopRatedTvShowsData() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getTopRatedTvShows()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<TopRatedTvShowsData>() {
                    @Override
                    public void onNext(TopRatedTvShowsData kidsResp) {
                        data.postValue(kidsResp.getMoviesList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d("bannerData", "");
                    }
                })

        );
        return data;
    }

    public LiveData<List<MovieData>> getUpComingMoviesData() {
        MutableLiveData<List<MovieData>> data = new MutableLiveData<>();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getUpComingMovies()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<UpComingMoviesData>() {

                    @Override
                    public void onNext(UpComingMoviesData mainRecyclerRepo) {
                        Log.d("bannerData", mainRecyclerRepo.getMoviesList().toString());
                        data.postValue(mainRecyclerRepo.getMoviesList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
        return data;
    }
}

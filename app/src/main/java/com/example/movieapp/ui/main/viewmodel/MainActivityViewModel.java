package com.example.movieapp.ui.main.viewmodel;

import android.util.Log;

import com.example.movieapp.data.api.RetrofitClient;
import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.MovieData;
import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;
import com.example.movieapp.ui.main.adapter.HomePageAdapter;
import com.example.movieapp.ui.main.adapter.KidsPageAdapter;
import com.example.movieapp.ui.main.adapter.MoviesPageAdapter;
import com.example.movieapp.ui.main.adapter.RecyclerViewAdapter;
import com.example.movieapp.ui.main.adapter.TvPageAdapter;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel {

    public void getBannerData(HomePageAdapter homePageAdapter) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getPopularMovies()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<PopularMoviesData>() {
                    @Override
                    public void onNext(PopularMoviesData moviesResp) {
                        List<MovieData> movieBannerList = moviesResp.getMoviesList();
                        homePageAdapter.setHomePageAdapter(movieBannerList);
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
    }

    public void getBannerData1(TvPageAdapter tvPageAdapter) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getTopRatedMovies()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<TopRatedMoviesData>() {
                    @Override
                    public void onNext(TopRatedMoviesData homeResp) {
                        List<MovieData> homeBannerList = homeResp.getMoviesList();
                        tvPageAdapter.setTvPageAdapter(homeBannerList);
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
    }

    public void getBannerData2(MoviesPageAdapter moviesPageAdapter) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getPopularTvShows()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<PopularTvShowsData>() {
                    @Override
                    public void onNext(PopularTvShowsData tvResp) {
                        List<MovieData> tvShowBannerList = tvResp.getMoviesList();
                        moviesPageAdapter.setBannerMoviesList3(tvShowBannerList);
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
    }

    public void getBannerData3(KidsPageAdapter kidsPageAdapter) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getTopRatedTvShows()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<TopRatedTvShowsData>() {
                    @Override
                    public void onNext(TopRatedTvShowsData kidsResp) {
                        List<MovieData> kidsBannerList = kidsResp.getMoviesList();
                        kidsPageAdapter.setKidsPageAdapter(kidsBannerList);
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
    }

    public void getBannerData4(RecyclerViewAdapter recyclerViewAdapter) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getUpComingMovies()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<UpComingMoviesData>() {

                    @Override
                    public void onNext(UpComingMoviesData mainRecyclerRepo) {
                        Log.d("bannerData", mainRecyclerRepo.getMoviesList().toString());
                        List<MovieData> recyclerRepoMoviesList = mainRecyclerRepo.getMoviesList();
                        recyclerViewAdapter.SetAdapter(recyclerRepoMoviesList);
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
    }
}
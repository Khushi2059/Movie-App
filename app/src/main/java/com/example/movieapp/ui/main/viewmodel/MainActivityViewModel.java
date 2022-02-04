package com.example.movieapp.ui.main.viewmodel;

import android.util.Log;

import com.example.movieapp.data.api.RetrofitClient;
import com.example.movieapp.data.model.BannerMoviesData;
import com.example.movieapp.data.model.HomeData;
import com.example.movieapp.data.model.KidsData;
import com.example.movieapp.data.model.MovieModelClass;
import com.example.movieapp.data.model.MovieResp;
import com.example.movieapp.data.model.TvResp;
import com.example.movieapp.model.MainRecyclerRepo;
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

    private static String BASE_URL = "https://api.themoviedb.org/3/tv/airing_today?api_key=232be951f20b306084f1a1bcc66a1081";

    public void getBannerData(HomePageAdapter homePageAdapter) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getMovieResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<MovieResp>() {
                    @Override
                    public void onNext(MovieResp moviesResp) {
                        List<BannerMoviesData> movieBannerList = moviesResp.getMoviesList();
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
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getHomeResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<HomeData>() {
                    @Override
                    public void onNext(HomeData homeResp) {
                        List<BannerMoviesData> homeBannerList = homeResp.getMoviesList();
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
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getTvResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<TvResp>() {
                    @Override
                    public void onNext(TvResp tvResp) {
                        List<BannerMoviesData> tvShowBannerList = tvResp.getMoviesList();
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
        compositeDisposable.add(RetrofitClient.getRetrofitClient().getWatchNext()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<KidsData>() {
                    @Override
                    public void onNext(KidsData kidsResp) {
                        List<BannerMoviesData> kidsBannerList = kidsResp.getMoviesList();
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
        compositeDisposable.add(RetrofitClient.getRetrofitClient().geImgData()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<MainRecyclerRepo>() {

                    @Override
                    public void onNext(MainRecyclerRepo mainRecyclerRepo) {
                        Log.d("bannerData", mainRecyclerRepo.getMoviesList().toString());
                        List<MovieModelClass> recyclerRepoMoviesList = mainRecyclerRepo.getMoviesList();
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
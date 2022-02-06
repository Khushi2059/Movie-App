package com.example.movieapp.ui.main.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;

import com.example.movieapp.Repository;
import com.example.movieapp.model.MainRecyclerRepo;
import com.example.movieapp.model.MovieModelClass;
import com.example.movieapp.ui.main.adapter.RecyclerViewAdapter;
import com.example.movieapp.ui.main.adapter.KidsPageAdapter;
import com.example.movieapp.ui.main.adapter.HomePageAdapter;
import com.example.movieapp.ui.main.adapter.MoviesPageAdapter;
import com.example.movieapp.ui.main.adapter.TvPageAdapter;
import com.example.movieapp.model.BannerMovies;
import com.example.movieapp.model.HomeResp;
import com.example.movieapp.model.KidsResp;
import com.example.movieapp.model.MovieResp;
import com.example.movieapp.model.TvResp;
import com.example.movieapp.retrofit.RetrofitClient;

import java.util.List;
import java.util.TimerTask;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {
    private static final String TAG = "ViewModel";
    private Repository repository;
    private LiveData<List<BannerMovies>> MoviesList;


    public MainActivityViewModel(Repository repository, LiveData<List<BannerMovies>> wishListMoviesList) {
        this.repository = repository;
       MoviesList = repository.getAllMovies();
    }

    public void getBannerData(HomePageAdapter homePageAdapter){
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        compositeDisposable.add(repository.getMovieResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<MovieResp>() {
                    @Override
                    public void onNext(MovieResp moviesResp) {
                        //   Log.d("bannerData", moviesResp.getMoviesList().toString());
                        List<BannerMovies> movieBannerList = moviesResp.getMoviesList();
                        homePageAdapter.setHomePageAdapter(movieBannerList);
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
    public void getBannerData1(TvPageAdapter tvPageAdapter){
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        compositeDisposable.add(repository.getHomeResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<HomeResp>() {
                    @Override
                    public void onNext(HomeResp homeResp) {
                        //  Log.d("bannerData", homeResp.getMoviesList().toString());
                        List<BannerMovies> homeBannerList= homeResp.getMoviesList();
                        tvPageAdapter.setTvPageAdapter(homeBannerList);
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
    public void getBannerData2(MoviesPageAdapter moviesPageAdapter){
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        compositeDisposable.add(repository.getTvResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<TvResp>() {
                    @Override
                    public void onNext(TvResp tvResp) {
                       // Log.d("bannerData", tvResp.getMoviesList().toString());
                        List<BannerMovies> tvShowBannerList = tvResp.getMoviesList();
                        moviesPageAdapter.setBannerMoviesList3(tvShowBannerList);
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


    public void getBannerData3(KidsPageAdapter kidsPageAdapter){
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        compositeDisposable.add(repository.getWatchNext()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<KidsResp>() {
                    @Override
                    public void onNext(KidsResp kidsResp) {
                        //  Log.d("bannerData", tvResp.getMoviesList().toString());
                        List<BannerMovies> kidsBannerList = kidsResp.getMoviesList();
                        kidsPageAdapter.setKidsPageAdapter(kidsBannerList);
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


    public void getBannerData4(RecyclerViewAdapter recyclerViewAdapter) {

        CompositeDisposable compositeDisposable=new CompositeDisposable();
        compositeDisposable.add(repository.geImgData()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<MainRecyclerRepo>() {

                    @Override
                    public void onNext(MainRecyclerRepo mainRecyclerRepo) {
                         Log.d("bannerData", mainRecyclerRepo.getMoviesList().toString());
                        List<MovieModelClass> recyclerRepoMoviesList= mainRecyclerRepo.getMoviesList();
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

    public LiveData<List<BannerMovies>> getAllMovies() {
        return MoviesList;
    }

    public void deleteMovie(){
        repository.deleteMovie();
    }
    public void insertMovie(BannerMovies bannerMovies){
        Log.e(TAG, "insertMovie: " );
        repository.insertMovie(bannerMovies);

    }

}
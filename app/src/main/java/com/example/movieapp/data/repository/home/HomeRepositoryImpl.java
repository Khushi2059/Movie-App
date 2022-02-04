package com.example.movieapp.data.repository.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.data.api.ApiCallManager;
import com.example.movieapp.data.api.ApiInterface;
import com.example.movieapp.data.api.NetworkBoundResource;
import com.example.movieapp.data.api.Resource;
import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;
import com.example.movieapp.data.repository.base.BaseRepositoryImpl;

import io.reactivex.rxjava3.annotations.NonNull;
import retrofit2.Call;

public class HomeRepositoryImpl extends BaseRepositoryImpl implements HomeRepository {

    private PopularMoviesData popularMoviesData;
    private Call<PopularMoviesData> popularMovieCall;

    private TopRatedMoviesData topRatedMoviesData;
    private Call<TopRatedMoviesData> topRatedMoviesCall;

    private PopularTvShowsData popularTvShowsData;
    private Call<PopularTvShowsData> popularTvShowsCall;

    private TopRatedTvShowsData topRatedTvShowsData;
    private Call<TopRatedTvShowsData> topRatedTvShowsCall;

    private UpComingMoviesData upComingMoviesData;
    private Call<UpComingMoviesData> upComingMoviesDataCall;

    public HomeRepositoryImpl() {
        popularMoviesData = null;
        topRatedMoviesData = null;
        popularTvShowsData = null;
        topRatedTvShowsData = null;
        upComingMoviesData = null;
    }

    @Override
    public LiveData<Resource<PopularMoviesData>> getPopularMoviesData() {
        return new NetworkBoundResource<PopularMoviesData, PopularMoviesData>() {

            @Override
            public void saveApiCallResult(@NonNull PopularMoviesData response) {
                popularMoviesData = response;
            }

            @Override
            protected @NonNull LiveData<PopularMoviesData> loadFromDb() {
                MutableLiveData<PopularMoviesData> mutableLiveData = new MutableLiveData<>();
                mutableLiveData.setValue(popularMoviesData);
                return mutableLiveData;
            }

            @Override
            protected @NonNull Call<PopularMoviesData> createCall() {
                popularMovieCall = ApiCallManager.createService(ApiInterface.class).getPopularMovies();
                return popularMovieCall;
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<TopRatedMoviesData>> getTopRatedMoviesData() {
        return new NetworkBoundResource<TopRatedMoviesData, TopRatedMoviesData>() {

            @Override
            public void saveApiCallResult(@NonNull TopRatedMoviesData response) {
                topRatedMoviesData = response;
            }

            @Override
            protected @NonNull LiveData<TopRatedMoviesData> loadFromDb() {
                MutableLiveData<TopRatedMoviesData> mutableLiveData = new MutableLiveData<>();
                mutableLiveData.setValue(topRatedMoviesData);
                return mutableLiveData;
            }

            @Override
            protected @NonNull Call<TopRatedMoviesData> createCall() {
                topRatedMoviesCall = ApiCallManager.createService(ApiInterface.class).getTopRatedMovies();
                return topRatedMoviesCall;
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<PopularTvShowsData>> getPopularTvShowsData() {
        return new NetworkBoundResource<PopularTvShowsData, PopularTvShowsData>() {

            @Override
            public void saveApiCallResult(@NonNull PopularTvShowsData response) {
                popularTvShowsData = response;
            }

            @Override
            protected @NonNull LiveData<PopularTvShowsData> loadFromDb() {
                MutableLiveData<PopularTvShowsData> mutableLiveData = new MutableLiveData<>();
                mutableLiveData.setValue(popularTvShowsData);
                return mutableLiveData;
            }

            @Override
            protected @NonNull Call<PopularTvShowsData> createCall() {
                popularTvShowsCall = ApiCallManager.createService(ApiInterface.class).getPopularTvShows();
                return popularTvShowsCall;
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<TopRatedTvShowsData>> getTopRatedTvShowsData() {
        return new NetworkBoundResource<TopRatedTvShowsData, TopRatedTvShowsData>() {

            @Override
            public void saveApiCallResult(@NonNull TopRatedTvShowsData response) {
                topRatedTvShowsData = response;
            }

            @Override
            protected @NonNull LiveData<TopRatedTvShowsData> loadFromDb() {
                MutableLiveData<TopRatedTvShowsData> mutableLiveData = new MutableLiveData<>();
                mutableLiveData.setValue(topRatedTvShowsData);
                return mutableLiveData;
            }

            @Override
            protected @NonNull Call<TopRatedTvShowsData> createCall() {
                topRatedTvShowsCall = ApiCallManager.createService(ApiInterface.class).getTopRatedTvShows();
                return topRatedTvShowsCall;
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<UpComingMoviesData>> getUpComingMoviesData() {
        return new NetworkBoundResource<UpComingMoviesData, UpComingMoviesData>() {

            @Override
            public void saveApiCallResult(@NonNull UpComingMoviesData response) {
                upComingMoviesData = response;
            }

            @Override
            protected @NonNull LiveData<UpComingMoviesData> loadFromDb() {
                MutableLiveData<UpComingMoviesData> mutableLiveData = new MutableLiveData<>();
                mutableLiveData.setValue(upComingMoviesData);
                return mutableLiveData;
            }

            @Override
            protected @NonNull Call<UpComingMoviesData> createCall() {
                upComingMoviesDataCall = ApiCallManager.createService(ApiInterface.class).getUpComingMovies();
                return upComingMoviesDataCall;
            }
        }.getAsLiveData();
    }
}

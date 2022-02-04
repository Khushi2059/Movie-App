package com.example.movieapp.data.repository.home;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.movieapp.data.model.BannerMoviesData;
import com.example.movieapp.data.repository.base.BaseRepositoryImpl;

public class HomeRepositoryImpl extends BaseRepositoryImpl implements HomeRepository {

    @Override
    public LiveData<BannerMoviesData> getHomeCategoryData() {
        return new LiveData<BannerMoviesData>() {
            @Nullable
            @Override
            public BannerMoviesData getValue() {
                return super.getValue();
            }
        };
    }

    @Override
    public LiveData<BannerMoviesData> getTvShowsCategoryData() {
        return new LiveData<BannerMoviesData>() {
            @Nullable
            @Override
            public BannerMoviesData getValue() {
                return super.getValue();
            }
        };
    }

    @Override
    public LiveData<BannerMoviesData> getMoviesCategoryData() {
        return new LiveData<BannerMoviesData>() {
            @Nullable
            @Override
            public BannerMoviesData getValue() {
                return super.getValue();
            }
        };
    }

    @Override
    public LiveData<BannerMoviesData> getKidsCategoryData() {
        return new LiveData<BannerMoviesData>() {
            @Nullable
            @Override
            public BannerMoviesData getValue() {
                return super.getValue();
            }
        };
    }
}

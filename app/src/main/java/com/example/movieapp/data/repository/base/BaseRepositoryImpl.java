package com.example.movieapp.data.repository.base;

import com.example.movieapp.data.api.ApiCallManager;

public class BaseRepositoryImpl implements BaseRepository {

    @Override
    public <T> T getService(Class<T> service, String baseUrl) {
        return ApiCallManager.createService(service, baseUrl);
    }
}

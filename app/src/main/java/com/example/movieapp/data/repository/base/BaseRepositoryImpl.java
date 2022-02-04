package com.example.movieapp.data.repository.base;

import com.example.movieapp.data.api.ApiCallManager;

public abstract class BaseRepositoryImpl {

    protected final String TAG;

    public BaseRepositoryImpl() {
        TAG = this.getClass().getSimpleName();
    }

    public <T> T getService(Class<T> service) {
        return ApiCallManager.createService(service);
    }
}
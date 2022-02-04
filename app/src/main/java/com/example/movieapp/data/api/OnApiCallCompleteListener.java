package com.example.movieapp.data.api;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;

import io.reactivex.rxjava3.annotations.NonNull;

public interface OnApiCallCompleteListener<RequestType, ResultType> {

    @WorkerThread
    void saveApiCallResult(@NonNull RequestType response);

    @MainThread
    void updateLiveData();

    /**
     * This message will be called once the failed api called gets parsed
     *
     * @param errorMessage parsed error message
     */
    @WorkerThread
    void onApiCallFailed(String errorMessage, String requestId);

    /**
     * This method will be called from main thread to notify the UI for failed API calls
     *
     * @param errorMessage parsed error message
     */
    @MainThread
    void updateLiveDataOnFailed(String errorMessage, LiveData<ResultType> liveData, String requestId);
}

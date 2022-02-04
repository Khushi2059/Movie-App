package com.example.movieapp.data.api;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.movieapp.R;
import com.example.movieapp.ui.utils.StringUtils;

import io.reactivex.rxjava3.annotations.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class NetworkBoundResource<ResultType, RequestType> implements OnApiCallCompleteListener<RequestType, ResultType> {
    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    @MainThread
    public NetworkBoundResource() {
        init(StringUtils.getString(R.string.fetching));
    }

    public NetworkBoundResource(String loadMessage) {
        init(loadMessage);
    }

    private void init(String message) {
        result.setValue(Resource.loading(message, null));
        LiveData<ResultType> dbSource = loadFromDb();
        result.addSource(dbSource, data -> {
            result.removeSource(dbSource);
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource, message);
            } else {
                result.addSource(dbSource, newData -> result.setValue(Resource.success(newData)));
            }
        });
    }

    private void fetchFromNetwork(final LiveData<ResultType> dbSource, String message) {
        result.addSource(dbSource, newData -> result.setValue(Resource.loading(message, newData)));
        createCall().enqueue(new Callback<RequestType>() {
            @Override
            public void onResponse(@NonNull Call<RequestType> call, @NonNull Response<RequestType> response) {
                if (!call.isCanceled()) {
                    if (response.isSuccessful() && response.body() != null) {
                        result.removeSource(dbSource);
                        saveResultAndReInit(response.body());
                    } else {
                        parseFailedApiCall(call, response, null, dbSource);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<RequestType> call, @NonNull Throwable t) {
                parseFailedApiCall(call, null, t, dbSource);
            }
        });
    }

    @MainThread
    private void saveResultAndReInit(RequestType response) {
//        new ApiCallCompleteTask<>(this, response).execute();
    }

    private void parseFailedApiCall(Call<RequestType> call, Response<RequestType> response, Throwable throwable, LiveData<ResultType> liveData) {
        if (!call.isCanceled()) {
//            new ApiCallFailedTask<>(throwable, call, response, this, liveData).execute();
        }
    }

    // Lets child class decide whether override or not
    @MainThread
    protected boolean shouldFetch(@Nullable ResultType data) {
        // return NetworkChangeManager.isConnected();
        return true;
    }

    @NonNull
    @MainThread
    protected abstract LiveData<ResultType> loadFromDb();

    @NonNull
    @MainThread
    protected abstract Call<RequestType> createCall();

    /**
     * This method returns the instance of live data to notify the UI for status of the API calls
     *
     * @return result live data of the api call response
     */
    public final LiveData<Resource<ResultType>> getAsLiveData() {
        return result;
    }

    @MainThread
    @Override
    public final void updateLiveData() {
        result.addSource(loadFromDb(), newData -> result.setValue(Resource.success(newData)));
    }

    /**
     * This is a callback method which gets called after parsing the error in the background thread
     *
     * @param message parsed error message
     */
    @WorkerThread
    @Override
    public void onApiCallFailed(String message, String xRequestId) {
        //sub classes should handle if needed
    }

    /**
     * This method gets called when any error happens and parsing is done
     *
     * @param errorMessage parsed error message
     * @param liveData     data source to pass to the result
     */
    @MainThread
    @Override
    public final void updateLiveDataOnFailed(String errorMessage, LiveData<ResultType> liveData, String requestId) {
        result.removeSource(liveData);
        result.addSource(liveData, newData -> result.setValue(Resource.error(errorMessage, newData, requestId)));
    }
}

package com.example.movieapp.data.api;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import retrofit2.Call;
import retrofit2.Response;

/**
 * This task is used to parse the failed responses in the Background thread instead of Main Thread
 *
 * @param <RequestType>
 */
public class ApiCallFailedTask<RequestType, ResultType> extends AsyncTask<Void, Void, String> {
    private Throwable throwable;
    private Call<RequestType> call;
    private Response<RequestType> response;
    private OnApiCallCompleteListener<RequestType, ResultType> callCompleteListener;
    private LiveData<ResultType> dataSource;
    private String xRequestId = "";

    public ApiCallFailedTask(Throwable throwable, Call<RequestType> call, Response<RequestType> response,
                             OnApiCallCompleteListener<RequestType, ResultType> callCompleteListener, LiveData<ResultType> liveData) {
        this.throwable = throwable;
        this.call = call;
        this.response = response;
        this.callCompleteListener = callCompleteListener;
        this.dataSource = liveData;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String message = "";
        if (response == null) {
            xRequestId = "";
//            message = ErrorMessageHandler.getExceptionError(throwable, call);
        } else {
//            message = ErrorMessageHandler.getMessage(response.errorBody(), call);
        }
        callCompleteListener.onApiCallFailed(message, xRequestId);
        return message;
    }

    @Override
    protected void onPostExecute(String errorMessage) {
        callCompleteListener.updateLiveDataOnFailed(errorMessage, dataSource, xRequestId);
    }
}

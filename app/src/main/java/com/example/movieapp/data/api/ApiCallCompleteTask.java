package com.example.movieapp.data.api;

import android.os.AsyncTask;

public class ApiCallCompleteTask<RequestType, ResultType> extends AsyncTask<Void, Void, Void> {

    private OnApiCallCompleteListener<RequestType, ResultType> onApiCallCompleteListener;
    private RequestType response;

    public ApiCallCompleteTask(OnApiCallCompleteListener<RequestType, ResultType> onApiCallCompleteListener, RequestType response) {
        this.onApiCallCompleteListener = onApiCallCompleteListener;
        this.response = response;
    }

    @Override
    protected Void doInBackground(Void... params) {
        onApiCallCompleteListener.saveApiCallResult(response);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        onApiCallCompleteListener.updateLiveData();
    }
}

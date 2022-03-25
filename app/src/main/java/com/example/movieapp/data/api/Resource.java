package com.example.movieapp.data.api;

import static com.example.movieapp.data.api.NetworkStatus.ERROR;
import static com.example.movieapp.data.api.NetworkStatus.LOADING;
import static com.example.movieapp.data.api.NetworkStatus.NO_INTERNET;
import static com.example.movieapp.data.api.NetworkStatus.SUCCESS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.movieapp.R;
import com.example.movieapp.ui.utils.StringUtils;

public class Resource<T> {

    @NonNull
    public final NetworkStatus status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;
    public final String xRequestId;

    private Resource(@NonNull NetworkStatus status, @Nullable T data, @Nullable String message, String xRequestId) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.xRequestId = xRequestId;
    }

    public static <T> Resource<T> success(T data) {
        return new Resource<>(SUCCESS, data, StringUtils.getString(R.string.request_successful), "");
    }

    public static <T> Resource<T> error(String msg, @Nullable T data, String xRequestId) {
        return new Resource<>(ERROR, data, msg, xRequestId);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg, "");
    }

    public static <T> Resource<T> error(String msg) {
        return error(msg, null);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return loading(StringUtils.getString(R.string.loading), data);
    }

    public static <T> Resource<T> loading(String message, T data) {
        return new Resource<>(LOADING, data, message, "");
    }

    public static <T> Resource<T> noInternet() {
        return new Resource<>(NO_INTERNET, null, StringUtils.getString(R.string.no_internet), "");
    }
}

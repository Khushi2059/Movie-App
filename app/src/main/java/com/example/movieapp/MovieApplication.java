package com.example.movieapp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class MovieApplication extends Application {

    // TODO Need to Fix
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }
}

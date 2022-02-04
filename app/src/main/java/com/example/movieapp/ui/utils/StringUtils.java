package com.example.movieapp.ui.utils;

import com.example.movieapp.MovieApplication;

public class StringUtils {

    public static String getString(int resId) {
        return MovieApplication.getContext().getString(resId);
    }
}

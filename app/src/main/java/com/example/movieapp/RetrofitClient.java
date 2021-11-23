package com.example.movieapp;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private  static  final String BASE_URL="https://api.themoviedb.org/3/movie/popular?api_key/";
    private  static  final String api_key="232be951f20b306084f1a1bcc66a1081";
public static  ApiInterface getRetrofitClient(){
    Retrofit.Builder builder=new Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL+api_key);
    return builder.build().create(ApiInterface.class);
}
}

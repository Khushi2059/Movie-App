package com.example.movieapp.data.api;

import static com.example.movieapp.ui.utils.MovieConstant.BASE_URL;
import static com.example.movieapp.ui.utils.MovieConstant.TIME_OUT_DURATION;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiCallManager {

    private static final String OK_HTTP_TAG = "MovieApplication";

    private static final Interceptor interceptor = chain -> {
        Request request;
        try {
            request = getHeaderAndParams(chain);
        } catch (Exception e) {
            request = chain.request().newBuilder().tag(OK_HTTP_TAG).build();
        }
        return chain.proceed(request);
    };

    private static Request getHeaderAndParams(Interceptor.Chain chain) {
        Request original = chain.request().newBuilder().tag(OK_HTTP_TAG).build();
        Request.Builder requestBuilder = original.newBuilder();

        HttpUrl originalHttpUrl = original.url();
        HttpUrl.Builder builder = originalHttpUrl.newBuilder();
        builder.addQueryParameter("api_key", "232be951f20b306084f1a1bcc66a1081");
        HttpUrl url = builder.build();
        requestBuilder.url(url);
        return requestBuilder.build();
    }

    private static OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
            .readTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
            .addInterceptor(interceptor);

    private static OkHttpClient okHttpClient = clientBuilder.build();

    private static Retrofit.Builder retroBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient);

    public static <T> T createService(final Class<T> service) {
        Retrofit retrofit = retroBuilder.baseUrl(BASE_URL).build();
        return retrofit.create(service);
    }
}

package com.example.movieapp.data.api;


public class ApiCallManager {

    private static final String OK_HTTP_TAG = "MovieApplication";

    public static <T> T createService(final Class<T> service, String baseUrl) {
//        if (!isValidBaseUrl(baseUrl)) {
//            baseUrl = HUB_FIND_BASE_URL;
//        }
//        ApiInterface retrofit = RetrofitClient.getRetrofitClient();
//        return retrofit.create(service);
        return null;
    }

    private static boolean isValidBaseUrl(String baseUrl) {
        return baseUrl != null && !baseUrl.isEmpty() && baseUrl.contains("http");
    }
}

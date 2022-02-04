package com.example.movieapp.data.repository.base;

public interface BaseRepository {

    <T> T getService(Class<T> service, String baseUrl);
}

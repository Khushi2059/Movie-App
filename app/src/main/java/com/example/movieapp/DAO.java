package com.example.movieapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.movieapp.model.BannerMovies;
import com.example.movieapp.model.MovieResp;

import java.util.List;
@Dao
public interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BannerMovies bannerMovies);
    @Query("SELECT * FROM movie_table")
    LiveData<List<BannerMovies>>getAllMovies();
    @Query("DELETE FROM movie_table")
    void deleteMovie();
}

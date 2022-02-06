package com.example.movieapp;

import android.app.Application;
import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.movieapp.model.BannerMovies;

@Database(entities = {BannerMovies.class}, version = 1)
    public abstract class MovieDataBase extends RoomDatabase {
    public abstract DAO dao();  //to call all method of DAO class

    private static MovieDataBase instance;

    static MovieDataBase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, MovieDataBase.class, "movieDataBase ").build();
        }
        return instance;
    }
}

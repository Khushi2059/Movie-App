package com.example.movieapp.model;

public class  MovieModelClass {

        String id;
        String original_title;
        String poster_path;
        String video;


    public MovieModelClass() {
        this.id = id;
        this.original_title = original_title;
        this.poster_path = poster_path;
        this.video = video;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}

package com.example.movieapp.model;

import androidx.room.Entity;

import com.example.movieapp.model.BannerMovies;

import java.util.List;
@Entity(tableName = "movie_table")
public class MovieResp {
    Integer page;
    List<BannerMovies> results;
    Integer total_pages;
    Integer total_results;

    public MovieResp(Integer page, List<BannerMovies> moviesList, Integer total_pages, Integer total_results) {
        this.page = page;
        this.results = moviesList;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<BannerMovies> getMoviesList() {
        return results;
    }

    public void setMoviesList(List<BannerMovies> moviesList) {
        this.results = moviesList;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }
}

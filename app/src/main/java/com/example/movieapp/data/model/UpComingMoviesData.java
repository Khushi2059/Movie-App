package com.example.movieapp.data.model;

import java.util.List;

public class UpComingMoviesData {

    private int page;
    private List<MovieData> results;
    private int total_pages;
    private int total_results;

    public UpComingMoviesData(int page, List<MovieData> moviesList, int total_pages, int total_results) {
        this.page = page;
        this.results = moviesList;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieData> getMoviesList() {
        return results;
    }

    public void setMoviesList(List<MovieData> moviesList) {
        this.results = moviesList;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}

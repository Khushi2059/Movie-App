package com.example.movieapp.data.model;

import java.util.List;

public class PopularTvShowsData {

    private Integer page;
    private List<MovieData> results;
    private Integer total_pages;
    private Integer total_results;

    public PopularTvShowsData(Integer page, List<MovieData> moviesList, Integer total_pages, Integer total_results) {
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

    public List<MovieData> getMoviesList() {
        return results;
    }

    public void setMoviesList(List<MovieData> moviesList) {
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

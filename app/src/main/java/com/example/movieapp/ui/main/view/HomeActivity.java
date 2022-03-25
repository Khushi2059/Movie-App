package com.example.movieapp.ui.main.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.movieapp.R;
import com.example.movieapp.ui.main.adapter.HomePageAdapter;
import com.example.movieapp.ui.main.adapter.KidsPageAdapter;
import com.example.movieapp.ui.main.adapter.MoviesPageAdapter;
import com.example.movieapp.ui.main.adapter.RecyclerViewAdapter;
import com.example.movieapp.ui.main.adapter.TvPageAdapter;
import com.example.movieapp.ui.main.viewmodel.HomeViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private KidsPageAdapter kidsPageAdapter;
    private RecyclerViewAdapter recyclerViewAdapter;
    private HomePageAdapter homePageAdapter;
    private MoviesPageAdapter moviesPageAdapter;
    private TvPageAdapter tvPageAdapter;
    private TabLayout indicator, categoryTab;
    private ViewPager bannerMoviesViewPager;
    private RecyclerView mainRecycler;
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewModel();
        homePageAdapter = new HomePageAdapter(this, new ArrayList<>());
        tvPageAdapter = new TvPageAdapter(this, new ArrayList<>());
        moviesPageAdapter = new MoviesPageAdapter(this, new ArrayList<>());
        kidsPageAdapter = new KidsPageAdapter(this, new ArrayList<>());
        recyclerViewAdapter = new RecyclerViewAdapter(this, new ArrayList<>());

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setTvShowsPage();
                        return;
                    case 2:
                        setMoviesPage();
                        return;
                    case 3:
                        setKidsPage();
                        return;
                    default:
                        setHomePage();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        setMainRecycler();
    }


    private void setTimer() {

        indicator.setupWithViewPager(bannerMoviesViewPager);
    }

    private void setHomePage() {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(homePageAdapter);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        setTimer();
    }

    private void setTvShowsPage() {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(tvPageAdapter);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        setTimer();
    }

    private void setMoviesPage() {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(moviesPageAdapter);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        setTimer();
    }

    private void setKidsPage() {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(kidsPageAdapter);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        setTimer();
    }

    public void setMainRecycler() {

        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecycler.setAdapter(recyclerViewAdapter);
    }

    public void initView() {
        indicator = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
    }

    private void initViewModel() {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        initPopularMovies();
        initTopRatedMovies();
        initPopularTvShows();
        initTopRatedTvShows();
        initUpComingMovies();
    }

    private void initPopularMovies() {
        homeViewModel.getPopularMovies().observe(this, popularMoviesData -> {
            if (popularMoviesData != null) {
                homePageAdapter.setHomePageAdapter(popularMoviesData);
            }
        });
    }

    private void initTopRatedMovies() {
        homeViewModel.getTopRatedMovies().observe(this, topRatedMoviesData -> {
            if (topRatedMoviesData != null) {
                tvPageAdapter.setTvPageAdapter(topRatedMoviesData);
            }
        });
    }

    private void initPopularTvShows() {
        homeViewModel.getPopularTvShows().observe(this, popularTvShowsData -> {
            if (popularTvShowsData != null) {
                moviesPageAdapter.setBannerMoviesList3(popularTvShowsData);
            }
        });
    }

    private void initTopRatedTvShows() {
        homeViewModel.getTopRatedTvShowsData().observe(this, topRatedTvShowsData -> {
            if (topRatedTvShowsData != null) {
                kidsPageAdapter.setKidsPageAdapter(topRatedTvShowsData);
            }
        });
    }

    private void initUpComingMovies() {
        homeViewModel.getUpComingMoviesData().observe(this, upComingMoviesData -> {
            if (upComingMoviesData != null) {
                recyclerViewAdapter.SetAdapter(upComingMoviesData);
            }
        });
    }
}
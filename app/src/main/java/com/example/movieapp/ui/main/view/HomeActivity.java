package com.example.movieapp.ui.main.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.movieapp.MovieDataBase;
import com.example.movieapp.R;
import com.example.movieapp.ui.main.adapter.RecyclerViewAdapter;
import com.example.movieapp.ui.main.adapter.KidsPageAdapter;
import com.example.movieapp.ui.main.adapter.HomePageAdapter;
import com.example.movieapp.ui.main.adapter.MoviesPageAdapter;
import com.example.movieapp.ui.main.adapter.TvPageAdapter;
import com.example.movieapp.ui.main.viewmodel.MainActivityViewModel;
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
    private MainActivityViewModel mainActivityViewModel;
    private RecyclerView mainRecycler;
    private MovieDataBase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainActivityViewModel = new ViewModelProvider(HomeActivity.this).get(MainActivityViewModel.class);

        homePageAdapter = new HomePageAdapter(this, new ArrayList<>());
        tvPageAdapter = new TvPageAdapter(this, new ArrayList<>());
        moviesPageAdapter = new MoviesPageAdapter(this, new ArrayList<>());
        kidsPageAdapter = new KidsPageAdapter(this, new ArrayList<>());
        recyclerViewAdapter =new RecyclerViewAdapter(this,new ArrayList<>());

        // TODO This is wrong way to get data from ViewModel
        mainActivityViewModel.getBannerData(homePageAdapter);
        mainActivityViewModel.getBannerData1(tvPageAdapter);
        mainActivityViewModel.getBannerData2(moviesPageAdapter);
        mainActivityViewModel.getBannerData3(kidsPageAdapter);
        mainActivityViewModel.getBannerData4(recyclerViewAdapter);



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


    private void setTimer()
    {

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
  public  void setMainRecycler()
  {

     mainRecycler = findViewById(R.id.main_recycler);
      RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
      mainRecycler.setLayoutManager(layoutManager);
      mainRecycler.setAdapter(recyclerViewAdapter);
  }


    public void initView() {
        indicator = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        // TODO  This is not they way of creating viewModel class, Please check the documentation why and how to initialize viewModel
    }


}
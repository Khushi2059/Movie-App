package com.example.movieapp.ui.main.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.movieapp.R;
import com.example.movieapp.ui.main.adapter.Adapter;
import com.example.movieapp.ui.main.adapter.BannerMoviesPagesAdapter;
import com.example.movieapp.ui.main.adapter.BannerMoviesPagesAdapter2;
import com.example.movieapp.ui.main.adapter.BannerMoviesPagesAdapter3;
import com.example.movieapp.ui.main.adapter.BannerMoviesPagesAdapter4;
import com.example.movieapp.data.model.BannerMoviesData;
import com.example.movieapp.data.model.MovieModelClass;
import com.example.movieapp.ui.main.viewmodel.HomeViewModel;
import com.example.movieapp.ui.main.viewmodel.MainActivityViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// TODO change this activity name to HomeActivity, As this will the default activity
// TODO Please delete all the debutante code
public class MainActivity extends AppCompatActivity {

    // TODO Please make all the variable private, as this variable are using only in this class
    // TODO What is bannerMoviesPagesAdapter, bannerMoviesPagesAdapter2, bannerMoviesPagesAdapter3, bannerMoviesPagesAdapter4
    // TODO Please make all the variable name more readable and understandable
    BannerMoviesPagesAdapter bannerMoviesPagesAdapter;
    // TODO FIX the Name, make the variable private
    BannerMoviesPagesAdapter2 bannerMoviesPagesAdapter2;
    // TODO FIX the Name, make the variable private
    BannerMoviesPagesAdapter3 bannerMoviesPagesAdapter3;
    // TODO FIX the Name, make the variable private
    BannerMoviesPagesAdapter4 bannerMoviesPagesAdapter4;
    // TODO FIX the Name, make the variable private
    TabLayout indicator, categoryTab;
    // TODO make the variable private
    List<BannerMoviesData> homeBannerList;
    // TODO make the variable private
    List<BannerMoviesData> tvShowBannerList;
    // TODO make the variable private
    List<BannerMoviesData> movieBannerList;
    // TODO make the variable private
    List<BannerMoviesData> kidsBannerList;
    // TODO make the variable private
    ViewPager bannerMoviesViewPager;
    // TODO make the variable private
    List<MovieModelClass> movieList;
    // TODO make the variable private
    RecyclerView recyclerView;
    // TODO make the variable private
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    // TODO make the variable private
    MainActivityViewModel mainActivityViewModel;

    // My Code
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bannerMoviesPagesAdapter = new BannerMoviesPagesAdapter(this, new ArrayList<>());
        bannerMoviesPagesAdapter2 = new BannerMoviesPagesAdapter2(this, new ArrayList<>());
        bannerMoviesPagesAdapter3 = new BannerMoviesPagesAdapter3(this, new ArrayList<>());
        bannerMoviesPagesAdapter4 = new BannerMoviesPagesAdapter4(this, new ArrayList<>());
        // TODO What is Adapter ?? Please change the class and variable name
        Adapter adapter = new Adapter(this, new ArrayList<>());
        // TODO This is wrong way to get data from ViewModel
        mainActivityViewModel.getBannerData(bannerMoviesPagesAdapter);
        mainActivityViewModel.getBannerData1(bannerMoviesPagesAdapter2);
        mainActivityViewModel.getBannerData2(bannerMoviesPagesAdapter3);
        mainActivityViewModel.getBannerData3(bannerMoviesPagesAdapter4);
        // TODO This code will produce memory leak, Need to re-factor
        // TODO Why are you using Async task ??? If you have dependency of RxJava, then why you need a async task ?
        MainActivityViewModel.GetData getData = new MainActivityViewModel.GetData(adapter, recyclerView, linearLayoutManager);
        getData.execute();

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        setBannerMoviesPagerAdapter3(tvShowBannerList);
                        return;
                    case 2:
                        setBannerMoviesPagerAdapter2(movieBannerList);
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter4(kidsBannerList);
                        return;
                    default:
                        setBannerMoviesPagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    // TODO Please create a method and put all the common logics, Do not repeat any code
    // TODO we are not using bannerMoviesList, then why this variable you are passing
    private void setBannerMoviesPagerAdapter(List<BannerMoviesData> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagesAdapter);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        // Try to make a common
        Timer sliderTimer = new Timer();
        // TODO Don't hardcode the value, initialise the value 3000, 5000
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3000, 5000);
        indicator.setupWithViewPager(bannerMoviesViewPager);
    }

    // TODO Please change the method name, setBannerMoviesPagerAdapter2 it is not easy to understand what is this
    // TODO we are not using bannerMoviesList, then why this variable you are passing
    private void setBannerMoviesPagerAdapter2(List<BannerMoviesData> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagesAdapter2);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        Timer sliderTimer = new Timer();
        // TODO Don't hardcode the value,initialise the value 3000, 5000
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3000, 5000);
        indicator.setupWithViewPager(bannerMoviesViewPager);
    }

    // TODO Please change the method name, setBannerMoviesPagerAdapter3 it is not easy to understand what is this
    // TODO we are not using bannerMoviesList, then why this variable you are passing
    private void setBannerMoviesPagerAdapter3(List<BannerMoviesData> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagesAdapter3);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        Timer sliderTimer = new Timer();
        // TODO Don't hardcode the value,initialise the value 3000, 5000
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3000, 5000);
        indicator.setupWithViewPager(bannerMoviesViewPager);
    }

    // TODO Please change the method name, setBannerMoviesPagerAdapter4 it is not easy to understand what is this
    // TODO we are not using bannerMoviesList, then why this variable you are passing
    private void setBannerMoviesPagerAdapter4(List<BannerMoviesData> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagesAdapter4);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        Timer sliderTimer = new Timer();
        // TODO Don't hardcode the value,initialise the value of 3000, 5000
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3000, 5000);
        indicator.setupWithViewPager(bannerMoviesViewPager);
    }

    // TODO This make produce memory leak, Please remove this from view, create a separate class or put the logic in viewmodell
    class AutoSlider extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // TODO Modify this logic to this bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                    if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1) {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                    } else {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                    }
                }
            });

        }
    }

    // TODO init doesn't make any sense, change it to initView
    public void init() {
        indicator = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        recyclerView = findViewById(R.id.main_recycler);
        // TODO You can initialize the arrayList into the instance variable it-self
        // Remove it from here
        homeBannerList = new ArrayList<>();
        tvShowBannerList = new ArrayList<>();
        movieBannerList = new ArrayList<>();
        kidsBannerList = new ArrayList<>();
        movieList = new ArrayList<>();
        // TODO  This is not they way of creating viewModel class, Please check the documentation why and how to initialize viewModel
        mainActivityViewModel = new MainActivityViewModel();
        // My Code
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }
}
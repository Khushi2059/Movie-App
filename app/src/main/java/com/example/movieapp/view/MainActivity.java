package com.example.movieapp.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.movieapp.R;
import com.example.movieapp.adapter.Adapter;
import com.example.movieapp.adapter.BannerMoviesPagesAdapter;
import com.example.movieapp.adapter.BannerMoviesPagesAdapter2;
import com.example.movieapp.adapter.BannerMoviesPagesAdapter3;
import com.example.movieapp.adapter.BannerMoviesPagesAdapter4;
import com.example.movieapp.model.BannerMovies;
import com.example.movieapp.model.MovieModelClass;
import com.example.movieapp.viewmodel.MainActivityViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    //
//    void showToast(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }

    BannerMoviesPagesAdapter bannerMoviesPagesAdapter;
    BannerMoviesPagesAdapter2 bannerMoviesPagesAdapter2;
    BannerMoviesPagesAdapter3 bannerMoviesPagesAdapter3;
    BannerMoviesPagesAdapter4 bannerMoviesPagesAdapter4;
    TabLayout indicator, categoryTab;

    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;
    ViewPager bannerMoviesViewPager;
    List<MovieModelClass> movieList;
    RecyclerView recyclerView;
LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        bannerMoviesPagesAdapter=new BannerMoviesPagesAdapter(this,new ArrayList<BannerMovies>());
        bannerMoviesPagesAdapter2= new BannerMoviesPagesAdapter2(this,new ArrayList<BannerMovies>());
        bannerMoviesPagesAdapter3= new BannerMoviesPagesAdapter3(this,new ArrayList<BannerMovies>());
        bannerMoviesPagesAdapter4= new BannerMoviesPagesAdapter4(this,new ArrayList<BannerMovies>());
        Adapter adapter=new Adapter(this,new ArrayList<>());

        mainActivityViewModel.getBannerData(bannerMoviesPagesAdapter);
        mainActivityViewModel.getBannerData1(bannerMoviesPagesAdapter2);
        mainActivityViewModel.getBannerData2(bannerMoviesPagesAdapter3);
        mainActivityViewModel.getBannerData3(bannerMoviesPagesAdapter4);


        MainActivityViewModel.GetData getData=new MainActivityViewModel.GetData(adapter,recyclerView,linearLayoutManager);
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

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagesAdapter);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3000, 5000);
        indicator.setupWithViewPager(bannerMoviesViewPager);
    }
    private void setBannerMoviesPagerAdapter2(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagesAdapter2);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3000, 5000);
        indicator.setupWithViewPager(bannerMoviesViewPager);
    }
    private void setBannerMoviesPagerAdapter3(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagesAdapter3);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3000, 5000);
        indicator.setupWithViewPager(bannerMoviesViewPager);
    }
    private void setBannerMoviesPagerAdapter4(List<BannerMovies> bannerMoviesList) {
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagesAdapter4);
        indicator.setupWithViewPager(bannerMoviesViewPager);
        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 3000, 5000);
        indicator.setupWithViewPager(bannerMoviesViewPager);
    }
    class AutoSlider extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1) {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                    }
                    else {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem()+1);
                    }
                }
            });

        }
    }


    public void init() {
        indicator = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);

        homeBannerList = new ArrayList<>();
        tvShowBannerList = new ArrayList<>();
        movieBannerList = new ArrayList<>();
        kidsBannerList = new ArrayList<>();
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.main_recycler);
        mainActivityViewModel = new MainActivityViewModel();

    }


}
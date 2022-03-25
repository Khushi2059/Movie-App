package com.example.movieapp.ui.main.viewmodel;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.example.movieapp.data.api.NetworkStatus;
import com.example.movieapp.data.api.Resource;
import com.example.movieapp.data.model.MovieData;
import com.example.movieapp.data.model.PopularMoviesData;
import com.example.movieapp.data.model.PopularTvShowsData;
import com.example.movieapp.data.model.TopRatedMoviesData;
import com.example.movieapp.data.model.TopRatedTvShowsData;
import com.example.movieapp.data.model.UpComingMoviesData;
import com.example.movieapp.data.repository.home.HomeRepository;

import org.junit.After;
import org.junit.Before;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class HomeViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
private HomeViewModel homeViewModel;
@Mock
private HomeRepository homeRepository;
    @Before
    public void setUp() throws Exception {
        homeViewModel= new HomeViewModel();
        homeViewModel.homeRepository=homeRepository;
        MutableLiveData<Resource<PopularMoviesData>> popularMoviesData = getPopularMoviesDataTest();
        MutableLiveData<Resource<TopRatedMoviesData>> topRatedMoviesData = getTopRatedMoviesDataTest();
        MutableLiveData<Resource<PopularTvShowsData>> popularTvShowsData = getPopularTvShowsDataTest();
        MutableLiveData<Resource<TopRatedTvShowsData>> topRatedTvShowsData = getTopRatedTvShowsDataTest();
        MutableLiveData<Resource<UpComingMoviesData>> upComingMoviesData = getUpComingMoviesDataTest();
        when(homeRepository.getPopularMoviesData()).thenReturn(popularMoviesData);
        when(homeRepository.getTopRatedMoviesData()).thenReturn(topRatedMoviesData);
        when(homeRepository.getPopularTvShowsData()).thenReturn(popularTvShowsData);
        when(homeRepository.getTopRatedTvShowsData()).thenReturn(topRatedTvShowsData);
        when(homeRepository.getUpComingMoviesData()).thenReturn(upComingMoviesData);
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPopularMovies() {
        LiveData<List<MovieData>> res = homeViewModel.getPopularMovies();
         verify(homeRepository).getPopularMoviesData();
        Assert.assertEquals(getMovieDataListTest().get(0).getId(), res.getValue().get(0).getId());
    }

    @Test
    public void getTopRatedMovies() {
        LiveData<List<MovieData>> res2 = homeViewModel.getTopRatedMovies();
        verify(homeRepository).getTopRatedMoviesData();
        Assert.assertEquals(getTopRatedMoviesTest().get(0).getId(), res2.getValue().get(0).getId());

    }

    @Test
    public void getPopularTvShows() {
        LiveData<List<MovieData>> res3 = homeViewModel.getPopularTvShows();
        verify(homeRepository).getPopularTvShowsData();
        Assert.assertEquals(getPopularTvShowsTest().get(0).getId(), res3.getValue().get(0).getId());

    }

    @Test
    public void getTopRatedTvShowsData() {
        LiveData<List<MovieData>> res4 = homeViewModel.getTopRatedTvShowsData();
        verify(homeRepository).getTopRatedTvShowsData();
        Assert.assertEquals(getTopRatedTvShowsTest().get(0).getId(), res4.getValue().get(0).getId());

    }

    @Test
    public void getUpComingMoviesData() {
        LiveData<List<MovieData>> res5 = homeViewModel.getUpComingMoviesData();
        verify(homeRepository).getUpComingMoviesData();
        Assert.assertEquals(getUpComingMoviesTest().get(0).getId(), res5.getValue().get(0).getId());

    }

    private MutableLiveData<Resource<PopularMoviesData>> getPopularMoviesDataTest() {
        PopularMoviesData popularMoviesData = new PopularMoviesData(10, getMovieDataListTest(), 100, 20);
        Resource<PopularMoviesData> resource = new Resource<PopularMoviesData>(NetworkStatus.SUCCESS, popularMoviesData, "Sample msg", "");
        MutableLiveData<Resource<PopularMoviesData>> res = new MutableLiveData<Resource<PopularMoviesData>>();
        res.setValue(resource);
        return res;
    }

    private List<MovieData> getMovieDataListTest() {
        return testClass();
    }


    private MutableLiveData<Resource<TopRatedMoviesData>> getTopRatedMoviesDataTest() {
        TopRatedMoviesData topRatedMoviesData = new TopRatedMoviesData(10, getTopRatedMoviesTest(), 100, 20);
        Resource<TopRatedMoviesData> resource2 = new Resource<TopRatedMoviesData>(NetworkStatus.SUCCESS, topRatedMoviesData, "Sample msg", "");
        MutableLiveData<Resource<TopRatedMoviesData>> res2 = new MutableLiveData<Resource<TopRatedMoviesData>>();
        res2.setValue(resource2);
        return res2;
    }
    private List<MovieData> getTopRatedMoviesTest() {
        return testClass();
    }



    private MutableLiveData<Resource<PopularTvShowsData>> getPopularTvShowsDataTest(){
        PopularTvShowsData popularTvShowsData = new PopularTvShowsData(10, getPopularTvShowsTest(), 100, 20);
        Resource<PopularTvShowsData> resource3 = new Resource<PopularTvShowsData>(NetworkStatus.SUCCESS, popularTvShowsData, "Sample msg", "");
        MutableLiveData<Resource<PopularTvShowsData>> res3 = new MutableLiveData<Resource<PopularTvShowsData>>();
        res3.setValue(resource3);
        return res3;
    }
    private List<MovieData> getPopularTvShowsTest() {
        return testClass();
    }



    private MutableLiveData<Resource<TopRatedTvShowsData>> getTopRatedTvShowsDataTest(){
        TopRatedTvShowsData topRatedTvShowsData = new TopRatedTvShowsData(10, getMovieDataListTest(), 100, 20);
        Resource<TopRatedTvShowsData> resource4 = new Resource<TopRatedTvShowsData>(NetworkStatus.SUCCESS, topRatedTvShowsData, "Sample msg", "");
        MutableLiveData<Resource<TopRatedTvShowsData>> res4 = new MutableLiveData<Resource<TopRatedTvShowsData>>();
        res4.setValue(resource4);
        return res4;
    }
    private List<MovieData> getTopRatedTvShowsTest() {
        return testClass();
    }



    private MutableLiveData<Resource<UpComingMoviesData>> getUpComingMoviesDataTest() {
        UpComingMoviesData upComingMoviesData= new UpComingMoviesData(10, getMovieDataListTest(), 100, 20);
        Resource<UpComingMoviesData> resource5 = new Resource<UpComingMoviesData>(NetworkStatus.SUCCESS, upComingMoviesData, "Sample msg", "");
        MutableLiveData<Resource<UpComingMoviesData>> res5 = new MutableLiveData<Resource<UpComingMoviesData>>();
        res5.setValue(resource5);
        return res5;
    }
    private List<MovieData> getUpComingMoviesTest() {
     return testClass();
    }

    private List<MovieData> testClass() {
        List<MovieData> myList = new ArrayList<MovieData>();
        MovieData movieData = new MovieData();
        movieData.setId("testId");
        myList.add(movieData);
        return myList;
    }
}
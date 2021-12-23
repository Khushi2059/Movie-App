package com.example.movieapp.viewmodel;

import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.adapter.Adapter;
import com.example.movieapp.adapter.BannerMoviesPagesAdapter;
import com.example.movieapp.adapter.BannerMoviesPagesAdapter2;
import com.example.movieapp.adapter.BannerMoviesPagesAdapter3;
import com.example.movieapp.adapter.BannerMoviesPagesAdapter4;
import com.example.movieapp.model.BannerMovies;
import com.example.movieapp.model.HomeResp;
import com.example.movieapp.model.KidsResp;
import com.example.movieapp.model.MovieModelClass;
import com.example.movieapp.model.MovieResp;
import com.example.movieapp.model.TvResp;
import com.example.movieapp.retrofit.RetrofitClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel {
    private static String BASE_URL="https://api.themoviedb.org/3/tv/airing_today?api_key=232be951f20b306084f1a1bcc66a1081";


    public void getBannerData(BannerMoviesPagesAdapter bannerMoviesPagesAdapter){
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        boolean bannerData = compositeDisposable.add(RetrofitClient.getRetrofitClient().getMovieResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<MovieResp>() {
                    @Override
                    public void onNext(MovieResp moviesResp) {
                        //   Log.d("bannerData", moviesResp.getMoviesList().toString());
                        List<BannerMovies> movieBannerList = moviesResp.getMoviesList();
                        bannerMoviesPagesAdapter.setKidsBannerList(movieBannerList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                })

        );
    }
    public void getBannerData1(BannerMoviesPagesAdapter2 bannerMoviesPagesAdapter2){
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        boolean bannerData1 = compositeDisposable.add(RetrofitClient.getRetrofitClient().getHomeResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<HomeResp>() {
                    @Override
                    public void onNext(HomeResp homeResp) {
                        //  Log.d("bannerData", homeResp.getMoviesList().toString());
                        List<BannerMovies> homeBannerList= homeResp.getMoviesList();
                        bannerMoviesPagesAdapter2.setBannerMoviesList2(homeBannerList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                })

        );
    }
    public void getBannerData2(BannerMoviesPagesAdapter3 bannerMoviesPagesAdapter3){
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        boolean bannerData2 = compositeDisposable.add(RetrofitClient.getRetrofitClient().getTvResp()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<TvResp>() {
                    @Override
                    public void onNext(TvResp tvResp) {
                        //  Log.d("bannerData", tvResp.getMoviesList().toString());
                        List<BannerMovies> tvShowBannerList = tvResp.getMoviesList();
                        bannerMoviesPagesAdapter3.setBannerMoviesList3(tvShowBannerList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                })

        );
    }


    public void getBannerData3(BannerMoviesPagesAdapter4 bannerMoviesPagesAdapter4){
        CompositeDisposable compositeDisposable=new CompositeDisposable();
        boolean bannerData3 = compositeDisposable.add(RetrofitClient.getRetrofitClient().getWatchNext()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<KidsResp>() {
                    @Override
                    public void onNext(KidsResp kidsResp) {
                        //  Log.d("bannerData", tvResp.getMoviesList().toString());
                        List<BannerMovies> kidsBannerList = kidsResp.getMoviesList();
                        bannerMoviesPagesAdapter4.setBannerMoviesList4(kidsBannerList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bannerData", "" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                })

        );
    }





    public static class GetData extends AsyncTask<String,String,String>
    {
        Adapter adapter;
        RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager;
        public GetData(Adapter adapter,RecyclerView recyclerView,LinearLayoutManager linearLayoutManager) {
            this.adapter=adapter;
            this.recyclerView=recyclerView;
            this.linearLayoutManager=linearLayoutManager;
        }

        @Override
        protected String doInBackground(String... strings) {
            String current="";
            try{
                URL url;
                HttpURLConnection urlConnection=null;
                try {
                    url=new URL(BASE_URL);
                    urlConnection=(HttpURLConnection) url.openConnection();

                    InputStream is=urlConnection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);

                    int data=isr.read();
                    while(data!=-1)
                    {
                        current+=(char)data;
                        data=isr.read();
                    }
                    return current;
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally {
                    if(urlConnection!=null)
                    {
                        urlConnection.disconnect();
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return current;
        }
        @Override
        protected void onPostExecute(String s){
            List<MovieModelClass> movieList=new ArrayList<>();
            try{
                JSONObject jsonObject=new JSONObject(s);
                JSONArray jsonArray=jsonObject.getJSONArray("results");

                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);

                    MovieModelClass model=new MovieModelClass();
                    model.setId(jsonObject1.getString("name"));
                    model.setOriginal_title(jsonObject1.getString("original_name"));
                    model.setPoster_path(jsonObject1.getString("poster_path"));

                    movieList.add(model);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(movieList,adapter,recyclerView,linearLayoutManager);
        }
    }
    public static void PutDataIntoRecyclerView(List<MovieModelClass> movieList,Adapter adapter,RecyclerView recyclerView,LinearLayoutManager linearLayoutManager){
        adapter.SetAdapter(movieList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}

package com.example.movieapp.ui.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.model.BannerMovies;
import com.example.movieapp.ui.main.view.MovieDetails;

import java.util.List;

public class BannerMoviesPagesAdapter4 extends PagerAdapter {
    Context context;
    List<BannerMovies> tvShowBannerList;

    public BannerMoviesPagesAdapter4(Context context, List<BannerMovies> bannerMoviesList) {
        this.context= context;
        this.tvShowBannerList = bannerMoviesList;
    }

    public void setBannerMoviesList4(List<BannerMovies> bannerMoviesList) {
        this.tvShowBannerList = bannerMoviesList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tvShowBannerList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.banner_movie_layout,null);
        final ImageView bannerImage=view.findViewById(R.id.banner_image);
        Glide.with(context).load("https://image.tmdb.org/t/p/original" + tvShowBannerList.get(position).getPoster_path()).into(bannerImage);
        container.addView(view);

        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, MovieDetails.class);
                i.putExtra("id", tvShowBannerList.get(position).getId());
                i.putExtra("original_name", tvShowBannerList.get(position).getOriginal_title());
                i.putExtra("poster_path","https://image.tmdb.org/t/p/original"+ tvShowBannerList.get(position).getPoster_path());
                i.putExtra("movieFile", tvShowBannerList.get(position).getVideo());
                context.startActivity(i);
            }
        });

        return view;
    }
}

package com.example.movieapp.adapter;

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
import com.example.movieapp.view.MovieDetails;

import java.util.List;

public class BannerMoviesPagesAdapter extends PagerAdapter {
    Context context;
    List<BannerMovies> kidsBannerList;

    public BannerMoviesPagesAdapter(Context context, List<BannerMovies> bannerMoviesList) {
        this.context= context;
        this.kidsBannerList = bannerMoviesList;
    }

    public void setKidsBannerList(List<BannerMovies> kidsBannerList) {
        this.kidsBannerList = kidsBannerList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return kidsBannerList.size();
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
        Glide.with(context).load("https://image.tmdb.org/t/p/original" + kidsBannerList.get(position).getPoster_path()).into(bannerImage);
        container.addView(view);

        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, MovieDetails.class);
                i.putExtra("id", kidsBannerList.get(position).getId());
                i.putExtra("original_name", kidsBannerList.get(position).getOriginal_title());
                i.putExtra("poster_path","https://image.tmdb.org/t/p/original"+ kidsBannerList.get(position).getPoster_path());
                i.putExtra("movieFile", kidsBannerList.get(position).getVideo());
                context.startActivity(i);
            }
        });

        return view;
    }

}

package com.example.movieapp.ui.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;

public class MovieDetailsActivity extends AppCompatActivity {
    private ImageView movieImage,movieImage2;
    private TextView movieName;
    private Button playButton;

    private String mMovieName, mMovieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        initView();
        initData();
    }

    private void initData() {
        mMovieName = getIntent().getStringExtra("original_name");
        mMovieImage = getIntent().getStringExtra("poster_path");
        Glide.with(this).load( mMovieImage).into(movieImage);
        Glide.with(this).load( mMovieImage).into(movieImage2);
        movieName.setText(mMovieName);
        playButton.setOnClickListener(view -> {
            Intent i = new Intent(MovieDetailsActivity.this, VideoPlayerActivity.class);
            i.putExtra("url", mMovieName);
            startActivity(i);
        });
    }

    private void initView() {
        movieImage = findViewById(R.id.movie_image);
        movieImage2 = findViewById(R.id.movie_image2);
        movieName = findViewById(R.id.movie_name);
        playButton = findViewById(R.id.play_button);
    }
}
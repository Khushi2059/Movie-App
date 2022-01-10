package com.example.movieapp.ui.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;

// TODO Activity Name Should end with Activity, like MovieDetailsActivity, MovieDetails doesn't make any sense, Please change
public class MovieDetails extends AppCompatActivity {
    // TODO Please make all the variable private as this variable are only using in this class
    ImageView movieImage;
    TextView movieName;
    Button playButton;
    // TODO Please fix the naming issue, mName, mImage, mId, mFileUrl is what ???? MightBe mMovieName example
    String mName, mImage, mId, mFileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        // TODO as you are using convention of initView() in MainActivity, you should use the same here
        movieImage = findViewById(R.id.movie_image);
        movieName = findViewById(R.id.movie_name);
        playButton = findViewById(R.id.play_button);
        // TODO Please move the below code initData()
        // TODO KEY should present in constant, Please fix
        mId = getIntent().getStringExtra("movieId");
        mName = getIntent().getStringExtra("movieName");
        mImage = getIntent().getStringExtra("movieImageUrl");
        mFileUrl = getIntent().getStringExtra("movieFile");
        Glide.with(this).load(mImage).into(movieImage);
        movieName.setText(mName);

        playButton.setOnClickListener(view -> {
            Intent i = new Intent(MovieDetails.this, VideoPlayerActivity.class);
            i.putExtra("url", mName);
            startActivity(i);
        });
    }
}
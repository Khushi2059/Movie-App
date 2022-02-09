package com.example.movieapp.ui.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.movieapp.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

// TODO Need to work in this code, will do it later
public class VideoPlayerActivity extends AppCompatActivity {
    private PlayerView videoPlayer;
    private SimpleExoPlayer simpleExoPlayer;
    private SeekBar mBrightnessSeekBar;
    private ImageView mBrightnessIcon;
    private LinearLayoutCompat mBrightnessSeekBarLinearLayoutCompat;
    private static final int BRIGHTNESS_MIN_VALUE = 0;
    private static final int BRIGHTNESS_MAX_VALUE = 255;
    private static final int BRIGHTNESS_PROGRESS_INCREMENT = 1;
    private static int brightness = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        videoPlayer = findViewById(R.id.exo_player);
        mBrightnessSeekBar = findViewById(R.id.brightnessSeekBar);
        mBrightnessIcon = findViewById(R.id.brightnessIcon);
        mBrightnessSeekBarLinearLayoutCompat=findViewById(R.id.brightnessSeekBarLayoutCompat);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        initializeBrightnessControlSeekbarHeight();
        initializeInitialBrightnessOfSeekbar(preferences);

        setUpExoPlayer(getIntent().getStringExtra("url"));
        mBrightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int videoPlayerBrightness, boolean fromUser) {
                 brightness = videoPlayerBrightness;

                changeOfBrightnessIconWithProgress(videoPlayerBrightness);

                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = videoPlayerBrightness / (float) 255;
                getWindow().setAttributes(layoutParams);
                editor.putInt("BrightnessSeekBarProgressKey", mBrightnessSeekBar.getProgress());
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    private void changeOfBrightnessIconWithProgress(int videoPlayerBrightness) {
        if (videoPlayerBrightness >= BRIGHTNESS_MIN_VALUE && videoPlayerBrightness < BRIGHTNESS_MAX_VALUE / 2) {
            mBrightnessIcon.setBackgroundResource(R.drawable.ic_brightness_low);
        } else if (videoPlayerBrightness > BRIGHTNESS_MAX_VALUE / 2 && videoPlayerBrightness < BRIGHTNESS_MAX_VALUE) {
            mBrightnessIcon.setBackgroundResource(R.drawable.ic_brightness_med);
        } else if (videoPlayerBrightness == BRIGHTNESS_MAX_VALUE) {
            mBrightnessIcon.setBackgroundResource(R.drawable.ic_brightness_full);
        }
    }

    private void initializeInitialBrightnessOfSeekbar(SharedPreferences preferences) {
        try {
            ContentResolver contentResolver;
            contentResolver = this.getContentResolver();
            mBrightnessSeekBar.setMax(BRIGHTNESS_MAX_VALUE);
            mBrightnessSeekBar.setKeyProgressIncrement(BRIGHTNESS_PROGRESS_INCREMENT);

            brightness = preferences.getInt("BrightnessSeekBarProgressKey", Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS));
            mBrightnessSeekBar.setProgress(brightness);
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.screenBrightness = brightness / (float) 255;
            getWindow().setAttributes(layoutParams);

        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initializeBrightnessControlSeekbarHeight() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        int screenHeight = outMetrics.heightPixels;
        mBrightnessSeekBar.getLayoutParams().width = screenHeight / 4;
    }


    private void setUpExoPlayer(String url) {
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
        videoPlayer.setPlayer(simpleExoPlayer);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "movieapp"));
        MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse("https://www.youtube.com/watch?v=07d2dXHYb94"));
        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);
    }

    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }
}
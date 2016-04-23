package com.example.jberger.moonwalker;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import org.ligi.axt.AXT;

/**
 * Created by jberger on 23/04/16.
 */
public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AXT.at(IntroActivity.this).startCommonIntent().activityFromClass(MapsActivity.class);
            }
        });

        final TextView textView = (TextView) findViewById(R.id.introText);
        Handler handler = new Handler();

        textView.setVisibility(View.GONE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.VISIBLE);
            }
        }, 5000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.GONE);
            }
        }, 10000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText("join the Apollo team");
                textView.setVisibility(View.VISIBLE);
            }
        }, 15000);

        VideoView videoView = (VideoView) findViewById(R.id.video);
        String uriPath = "android.resource://com.example.jberger.moonwalker/raw/rocket_launch";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.start();

        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                vibrator.vibrate(3500);
            }
        }, 8000);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                AXT.at(IntroActivity.this).startCommonIntent().activityFromClass(MapsActivity.class);
            }
        });
    }
}

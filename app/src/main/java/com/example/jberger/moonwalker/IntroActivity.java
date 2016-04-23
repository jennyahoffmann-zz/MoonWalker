package com.example.jberger.moonwalker;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

/**
 * Created by jberger on 23/04/16.
 */
public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        VideoView videoView = (VideoView) findViewById(R.id.video);
        String uriPath = "android.resource://com.example.jberger.moonwalker/raw/rocket_launch";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.start();

    /*    new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AXT.at(IntroActivity.this).startCommonIntent().activityFromClass(MapsActivity.class);
            }
        }, 3000);*/
    }
}

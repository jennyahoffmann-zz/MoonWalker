package com.example.jberger.moonwalker;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.ligi.axt.AXT;

/**
 * Created by jberger on 23/04/16.
 */
public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AXT.at(IntroActivity.this).startCommonIntent().activityFromClass(MapsActivity.class);
            }
        }, 3000);
    }
}

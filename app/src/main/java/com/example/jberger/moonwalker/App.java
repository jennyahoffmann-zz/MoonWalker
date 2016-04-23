package com.example.jberger.moonwalker;

import android.app.Application;

/**
 * Created by jberger on 23/04/16.
 */
public class App extends Application {

    public static GameLocationProvider locationProvider;

    @Override
    public void onCreate() {
        super.onCreate();
        locationProvider = new FakeGameLocationProvider();
    }
}

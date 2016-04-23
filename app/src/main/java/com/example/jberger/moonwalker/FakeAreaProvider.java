package com.example.jberger.moonwalker;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by jberger on 23/04/16.
 */
public class FakeAreaProvider implements GameAreaProvider {

    @NonNull
    private ArrayList<POI> getPois() {
        ArrayList<POI> latLngs = new ArrayList<>();
        latLngs.add(new POI(new LatLng(52.5109273, 13.4107171), "Mission1"));
        latLngs.add(new POI(new LatLng(52.5079723, 13.4217567), "Mission2"));
        return latLngs;
    }

    @Override
    public Area getArea(int num) {
        return new Area(getPois(), R.drawable.moon_surface);
    }
}

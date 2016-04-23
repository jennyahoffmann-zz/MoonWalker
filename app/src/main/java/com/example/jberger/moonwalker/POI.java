package com.example.jberger.moonwalker;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by jberger on 23/04/16.
 */
public class POI {
    public final LatLng coordinate;
    public final String name;

    public POI(LatLng coordinate, String name) {
        this.coordinate = coordinate;
        this.name = name;
    }
}

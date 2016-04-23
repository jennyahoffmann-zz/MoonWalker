package com.example.jberger.moonwalker;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by jberger on 23/04/16.
 */
public class FakeGameLocationProvider implements GameLocationProvider {
    @Override
    public LatLng getLatLng() {
        return new LatLng(52.5129992, 13.4178927);
    }
}

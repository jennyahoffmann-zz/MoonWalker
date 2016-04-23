package com.example.jberger.moonwalker;

import java.util.List;

/**
 * Created by jberger on 23/04/16.
 */
public class Area {

    public final List<POI> getLatLng;
    public final int image;

    public Area(List<POI> getLatLng, int image) {
        this.getLatLng = getLatLng;
        this.image = image;
    }
}

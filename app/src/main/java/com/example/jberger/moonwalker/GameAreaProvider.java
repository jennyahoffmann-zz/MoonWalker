package com.example.jberger.moonwalker;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by jberger on 23/04/16.
 */
public interface GameAreaProvider {

    public Area getArea(int num);

    public ArrayList<LatLng> getExtend(int num);

}

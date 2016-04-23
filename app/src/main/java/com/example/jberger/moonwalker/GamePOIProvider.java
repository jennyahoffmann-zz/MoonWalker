package com.example.jberger.moonwalker;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by jberger on 23/04/16.
 */
public interface GamePOIProvider {

    public List<POI> getLatLng();

}

package com.example.jberger.moonwalker;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jberger on 23/04/16.
 */
public class FakePOIProvider implements GamePOIProvider {
    @Override
    public List<POI> getLatLng() {
        ArrayList<POI> latLngs = new ArrayList<>();
        latLngs.add(new POI(new LatLng(52.5109273, 13.4107171), "Mission1"));
        latLngs.add(new POI(new LatLng(52.5079723, 13.4217567), "Mission2"));
        return latLngs;
    }
}

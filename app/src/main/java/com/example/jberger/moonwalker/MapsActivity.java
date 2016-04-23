package com.example.jberger.moonwalker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MarkerOptions astronautMarker;
    private Marker realAstronautMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final LatLngBounds.Builder builder = new LatLngBounds.Builder();

        LatLng home = App.locationProvider.getLatLng();
        Area area = App.poiProvider.getArea(0);
        List<POI> Apollo11MissionLocation = area.getLatLng;

        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        GroundOverlayOptions newarkMap = groundOverlayOptions;
        groundOverlayOptions.image(getScaleAstronautImage(area.image));
        groundOverlayOptions.transparency(0.5f);

        setAstronautMarker(home);
        builder.include(home);
        for (POI latLng : Apollo11MissionLocation) {
            MarkerOptions poiMarker = new MarkerOptions().position(latLng.coordinate).title(latLng.name);
            mMap.addMarker(poiMarker);
            builder.include(latLng.coordinate);
        }

        final LatLngBounds bounds = builder.build();
        groundOverlayOptions.positionFromBounds(bounds);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
        mMap.addGroundOverlay(groundOverlayOptions);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                float dimension = getResources().getDimension(R.dimen.mapPadding);
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        realAstronautMarker.remove();
                        setAstronautMarker(marker.getPosition());
                        return true;
                    }
                });
                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, Math.round(dimension)));
            }
        }, 200);

    }

    private void setAstronautMarker(LatLng home) {
        astronautMarker = new MarkerOptions().position(home).title("Landing Zone");
        astronautMarker.icon(getScaleAstronautImage(R.drawable.astronaut));
        realAstronautMarker = mMap.addMarker(astronautMarker);
    }

    @NonNull
    private BitmapDescriptor getScaleAstronautImage(int astronaut) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), astronaut);
        return BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(bitmap, 100, 100, true));
    }
}

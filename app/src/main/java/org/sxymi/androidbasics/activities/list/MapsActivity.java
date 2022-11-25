package org.sxymi.androidbasics.activities.list;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private final float ZOOM_WORLD = 1;
    private final float ZOOM_TERRAIN = 5;
    private final float ZOOM_CITY = 10;
    private final float ZOOM_STREETS = 15;
    private final float ZOOM_BUILDINGS = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng coordinates = new LatLng(51.94126879417907, 15.529084578007007);
        googleMap.addMarker(new MarkerOptions().position(coordinates).title("WIEA"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, this.ZOOM_STREETS));
    }
}
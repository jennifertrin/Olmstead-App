package com.example.android.treeinventoryapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String temp = "tel:" + 311;
        intent.setData(Uri.parse(temp));

        startActivity(intent);
    }

    public void onClick2(View v) {
        Uri uri = Uri.parse("https://goo.gl/forms/jlag73HpCPGaVp2u2");

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /*
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

        LatLngBounds Buffalo = new LatLngBounds(
                new LatLng(42.9244087, -78.89901), new LatLng(42.9327695, -78.806646));

        // Add a marker in Buffalo

        LatLng Tree1 = new LatLng(42.9312768, -78.86640726);
        mMap.addMarker(new MarkerOptions().position(Tree1).title("Willow").snippet("4th Largest").icon(BitmapDescriptorFactory.fromResource(R.drawable.tree)));
        LatLng Tree2 = new LatLng(42.88675282, -78.81427361);
        mMap.addMarker(new MarkerOptions().position(Tree2).title("Norway Maple").snippet("Largest").icon(BitmapDescriptorFactory.fromResource(R.drawable.tree)));
        LatLng Tree3 = new LatLng(42.95241738, -78.90857195);
        mMap.addMarker(new MarkerOptions().position(Tree3).title("Norway Maple").snippet("2nd Largest").icon(BitmapDescriptorFactory.fromResource(R.drawable.tree)));
        LatLng Tree4 = new LatLng(42.9530008, -78.90723775);
        mMap.addMarker(new MarkerOptions().position(Tree4).title("Norway Maple").snippet("3nd Largest").icon(BitmapDescriptorFactory.fromResource(R.drawable.tree)));
        LatLng Tree5 = new LatLng(42.96385396, -78.89681367);
        mMap.addMarker(new MarkerOptions().position(Tree5).title("Hackbery").snippet("5nd Largest").icon(BitmapDescriptorFactory.fromResource(R.drawable.tree)));
        LatLng Albright = new LatLng(42.9322243174, -78.8757);
        mMap.addMarker(new MarkerOptions().position(Albright).title("Albright-Knox Art Gallery").snippet("Art Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.historic)));
        LatLng Gas = new LatLng(42.8856986806, -78.8829);
        mMap.addMarker(new MarkerOptions().position(Gas).title("Buffalo Gas Light Company").snippet("Architecture").icon(BitmapDescriptorFactory.fromResource(R.drawable.historic)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Buffalo.getCenter(), 11));
        mMap.setLatLngBoundsForCameraTarget(Buffalo);
        mMap.setMyLocationEnabled(true);
    }

    }


package com.android.alucard.listviewmaps;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;

public class CountryFragment extends Fragment {

    GoogleMap myMap;
    MapView mMapView;

    TextView tvCountry;
    Button btBack;
    Fragment me = this;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_country, container, false);

//        MapsInitializer.initialize(this.getActivity());
//
//        try {
//            mMapView = view.findViewById(R.id.mapVieww);
//            mMapView.onCreate(savedInstanceState);
//            mMapView.getMapAsync(this);
//        } catch (InflateException e) {
//            e.getMessage();
//        }

        tvCountry = view.findViewById(R.id.tvCOuntry);
        btBack = view.findViewById(R.id.btClose);

        String country = getArguments().getString("country");

        tvCountry.setText(country);

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.co.in/maps?q=" + country));
        startActivity(i);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getFragmentManager().beginTransaction().remove(me).commit();
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        //mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //mMapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //mMapView.onResume();
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//    }
}

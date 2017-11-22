package com.example.gmlrj.mysns;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link MapFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link MapFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class MapFragment extends Fragment implements OnMapReadyCallback
    {
        private MapView mapView = null;

        public MapFragment()
        {
            // required
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_map, container, false);

            mapView = (MapView)layout.findViewById(R.id.map);
            mapView.getMapAsync(this);

            ImageButton bt_ar = (ImageButton) layout.findViewById(R.id.bt_ar);

            bt_ar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), ARActivity.class);
                    MapFragment.this.startActivity(intent);
                }
            });

            return layout;
        }

        @Override
        public void onStart() {
            super.onStart();
            mapView.onStart();
        }

        @Override
        public void onStop() {
            super.onStop();
            mapView.onStop();
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            mapView.onSaveInstanceState(outState);
        }

        @Override
        public void onResume() {
            super.onResume();
            mapView.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
            mapView.onPause();
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            mapView.onLowMemory();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mapView.onLowMemory();
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            //액티비티가 처음 생성될 때 실행되는 함수

            if(mapView != null)
            {
                mapView.onCreate(savedInstanceState);
            }
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng SEOUL = new LatLng(37.56, 126.97);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(SEOUL);
            markerOptions.title("서울");
            markerOptions.snippet("수도");
            googleMap.addMarker(markerOptions);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
        }
    }
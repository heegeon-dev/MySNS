package com.example.gmlrj.mysns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.app.Fragment;

import android.view.View;
import android.view.ViewGroup;

public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        return view;
    }
}
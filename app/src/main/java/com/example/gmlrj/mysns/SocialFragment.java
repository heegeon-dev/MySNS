package com.example.gmlrj.mysns;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;

import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SocialFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.social_fragment, container, false);
        ListView listview ;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter() ;

        listview = (ListView) view.findViewById(R.id.listView_sc);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_location),
                "Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_location),
                "Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_location),
                "Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_location),
                "Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_location),
                "Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_location),
                "Box", "Account Box Black 36dp") ;
        return view;
    }
}

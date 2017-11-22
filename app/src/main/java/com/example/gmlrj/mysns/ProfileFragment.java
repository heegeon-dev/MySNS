package com.example.gmlrj.mysns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.app.Fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        ImageButton bt_add = (ImageButton) view.findViewById(R.id.bt_add);

        ListView listView ;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter() ;

        listView = (ListView) view.findViewById(R.id.listview_pf);
        listView.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_location),
                "Box", "Account Box Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_back),
                "Circle", "Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_edit),
                "Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_people),
                "Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_search),
                "Ind", "Assignment Ind Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_setting),
                "Ind", "Assignment Ind Black 36dp") ;


        bt_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditActivity.class);
                ProfileFragment.this.startActivity(intent);
            }
        });
        return view;
    }
}
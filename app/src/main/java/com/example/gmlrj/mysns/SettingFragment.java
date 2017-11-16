package com.example.gmlrj.mysns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class SettingFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);

        ListView listview ;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter() ;

        listview = (ListView) view.findViewById(R.id.listview_st);
        listview.setAdapter(adapter);


        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_lock), "비밀번호 바꾸기") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_build), "개발자") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_build), "Setting") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_build), "Setting") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_build), "Setting") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_build), "Setting") ;

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if(position==0){
                    Intent intent = new Intent(getActivity(), ChangePWActivity.class);
                    SettingFragment.this.startActivity(intent);
                    Log.d("Intent Call","Call List" + position);
                }
                if(position==1){
                    Intent intent = new Intent(getActivity(), DeveloperActivity.class);
                    SettingFragment.this.startActivity(intent);
                    Log.d("Intent Call","Call List" + position);
                }
                Log.d("Item Click Event", "Click" + position);
            }
        });
        return view;
    }
}

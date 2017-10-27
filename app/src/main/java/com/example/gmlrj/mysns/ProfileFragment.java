package com.example.gmlrj.mysns;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        ImageButton bt_add = (ImageButton) view.findViewById(R.id.bt_add);

        bt_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditActivity.class);
                ProfileFragment.this.startActivity(intent);
            }
        });
        return view;
    }
}
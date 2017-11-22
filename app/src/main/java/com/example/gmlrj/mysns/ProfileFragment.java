package com.example.gmlrj.mysns;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfileFragment extends Fragment {

    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_TITLE = "title";
    private static final String TAG_TEXT = "text";

    JSONArray profiles = null;

    ArrayList<HashMap<String, String>> profileList;

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        list = (ListView) view.findViewById(R.id.listview_pf);
        profileList = new ArrayList<HashMap<String, String>>();
        getData("http:/172.31.42.158/connection.php"); //수정 필요

        ImageButton bt_add = (ImageButton) view.findViewById(R.id.bt_add);

//        ListView listView;
//        ListViewAdapter adapter;
//
//        adapter = new ListViewAdapter();
//
//        listView = (ListView) view.findViewById(R.id.listview_pf);
//        listView.setAdapter(adapter);
//
//        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_location),
//                "Box", "Account Box Black 36dp");
//        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_back),
//                "Circle", "Account Circle Black 36dp");
//        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_edit),
//                "Ind", "Assignment Ind Black 36dp");
//        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_people),
//                "Ind", "Assignment Ind Black 36dp");
//        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_search),
//                "Ind", "Assignment Ind Black 36dp");
//        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_setting),
//                "Ind", "Assignment Ind Black 36dp");


        bt_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditActivity.class);
                ProfileFragment.this.startActivity(intent);
            }
        });
        return view;
    }
    protected void showList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            profiles = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < profiles.length(); i++) {
                JSONObject c = profiles.getJSONObject(i);
                String title = c.getString(TAG_TITLE);
                String text = c.getString(TAG_TEXT);

                HashMap<String, String> profile = new HashMap<>();

                profile.put(TAG_TITLE, title);
                profile.put(TAG_TEXT, text);

                profileList.add(profile);
            }

            ListAdapter adapter = new SimpleAdapter(
                    ProfileFragment.this.getActivity(), profileList, R.layout.item,
                    new String[]{TAG_TITLE, TAG_TEXT},
                    new int[]{R.id.tv_title, R.id.tv_text}
            );

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }


            }

            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }

}

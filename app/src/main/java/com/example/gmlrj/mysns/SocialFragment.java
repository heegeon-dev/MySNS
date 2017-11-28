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

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.happy),
                "단국대 맛집", "단국대 앞 '해피덮' 대표 메뉴 연어 덮밥이에요") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.choi),
                "단국대 맛집", "단국대 앞 '최곱창' 야채곱창 맛있어요!") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.hanriver),
                "여의도 한강공원", "여기 불꽃놀이 보기에 딱 좋은 장소에요 추천!!") ;
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.jeju),
                "제주도 여행", "경치 좋은 제주도 여행지 추천합니당~") ;
        return view;
    }
}

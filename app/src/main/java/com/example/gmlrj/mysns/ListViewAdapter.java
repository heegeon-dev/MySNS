package com.example.gmlrj.mysns;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Item> listViewItemList = new ArrayList<Item>() ;

    public ListViewAdapter() {

    }

    private static final int ITEM_VIEW_TYPE_SOCIAL = 0 ;
    private static final int ITEM_VIEW_TYPE_SET = 1 ;
    private static final int ITEM_VIEW_TYPE_MAX = 2 ;


    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }
    @Override
    public int getViewTypeCount() {
        return ITEM_VIEW_TYPE_MAX ;
    }

    // position 위치의 아이템 타입 리턴.
    @Override
    public int getItemViewType(int position) {
        return listViewItemList.get(position).getType() ;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        int viewType = getItemViewType(position) ;


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            Item listViewItem = listViewItemList.get(position);

            switch (viewType) {
                case ITEM_VIEW_TYPE_SOCIAL:
                    convertView = inflater.inflate(R.layout.item, parent, false);
                    ImageView photoImageView = (ImageView) convertView.findViewById(R.id.iv_photo);
                    TextView titleTextView = (TextView) convertView.findViewById(R.id.tv_title) ;
                    TextView textTextView = (TextView) convertView.findViewById(R.id.tv_text) ;

                    photoImageView.setImageDrawable(listViewItem.getPhoto());
                    titleTextView.setText(listViewItem.getTitle());
                    textTextView.setText(listViewItem.getText());
                    break;
                case ITEM_VIEW_TYPE_SET:
                    convertView = inflater.inflate(R.layout.item2, parent, false);

                    ImageView imageImageView = (ImageView) convertView.findViewById(R.id.iv_image) ;
                    TextView menuTextView = (TextView) convertView.findViewById(R.id.tv_menu) ;

                    imageImageView.setImageDrawable(listViewItem.getImage());
                    menuTextView.setText(listViewItem.getMenu());
                    break;
            }
        }
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    public void addItem(Drawable photo, String title, String text) {
        Item item = new Item();

        item.setType(ITEM_VIEW_TYPE_SOCIAL);
        item.setPhoto(photo);
        item.setTitle(title);
        item.setText(text);

        listViewItemList.add(item);
    }

    public void addItem(Drawable image, String menu) {
        Item item = new Item();

        item.setType(ITEM_VIEW_TYPE_SET);
        item.setImage(image);
        item.setMenu(menu);

        listViewItemList.add(item);
    }
}

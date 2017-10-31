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
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.iv_image) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.tv_title) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.tv_text) ;

        Item listViewItem = listViewItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getImage());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getText());

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

    public void addItem(Drawable image, String title, String text) {
        Item item = new Item();

        item.setImage(image);
        item.setTitle(title);
        item.setText(text);

        listViewItemList.add(item);
    }
}

package com.example.gmlrj.mysns;

import android.graphics.drawable.Drawable;

public class Item {
    private Drawable image ;
    private String title ;
    private String text ;

    public void setImage(Drawable i) {
        image = i ;
    }
    public void setTitle(String t) {
        title = t ;
    }
    public void setText(String t) {
        text = t ;
    }

    public Drawable getImage() {
        return this.image ;
    }
    public String getTitle() {
        return this.title ;
    }
    public String getText() {
        return this.text ;
    }
}

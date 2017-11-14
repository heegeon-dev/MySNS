package com.example.gmlrj.mysns;

import android.graphics.drawable.Drawable;

public class Item {
    private int type;

    private Drawable photo ;
    private String title ;
    private String text ;

    private Drawable image;
    private String menu;

    public void setType(int type) { this.type = type ; }
    public void setPhoto(Drawable p) { photo = p ; }
    public void setTitle(String t) {
        title = t ;
    }
    public void setText(String t) {
        text = t ;
    }
    public void setImage(Drawable i) {
        image = i ;
    }
    public void setMenu(String m) { menu = m ; }

    public int getType() { return this.type ; }
    public Drawable getPhoto() {
        return this.photo ;
    }
    public String getTitle() {
        return this.title ;
    }
    public String getText() {
        return this.text ;
    }
    public Drawable getImage() {
        return this.image ;
    }
    public String getMenu() {
        return this.menu ;
    }
}

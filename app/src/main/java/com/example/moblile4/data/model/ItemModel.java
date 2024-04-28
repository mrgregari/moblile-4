package com.example.moblile4.data.model;

import android.graphics.drawable.Drawable;


public class ItemModel {
    private int imageField;
    private String textField;
    public ItemModel(String textField, int imageField) {
        this.textField = textField;
        this.imageField = imageField;
    }

    public String getTextfield() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }
    public Integer getImagefield() {return imageField;}
    public void setImageField(Integer imageField) {this.imageField = imageField;}
}
package com.rahulsrenj.phonebook.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table")
public class Contacts {
    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "contact_name")
    private String name;
    @ColumnInfo(name = "contact_num")
    private String num;
    @ColumnInfo(name = "contact_email")
    private String email;
    @ColumnInfo(name = "contact_favorite")
    private boolean isFavorite;
    @ColumnInfo(name = "contact_profile_pic")
    private String imageUri;

    public Contacts() {
    }

    public Contacts(int id, String name, String num, String email, boolean isFavorite,String imageUri) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.email = email;
        this.isFavorite = isFavorite;
        this.imageUri=imageUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}

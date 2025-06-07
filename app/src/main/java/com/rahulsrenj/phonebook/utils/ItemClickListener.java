package com.rahulsrenj.phonebook.utils;

import android.view.View;

import com.rahulsrenj.phonebook.database.Contacts;

public interface ItemClickListener {

    public void onItemClicked(View v, int pos, Contacts contacts);

}

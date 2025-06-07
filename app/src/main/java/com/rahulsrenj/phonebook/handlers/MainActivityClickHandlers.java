package com.rahulsrenj.phonebook.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.rahulsrenj.phonebook.activities.AddContactsActivity;

public class MainActivityClickHandlers {
    private Context context;

    public MainActivityClickHandlers(Context context)
    {
        this.context=context;
    }
    public void onFabClicked(View v){
        Intent intent=new Intent(context, AddContactsActivity.class);
        context.startActivity(intent);
    }
}

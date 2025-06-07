package com.rahulsrenj.phonebook.handlers;


import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
import com.rahulsrenj.phonebook.activities.MainActivity;
import com.rahulsrenj.phonebook.database.Contacts;

public class AddContactClickHandlers {
    private Context context;
    private ContactsViewModel viewModel;
    private Contacts contacts;
    private static final int PICK_IMAGE_REQUEST = 1;

    public AddContactClickHandlers(Context context, ContactsViewModel viewModel, Contacts contacts) {
        this.context = context;
        this.viewModel = viewModel;
        this.contacts = contacts;
    }
    public void onSaveCliked(View view){
        Log.d("check-now",contacts.getName() + ":"+contacts.getNum());
        if(contacts.getName()==null||contacts.getNum()==null){
            Toast.makeText(context, "Please fill the fields.", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(context, MainActivity.class);
            viewModel.addContact(contacts);
            context.startActivity(intent);
        }
    }

    public void onPhotoClicked(View v){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult((Activity) context,Intent.createChooser(intent,"Choose a picture"),PICK_IMAGE_REQUEST,null);
    }


}

package com.rahulsrenj.phonebook.handlers;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
import com.rahulsrenj.phonebook.activities.MainActivity;
import com.rahulsrenj.phonebook.database.Contacts;

public class UpdateContactClickHandlers {

    public Context context;
    public ContactsViewModel viewModel;
    public Contacts contacts;
    private static final int PICK_IMAGE_REQUEST = 1;

    public UpdateContactClickHandlers(Context context, ContactsViewModel viewModel, Contacts contacts) {
        this.context = context;
        this.viewModel = viewModel;
        this.contacts = contacts;
    }
    public void onUpdateClicked(View v){
        if(contacts.getNum()==null||contacts.getName()==null)
        {
            Toast.makeText(context, "Name and number cannot be left empty.", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(context, MainActivity.class);
            viewModel.updateContact(contacts);
            context.startActivity(intent);
        }
    }
    public void onDeleteClicked(View v){
        Intent intent=new Intent(context, MainActivity.class);
        viewModel.deleteContact(contacts);
        Toast.makeText(context, "Contact Deleted", Toast.LENGTH_SHORT).show();
        context.startActivity(intent);
    }
    public void onEditPhotoClicked(View v){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult((Activity) context,Intent.createChooser(intent,"Update your photo"),PICK_IMAGE_REQUEST,null);
    }
}

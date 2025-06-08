package com.rahulsrenj.phonebook.handlers;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;

import com.rahulsrenj.phonebook.activities.AddContactsActivity;
import com.rahulsrenj.phonebook.activities.UpdateContactActivity;
import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
import com.rahulsrenj.phonebook.activities.MainActivity;
import com.rahulsrenj.phonebook.database.Contacts;

public class UpdateContactClickHandlers {

    private Context context;
    private ContactsViewModel viewModel;
    private Contacts contacts;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    public UpdateContactClickHandlers(Context context, ContactsViewModel viewModel, Contacts contacts, ActivityResultLauncher<PickVisualMediaRequest> pickMedia) {
        this.context = context;
        this.viewModel = viewModel;
        this.contacts = contacts;
        this.pickMedia=pickMedia;
    }
    public void onUpdateClicked(View v){
        if(contacts.getNum()==null||contacts.getName()==null)
        {
            Toast.makeText(context, "Name and number cannot be left empty.", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            viewModel.updateContact(contacts);
            context.startActivity(intent);
        }
    }
    public void onDeleteClicked(View v){
        Intent intent=new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        viewModel.deleteContact(contacts);
        Toast.makeText(context, "Contact Deleted", Toast.LENGTH_SHORT).show();
        context.startActivity(intent);
    }
    public void onEditPhotoClicked(View v){
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                .build());
    }
}

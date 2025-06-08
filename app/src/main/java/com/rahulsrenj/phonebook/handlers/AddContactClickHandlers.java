package com.rahulsrenj.phonebook.handlers;

import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;

import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
import com.rahulsrenj.phonebook.activities.MainActivity;
import com.rahulsrenj.phonebook.database.Contacts;

public class AddContactClickHandlers {
    private Context context;
    private ContactsViewModel viewModel;
    private Contacts contacts;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    public AddContactClickHandlers(Context context, ContactsViewModel viewModel, Contacts contacts, ActivityResultLauncher<PickVisualMediaRequest> pickMedia) {
        this.context = context;
        this.viewModel = viewModel;
        this.contacts = contacts;
        this.pickMedia=pickMedia;
    }
    public void onSaveCliked(View view){
        Log.d("check-now",contacts.getName() + ":"+contacts.getNum());
        if(contacts.getName()==null||contacts.getNum()==null){
            Toast.makeText(context, "Please fill the fields.", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            viewModel.addContact(contacts);
            context.startActivity(intent);
        }
    }

    public void onPhotoClicked(View v) {
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                .build());
    }



}

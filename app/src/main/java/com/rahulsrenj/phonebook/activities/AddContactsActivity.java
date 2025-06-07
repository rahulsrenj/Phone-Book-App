package com.rahulsrenj.phonebook.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.rahulsrenj.phonebook.handlers.AddContactClickHandlers;
import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
import com.rahulsrenj.phonebook.R;
import com.rahulsrenj.phonebook.database.Contacts;
import com.rahulsrenj.phonebook.databinding.ActivityAddContactsBinding;

public class AddContactsActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Contacts contacts;
    private ActivityAddContactsBinding binding;
    private ContactsViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_add_contacts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        contacts=new Contacts();
        viewModel=new ViewModelProvider(this).get(ContactsViewModel.class);
        binding.setContacts(contacts);
        binding.setClickHandler(new AddContactClickHandlers(this,viewModel,contacts));



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data.getData()!=null){
            Uri imageUri=data.getData();
            binding.profilePic.setImageURI(imageUri);
            contacts.setImageUri(String.valueOf(imageUri));
        }

    }
}
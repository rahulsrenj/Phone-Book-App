package com.rahulsrenj.phonebook.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
import com.rahulsrenj.phonebook.R;
import com.rahulsrenj.phonebook.handlers.UpdateContactClickHandlers;
import com.rahulsrenj.phonebook.database.Contacts;
import com.rahulsrenj.phonebook.databinding.ActivityUpdateContactBinding;

public class UpdateContactActivity extends AppCompatActivity {
    private ActivityUpdateContactBinding binding;
    private String name,num,email;
    private int contact_id;
    private boolean isFavorite=false;
    private ContactsViewModel viewModel;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    private String imageProfile;

    private Contacts updatedContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent recvIntent = getIntent();
        contact_id = recvIntent.getIntExtra("contact_id", -1);
        name = recvIntent.getStringExtra("contact_name");
        num = recvIntent.getStringExtra("contact_num");
        email = recvIntent.getStringExtra("contact_email");
        isFavorite = recvIntent.getBooleanExtra("contact_favorite", false);
        imageProfile = recvIntent.getStringExtra("contact_profile");
        updatedContact = new Contacts(contact_id, name, num, email, false, imageProfile);
        viewModel = new ViewModelProvider(this).get(ContactsViewModel.class);
        pickMedia=registerForActivityResult(new ActivityResultContracts.PickVisualMedia(),uri->{
            if(uri!=null)
            {
                final int takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
                getContentResolver().takePersistableUriPermission(uri, takeFlags);

                binding.profilePic.setImageURI(uri);
                updatedContact.setImageUri(String.valueOf(uri));
            }
        });
        binding.setContacts(updatedContact);
        binding.setClickHandler(new UpdateContactClickHandlers(this, viewModel, updatedContact,pickMedia));

    }
}
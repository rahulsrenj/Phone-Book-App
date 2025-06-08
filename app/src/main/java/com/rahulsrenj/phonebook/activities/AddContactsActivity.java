package com.rahulsrenj.phonebook.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
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
    private Contacts contacts;
    private ActivityAddContactsBinding binding;
    private ContactsViewModel viewModel;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
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
        pickMedia=registerForActivityResult(new ActivityResultContracts.PickVisualMedia(),uri->{
            if(uri!=null)
            {
                final int takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
                getContentResolver().takePersistableUriPermission(uri, takeFlags);
                binding.profilePic.setImageURI(uri);
                contacts.setImageUri(String.valueOf(uri));
            }
        });
        binding.setContacts(contacts);
        binding.setClickHandler(new AddContactClickHandlers(this,viewModel,contacts,pickMedia));

    }


}
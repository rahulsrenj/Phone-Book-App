package com.rahulsrenj.phonebook.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rahulsrenj.phonebook.adapters.ContactListAdapter;
import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
import com.rahulsrenj.phonebook.utils.ItemClickListener;
import com.rahulsrenj.phonebook.R;
import com.rahulsrenj.phonebook.activities.UpdateContactActivity;
import com.rahulsrenj.phonebook.database.Contacts;
import com.rahulsrenj.phonebook.databinding.FragmentContactsBinding;

import java.util.ArrayList;
import java.util.List;


public class ContactsFragment extends Fragment {

    private FragmentContactsBinding binding;
    private ContactListAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Contacts> contactsArrayList=new ArrayList<>();
    private ContactsViewModel viewModel;
    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_contacts,container,false);
        recyclerView=binding.recyclerView;
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel=new ViewModelProvider(this).get(ContactsViewModel.class);
        adapter=new ContactListAdapter(requireContext(),contactsArrayList,viewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        viewModel.showAllContacts().observe(getViewLifecycleOwner(), new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                if(contacts.isEmpty()){
                    binding.recyclerView.setVisibility(View.GONE);
                    binding.noContactText.setVisibility(View.VISIBLE);
                }else{
                    binding.recyclerView.setVisibility(View.VISIBLE);
                    binding.noContactText.setVisibility(View.GONE);
                }
                contactsArrayList.clear();
                contactsArrayList.addAll(contacts);
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setClickListener(new ItemClickListener() {
            @Override
            public void onItemClicked(View v, int pos, Contacts contacts) {
                Log.d("check-now","Clicked");
                Intent intent=new Intent(getActivity(), UpdateContactActivity.class);
                intent.putExtra("contact_id",contacts.getId());
                intent.putExtra("contact_name",contacts.getName());
                intent.putExtra("contact_num",contacts.getNum());
                intent.putExtra("contact_email",contacts.getEmail());
                intent.putExtra("contact_favorite",contacts.isFavorite());
                intent.putExtra("contact_profile",contacts.getImageUri());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
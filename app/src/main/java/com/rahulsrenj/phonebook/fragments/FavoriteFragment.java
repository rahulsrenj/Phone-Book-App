package com.rahulsrenj.phonebook.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
import com.rahulsrenj.phonebook.adapters.FavoriteListAdapter;
import com.rahulsrenj.phonebook.R;
import com.rahulsrenj.phonebook.database.Contacts;
import com.rahulsrenj.phonebook.databinding.FragmentFavoriteBinding;

import java.util.ArrayList;
import java.util.List;


public class FavoriteFragment extends Fragment {
    private FragmentFavoriteBinding binding;
    private FavoriteListAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Contacts> favoriteArrayList=new ArrayList<>();
    private ContactsViewModel viewModel;
    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_favorite,container,false);
        recyclerView=binding.recyclerView;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        adapter=new FavoriteListAdapter(requireContext(),favoriteArrayList);
        viewModel=new ViewModelProvider(this).get(ContactsViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        viewModel.showFavorites().observe(getViewLifecycleOwner(), new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                if(contacts.isEmpty()){
                    binding.noContacts.setVisibility(View.VISIBLE);
                    binding.recyclerView.setVisibility(View.GONE);
                }
                else{
                    binding.noContacts.setVisibility(View.GONE);
                    binding.recyclerView.setVisibility(View.VISIBLE);
                }
                favoriteArrayList.clear();
                favoriteArrayList.addAll(contacts);
                adapter.notifyDataSetChanged();
            }
        });
        recyclerView.setAdapter(adapter);
    }

}
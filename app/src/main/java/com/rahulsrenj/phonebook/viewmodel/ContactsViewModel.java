package com.rahulsrenj.phonebook.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rahulsrenj.phonebook.database.Contacts;
import com.rahulsrenj.phonebook.database.Repository;

import java.util.List;

public class ContactsViewModel extends AndroidViewModel {
    private final Repository repository;
    public ContactsViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
    }
    public void addContact(Contacts contacts){
        repository.addContact(contacts);
    }
    public void updateContact(Contacts contacts){
        repository.updateContact(contacts);
    }
    public void deleteContact(Contacts contact){
        repository.deleteContact(contact);
    }
    public LiveData<List<Contacts>> showAllContacts(){
        return repository.showAllContacts();
    }
    public LiveData<List<Contacts>> showFavorites(){
        return repository.showFavorites();
    }

    //UI Logic
    public void toggleFavorite(Contacts contacts){
        if(contacts.isFavorite()){
            contacts.setFavorite(false);
        }
        else{
            contacts.setFavorite(true);
        }
        repository.updateContact(contacts);
    }
}

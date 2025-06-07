package com.rahulsrenj.phonebook.database;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

public class Repository {
    private final ContactsDao contactsDao;
    private final ExecutorService executor;

    public Repository(Application application)
    {
        ContactDatabase contactDatabase = ContactDatabase.getContactDatabase(application);
        contactsDao= contactDatabase.getContactsDao();
        executor= Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
    }
    public void addContact(Contacts contacts)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDao.addContact(contacts);
            }
        });
    }
    public void updateContact(Contacts contacts)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDao.updateContact(contacts);
            }
        });
    }
    public void deleteContact(Contacts contacts)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDao.deleteContact(contacts);
            }
        });
    }
    public LiveData<List<Contacts>> showAllContacts(){
        return contactsDao.showAllContacts();
    }
    public LiveData<List<Contacts>> showFavorites(){
        return contactsDao.showFavorites();
    }

}

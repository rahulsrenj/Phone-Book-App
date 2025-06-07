package com.rahulsrenj.phonebook.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactsDao {

    @Insert
    void addContact(Contacts contacts);
    @Update
    void updateContact(Contacts contacts);
    @Delete
    void deleteContact(Contacts contacts);
    @Query("SELECT * FROM contacts_table ORDER BY contact_name ASC")
    LiveData<List<Contacts>> showAllContacts();
    @Query("SELECT * FROM contacts_table WHERE contact_favorite = 1 ORDER BY contact_name ASC")
    LiveData<List<Contacts>> showFavorites();

}

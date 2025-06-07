package com.rahulsrenj.phonebook.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class},version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    private static ContactDatabase dbInstance;
    public abstract ContactsDao getContactsDao();

    public static synchronized ContactDatabase getContactDatabase(Context context){
        if(dbInstance==null){
            dbInstance= Room.databaseBuilder(context, ContactDatabase.class,"contacts_db").build();
        }
        return dbInstance;
    }

}

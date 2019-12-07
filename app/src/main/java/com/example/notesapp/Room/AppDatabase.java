package com.example.notesapp.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Note.class, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseAccess getNoteDAO();
}

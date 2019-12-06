package com.example.notesapp.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface DatabaseAccess {
    @Insert
    public void addNote(Note note);

    @Query("Select * from notes")
    public List<Note> getNotes();

    @Update
    public void updateData(Note note);

    @Delete
    public void deleteData(Note note);

    @Query("SELECT * FROM notes WHERE id = :id")
    public Note getItemById(int id);
}
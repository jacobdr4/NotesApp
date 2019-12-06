package com.example.notesapp.Room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import android.os.Bundle;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "notes")
public class Note implements Serializable {
    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "text")
    private String text;

    public Note(String title, String text, int id) {
        this.title = title;
        this.text = text;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int i) {
        id = i;
    }
    public String getText() {
        return text;
    }
    public void setText(String t) {
        text = t;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String t) {
        title = t;
    }
    public String toString() {
        return id + ": " + title + "\n" + text;
    }
}

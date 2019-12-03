package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;

@Entity
public final class Note {
    private String title;
    private String text;
    @PrimaryKey
    private int id;

    public Note(String setTitle) {
        title = setTitle;
        text = "";
        id = 0;
    }
    public void setText(String t) {
        text = t;
    }
}

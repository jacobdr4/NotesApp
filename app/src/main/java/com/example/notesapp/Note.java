package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public final class Note {
    private String title;
    private String text;

    public Note(String setTitle) {
        title = setTitle;
        text = "";
    }
    public void setText(String t) {
        text = t;
    }
}

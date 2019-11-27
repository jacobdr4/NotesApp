package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setUpUI();
    }

    public void setUpUI() {
        //TEST: Add 10 notes to list of notes
        ArrayList<Note> noteList = new ArrayList<Note>();
        for (int i = 0; i < 20; i++) {
            noteList.add(new Note(i + "rd Note"));
        }

        //Create list of buttons to scroll through
        LinearLayout buttonList = findViewById(R.id.buttonList);
        for (int i = 0; i < noteList.size(); i++) {
            View buttonChunk = getLayoutInflater().inflate(R.layout.chunk_note,
                    buttonList, false);
            Button noteButton = buttonChunk.findViewById(R.id.noteTitleButton);
            noteButton.setText("Note: " + (i + 1));

            buttonList.addView(buttonChunk);
        }
    }
}

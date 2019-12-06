package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        for (int i = 0; i < noteList.size() + 1; i++) {
            View buttonChunk = getLayoutInflater().inflate(R.layout.chunk_note,
                    buttonList, false);
            Button noteButton = buttonChunk.findViewById(R.id.noteTitleButton);

            //Adds the new note button or note button
            if (i == 0) {
                noteButton.setText("New Note");
                noteButton.setOnClickListener(unused -> newNoteButtonClicked());
            } else {
                noteButton.setText("Note: " + i);
                final String noteCtr = "Note: " + i;
                noteButton.setOnClickListener(unused -> noteButtonClicked(noteCtr));
            }
            buttonList.addView(buttonChunk);
        }
    }

    private void newNoteButtonClicked() {
        LinearLayout buttonList = findViewById(R.id.buttonList);
        View buttonChunk = getLayoutInflater().inflate(R.layout.chunk_note,
                buttonList, false);
        Button noteButton = buttonChunk.findViewById(R.id.noteTitleButton);
        noteButton.setText("Recently Added Note");
        noteButton.setOnClickListener(unused -> noteButtonClicked("Recently Added"));
        buttonList.addView(buttonChunk);
    }

    private void noteButtonClicked(String noteID) {
        Intent intent = new Intent(this, NoteDisplay.class);
        intent.putExtra("noteID", noteID);
        startActivity(intent);
    }
}

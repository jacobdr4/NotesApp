package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.notesapp.Room.DatabaseAccess;
import com.example.notesapp.Room.Note;

import java.util.ArrayList;
import java.util.List;

import static com.example.notesapp.MainActivity.appDatabase;

public class Menu extends AppCompatActivity {
    //Initialize the Room Database
    DatabaseAccess noteDAO = appDatabase.getNoteDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        List<Note> noteList = noteDAO.getNotes();

        //deleteData(noteList);
        //noteList = noteDAO.getNotes();

        setUpUI(noteList);
    }

    public void deleteData(List<Note> noteList) {
        //USE THIS WHEN DEMOING APP - DELETES ALL NOTES
        for (int i = 0; i < noteList.size(); i++) {
            noteDAO.deleteData(noteList.get(i));
        }
    }

    public void setUpUI(List<Note> noteList) {
        //Create new note button
        Button newNoteButton = findViewById(R.id.newNoteButton);
        newNoteButton.setOnClickListener(unused -> newNoteButtonClicked(noteList));

        //System.out.println(noteList);
        //System.out.println("Notelist size: " + noteList.size());

        //Create actual notes buttons
        LinearLayout buttonList = findViewById(R.id.buttonList);
        for (int i = 0; i < noteList.size(); i++) {
            //System.out.println("Button Made");
            View buttonChunk = getLayoutInflater().inflate(R.layout.chunk_note,
                    buttonList, false);
            Button noteButton = buttonChunk.findViewById(R.id.noteTextButton);
            noteButton.setText(noteList.get(i).getTitle());
            final int noteID = noteList.get(i).getId();
            noteButton.setOnClickListener(unused -> noteButtonClicked(noteID));
            buttonList.addView(buttonChunk);
        }
    }

    private void newNoteButtonClicked(List<Note> noteList) {
        LinearLayout buttonList = findViewById(R.id.buttonList);
        View buttonChunk = getLayoutInflater().inflate(R.layout.chunk_note,
                buttonList, false);

        //Add note to list, create new button and change title text
        //FOR SOME REASON, WHEN THE NOTE IS FIRST CREATED IT HAS AN ID OF 42?!?!?! OR 47??!
        noteList.add(new Note("Note #" + (noteList.size() + 1),"Edit Text Here", noteList.size() + 1));
        Button noteButton = buttonChunk.findViewById(R.id.noteTextButton);
        noteButton.setText(noteList.get(noteList.size() - 1).getTitle());

        //Test dis shit
        //System.out.println("Note0: " + noteList.get(0));
        System.out.println(noteList);
        System.out.println("Notelist size: " + noteList.size());

        //Create onClickListener
        int noteID = noteList.get(noteList.size() - 1).getId();
        System.out.println("NoteID: " + noteID);

        //Add note to Room
        noteDAO.addNote(noteList.get(noteList.size() - 1));
        System.out.println("Note successfully added to DAO");

        noteButton.setOnClickListener(unused -> noteButtonClicked(noteID));

        buttonList.addView(buttonChunk);
    }

    private void noteButtonClicked(int noteID) {
        System.out.println("Note Clicked");
        Intent intent = new Intent(this, NoteDisplay.class);
        intent.putExtra("noteID", noteID);
        startActivity(intent);
        finish();
    }
}

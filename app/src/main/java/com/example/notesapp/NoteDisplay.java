package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NoteDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_display);

        Intent intent = getIntent();
        String id = intent.getStringExtra("noteID");

        TextView title = findViewById(R.id.noteTitle);
        title.setText(id);

        EditText text = findViewById(R.id.noteText);
        text.setText(id);
    }
}

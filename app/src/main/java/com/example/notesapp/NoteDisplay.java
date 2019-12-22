package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.notesapp.Room.DatabaseAccess;
import com.example.notesapp.Room.Note;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.notesapp.MainActivity.appDatabase;

public class NoteDisplay extends AppCompatActivity {
    private Note receivedNote;
    private EditText text;
    private EditText title;
    private DatabaseAccess noteDAO = appDatabase.getNoteDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_display);

        noteDAO = appDatabase.getNoteDAO();

        System.out.println("Note Display Started");

        //Receive the note of the button that was clicked
        Intent intent = getIntent();

        //THIS IS NULL FOR SOME REASON WHEN FIRST RUN!
        receivedNote = noteDAO.getItemById(intent.getIntExtra("noteID", 0));

        System.out.println("Note data received");
        System.out.println("Received note = "  + receivedNote);

        //Display note info
        text = findViewById(R.id.noteText);
        text.setText(receivedNote.getText());

        title = findViewById(R.id.titleText);
        title.setText(receivedNote.getTitle());

        System.out.println("Note data displayed");

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(unused -> deleteButtonPressed());
    }

    public void deleteButtonPressed() {
        // receivedNote.setDisplay(false);
        // noteDAO.updateData(receivedNote);
        int deletedId = receivedNote.getId();
        noteDAO.deleteData(receivedNote);

        // Change ID's of existing notes
        List<Note> noteList = noteDAO.getNotes();
        for (int i = deletedId-1; i < noteList.size(); i++) {
            Note current = noteList.get(i);
            current.setId(current.getId() - 1);
        }
        List<Note> oldList = noteDAO.getNotes();
        for (int i = deletedId-1; i < oldList.size(); i++) {
            noteDAO.deleteData(oldList.get(i));
        }
        for (int i = deletedId-1; i < noteList.size(); i++) {
            noteDAO.addNote(noteList.get(i));
        }
        /*
        for (Note note: noteDAO.getNotes()) {
            noteDAO.deleteData(note);
        }
        for (Note note: noteList) {
            noteDAO.addNote(note);
        }
         */

        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        System.out.println("Back Button Pressed");

        //Save text in textbox to note, send note to database
        receivedNote.setText(text.getText().toString());
        receivedNote.setTitle(title.getText().toString());

        //Put the new note in the DAO
        noteDAO = appDatabase.getNoteDAO();
        noteDAO.updateData(receivedNote);

        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }
}

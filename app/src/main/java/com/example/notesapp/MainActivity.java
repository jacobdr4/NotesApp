package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.notesapp.Room.AppDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public static AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Import Room database
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "notes").allowMainThreadQueries().build();

        //Start da app!!
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }

}

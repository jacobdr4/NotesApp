package com.example.notesapp;

// import androidx.room.Entity;
// import androidx.room.PrimaryKey;

// import android.content.res.Resources;

// @Entity
public final class Note {
    private String title;
    private String text;
    // @PrimaryKey
    private int id;

    public Note(String setTitle) {
        title = setTitle;
        text = "";
        id = 0;
    }
    public void setText(String t) {
        text = t;
    }

    /*
    public int[] getDimensions() {
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        return new int[] {width, height};
    }
     */
}

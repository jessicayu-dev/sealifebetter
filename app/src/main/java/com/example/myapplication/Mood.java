package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mood_table")
public class Mood {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int mood;

    private String entry;

    private String diary;

    public Mood(int mood, String entry, String diary) {
        this.mood = mood;
        this.entry = entry;
        this.diary = diary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getMood() {
        return mood;
    }

    public String getEntry() {
        return entry;
    }

    public String getDiary() {
        return diary;
    }
}

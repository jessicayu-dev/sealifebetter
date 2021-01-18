package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mood_table")
public class Mood {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String moodValue;

    private final String entry;

    private final String log;

    public Mood(String moodValue, String entry, String log) {
        this.moodValue = moodValue;
        this.entry = entry;
        this.log = log;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMoodValue() {
        return moodValue;
    }

    public String getEntry() {
        return entry;
    }

    public String getLog() {
        return log;
    }
}

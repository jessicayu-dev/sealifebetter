package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MoodDao {

    @Insert
    void insert(Mood mood);

    @Update
    void update(Mood mood);

    @Delete
    void delete(Mood mood);

    @Query("SELECT * FROM mood_table ORDER BY id")
    LiveData<List<Mood>> getAllMoods();

}

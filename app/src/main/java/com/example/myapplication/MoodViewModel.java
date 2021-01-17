package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MoodViewModel extends AndroidViewModel {
    private MoodRepository repository;
    private LiveData<List<Mood>> allMoods;

    public MoodViewModel(@NonNull Application application) {
        super(application);

        repository = new MoodRepository(application);
        allMoods = repository.getAllMoods();
    }

    public void insert(Mood mood) {
        repository.insert(mood);
    }

    public void update(Mood mood) {
        repository.update(mood);
    }

    public void delete(Mood mood) {
        repository.delete(mood);
    }

    public LiveData<List<Mood>> getAllMoods() {
        return allMoods;
    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MoodViewModel moodViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MoodViewModel.class);

        moodViewModel.getAllMoods().observe(this, new Observer<List<Mood>>() {
            @Override
            public void onChanged(List<Mood> moods) {
                //Get information here...
            }
        });
    }
}
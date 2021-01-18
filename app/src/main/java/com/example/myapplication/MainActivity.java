package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MoodViewModel moodViewModel;

    Button startSurvey;
    TextView nameDisplay;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String NAME = "name";
    public static final String NAME_INPUTTED = "name_inputted";

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameDisplay = findViewById(R.id.namedisplay);
        nameDisplay.setText("Hello, " + name + "...");

        getNameFirstTimeOnly(preferences);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final MoodAdapter adapter = new MoodAdapter();
        recyclerView.setAdapter(adapter);

        moodViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MoodViewModel.class);

        //Get information here...
        moodViewModel.getAllMoods().observe(this, adapter::setMoods);

        startSurvey = findViewById(R.id.startsurvey);
        startSurvey.setOnClickListener(v -> {
            startSurvey();
        });
    }

    public void getNameFirstTimeOnly(SharedPreferences preferences) {
        if(!preferences.getBoolean(NAME_INPUTTED, false)) {
            Intent intent = new Intent(MainActivity.this, NameInput.class);
            startActivityForResult(intent, 1);
        }
        else {
            getData(preferences);
        }
    }

    public void getData(SharedPreferences sharedPreferences) {
        name = sharedPreferences.getString(NAME, "");
    }

    public void startSurvey() {
        Intent intent = new Intent(MainActivity.this, MoodSurvey.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                assert data != null;
                editor.putString(NAME, data.getStringExtra("name"));
                editor.putBoolean(NAME_INPUTTED, true);
                editor.apply();

                name = data.getStringExtra("name");
                nameDisplay.setText("Hello, " + name + "...");
            }
            else if(resultCode == RESULT_CANCELED) {
                finish();
            }
        }

        else if(requestCode == 2) {
            if(resultCode == RESULT_OK) {
                assert data != null;
                Mood mood = new Mood(data.getStringExtra("moodValue"),
                        data.getStringExtra("entryText"),
                        data.getStringExtra("logText"));
                moodViewModel.insert(mood);
            }
        }
    }
}
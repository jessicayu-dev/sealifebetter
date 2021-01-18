package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MoodSurvey extends AppCompatActivity {
    RadioGroup moodMeter;
    RadioButton button1, button2, button3, button4, button5;
    EditText entry, log;
    Button submit;

    int b1, b2, b3, b4, b5;
    String moodValue = "Neutral", entryText = null, logText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_survey);

        setupViews();

        editTextWatchers();

        submit.setOnClickListener(v -> {
            if(entryText != null && logText != null) {
                Intent intent = new Intent();

                intent.putExtra("moodValue", moodValue);
                intent.putExtra("entryText", entryText);
                intent.putExtra("logText", logText);

                setResult(RESULT_OK, intent);

                finish();
            }
            else {
                Toast.makeText(this, "Please tell us your mood today!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setupViews() {
        moodMeter = findViewById(R.id.mood_meter);
        button1 = findViewById(R.id.mood_1);
        button2 = findViewById(R.id.mood_2);
        button3 = findViewById(R.id.mood_3);
        button4 = findViewById(R.id.mood_4);
        button5 = findViewById(R.id.mood_5);
        entry = findViewById(R.id.mood_entry);
        log = findViewById(R.id.mood_log);
        submit = findViewById(R.id.mood_submit);

        b1 = button1.getId();
        b2 = button2.getId();
        b3 = button3.getId();
        b4 = button4.getId();
        b5 = button5.getId();
    }

    public void editTextWatchers() {
        entry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!entry.getText().toString().equals("")) {
                    entryText = entry.getText().toString();
                }
                else {
                    entryText = null;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        log.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!log.getText().toString().equals("")) {
                    logText = log.getText().toString();
                }
                else {
                    logText = null;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void checkedRButton(View v) {
        int radioId = moodMeter.getCheckedRadioButtonId();
        if(radioId == b1) {
            Toast.makeText(this, "Very Bad", Toast.LENGTH_SHORT).show();
            moodValue = "Very Bad";
        }
        else if(radioId == b2) {
            Toast.makeText(this, "Bad", Toast.LENGTH_SHORT).show();
            moodValue = "Bad";
        }
        else if(radioId == b3) {
            Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show();
            moodValue = "Neutral";
        }
        else if(radioId == b4) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            moodValue = "OK";
        }
        else if(radioId == b5) {
            Toast.makeText(this, "Great", Toast.LENGTH_SHORT).show();
            moodValue = "Great";
        }
    }
}
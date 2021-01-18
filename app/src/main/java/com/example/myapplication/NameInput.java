package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameInput extends AppCompatActivity {

    EditText nameField;
    Button submitName;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        setUpViews();

        submitName.setOnClickListener(v -> {
            if(!nameField.getText().toString().equals("")) {
                name = nameField.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name", name);
                setResult(RESULT_OK, intent);

                finish();
            }
        });

    }

    private void setUpViews() {
        nameField = findViewById(R.id.nameEditText);
        submitName = findViewById(R.id.submitName);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
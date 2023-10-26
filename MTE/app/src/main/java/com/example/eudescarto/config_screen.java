package com.example.eudescarto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class config_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);

        ImageButton myButton = findViewById(R.id.imageViewChevron);
        myButton.setBackgroundResource(R.drawable.button_selector);

        myButton.setOnClickListener(v -> {
            finish();
        });
    }
}
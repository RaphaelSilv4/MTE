package com.example.eudescarto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton myButton = findViewById(R.id.imageView3);
        myButton.setBackgroundResource(R.drawable.button_selector);

        ImageButton myButton2 = findViewById(R.id.imageView15);
        myButton.setBackgroundResource(R.drawable.button_selector);

        myButton.setOnClickListener(v -> {
            Intent intent = new Intent(profile.this, bonus_screen.class);
            startActivity(intent);
        });

        myButton2.setOnClickListener(v -> {
            Intent intent = new Intent(profile.this, config_screen.class);
            startActivity(intent);
        });
    }
}
package com.example.eudescarto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class bonus_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_screen);

        ImageButton myButton = findViewById(R.id.imageViewChevron);
        myButton.setBackgroundResource(R.drawable.button_selector);

        myButton.setOnClickListener(v -> {
            Intent intent = new Intent(bonus_screen.this, profile.class);
            startActivity(intent);
        });

    }
}
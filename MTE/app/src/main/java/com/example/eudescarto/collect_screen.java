package com.example.eudescarto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class collect_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_screen);

        ImageButton myButton = findViewById(R.id.imageViewChevron);
        myButton.setBackgroundResource(R.drawable.button_selector);

        ImageButton myButton2 = findViewById(R.id.imageView12);
        myButton.setBackgroundResource(R.drawable.button_selector);

        ImageButton myButton3 = findViewById(R.id.imageView15);
        myButton.setBackgroundResource(R.drawable.button_selector);

        Button myButton5 = findViewById(R.id.button2);
        myButton.setBackgroundResource(R.drawable.button_selector);

        Button myButton4 = findViewById(R.id.button3);
        myButton.setBackgroundResource(R.drawable.button_selector);

        myButton.setOnClickListener(v -> {
            Intent intent = new Intent(collect_screen.this, profile.class);
            startActivity(intent);
        });

        myButton2.setOnClickListener(v -> {
            Intent intent = new Intent(collect_screen.this, profile.class);
            startActivity(intent);
        });

        myButton3.setOnClickListener(v -> {
            Intent intent = new Intent(collect_screen.this, config_screen.class);
            startActivity(intent);
        });

        myButton4.setOnClickListener(v -> {
            Intent intent = new Intent(collect_screen.this, collect_next.class);
            startActivity(intent);
        });

        myButton5.setOnClickListener(v -> {
            Intent intent = new Intent(collect_screen.this, collect_residence.class);
            startActivity(intent);
        });
    }
}
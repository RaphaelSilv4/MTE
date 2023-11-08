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

        ImageButton imageViewInput1 = findViewById(R.id.imageViewInput1);
        imageViewInput1.setBackgroundResource(R.drawable.button_selector);

        ImageButton imageViewInput2 = findViewById(R.id.imageViewInput2);
        imageViewInput2.setBackgroundResource(R.drawable.button_selector);

        ImageButton imageViewInputConfig = findViewById(R.id.imageViewInputConfig);
        imageViewInputConfig.setBackgroundResource(R.drawable.button_selector);

        imageViewInput1.setOnClickListener(v -> {
            Intent intent = new Intent(profile.this, bonus_screen.class);
            startActivity(intent);
        });

        imageViewInputConfig.setOnClickListener(v -> {
            Intent intent = new Intent(profile.this, config_screen.class);
            startActivity(intent);
        });

        imageViewInput2.setOnClickListener(v -> {
            Intent intent = new Intent(profile.this, collect_screen.class);
            startActivity(intent);
        });
    }
}
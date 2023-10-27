package com.example.eudescarto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class collect_residence extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_residence);

        ImageButton myButton = findViewById(R.id.imageViewChevron);
        myButton.setBackgroundResource(R.drawable.button_selector);

        ImageButton myButton2 = findViewById(R.id.imageView12);
        myButton.setBackgroundResource(R.drawable.button_selector);

        ImageButton myButton3 = findViewById(R.id.imageView15);
        myButton.setBackgroundResource(R.drawable.button_selector);

        myButton.setOnClickListener(v -> {
            finish();
        });

        myButton2.setOnClickListener(v -> {
            Intent intent = new Intent(collect_residence.this, profile.class);
            startActivity(intent);
        });

        myButton3.setOnClickListener(v -> {
            Intent intent = new Intent(collect_residence.this, config_screen.class);
            startActivity(intent);
        });
    }
}
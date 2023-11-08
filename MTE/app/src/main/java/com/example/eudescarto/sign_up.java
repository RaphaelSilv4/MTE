package com.example.eudescarto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button buttonLoginAccount = findViewById(R.id.buttonLoginAccount);
        buttonLoginAccount.setBackgroundResource(R.drawable.button_selector);

        buttonLoginAccount.setOnClickListener(v -> {
            Intent intent = new Intent(sign_up.this, MainActivity.class);
            startActivity(intent);
        });

        Button buttonNewAccount = findViewById(R.id.buttonNewAccount);
        buttonNewAccount.setBackgroundResource(R.drawable.button_selector);

        buttonNewAccount.setOnClickListener(v -> {
            Intent intent = new Intent(sign_up.this, profile.class);
            startActivity(intent);
        });

    }
}
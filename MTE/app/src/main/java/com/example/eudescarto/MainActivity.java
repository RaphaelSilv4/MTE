package com.example.eudescarto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNewAccount = findViewById(R.id.buttonNewAccount);
        buttonNewAccount.setBackgroundResource(R.drawable.button_selector);

        buttonNewAccount.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, sign_up.class);
            startActivity(intent);
        });

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setBackgroundResource(R.drawable.button_selector);

        buttonLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, profile.class);
            startActivity(intent);
        });
    }
}
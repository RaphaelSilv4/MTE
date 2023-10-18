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

        Button meuBotao = findViewById(R.id.button2);
        meuBotao.setBackgroundResource(R.drawable.button_selector);

        meuBotao.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, sign_up.class);
            startActivity(intent);
        });
    }
}
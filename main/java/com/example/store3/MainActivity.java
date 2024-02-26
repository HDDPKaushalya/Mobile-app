package com.example.store3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Blogin,Bsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Blogin = findViewById(R.id.Blogin);
        Bsignup = findViewById(R.id.Bsignup);

        Blogin.setOnClickListener(view -> {
            Intent Blogin = new Intent(getApplicationContext(),Login.class);
            startActivity(Blogin);
        });

        Bsignup.setOnClickListener(view -> {
            Intent Bsignup = new Intent(getApplicationContext(),Signup.class);
            startActivity(Bsignup);

        });

    }

}
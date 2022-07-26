package com.izampa.assignment.three;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button navigator = findViewById(R.id.navigator_one);
        navigator.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
            MainActivity.this.startActivity(myIntent);
        });
    }
}
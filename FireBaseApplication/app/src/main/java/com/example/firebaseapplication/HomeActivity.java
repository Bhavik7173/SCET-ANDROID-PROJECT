package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        text1 = findViewById(R.id.txtView);
        Intent intent = getIntent();
        String name = intent.getStringExtra("msg");
        Log.d("gisurat",name);
        text1.setText("Welcome " + name);
    }
}
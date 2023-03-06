package com.example.demoapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayNameActivity extends AppCompatActivity {

    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_name);
        name = findViewById(R.id.nameTxt);
        Intent intent = getIntent();
        String uname = intent.getStringExtra("name");
        name.setText("Hi "+ uname);
        String umob = intent.getStringExtra("mobile");
        Toast.makeText(this, umob, Toast.LENGTH_SHORT).show();
    }
}
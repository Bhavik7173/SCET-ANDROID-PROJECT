package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView title;
    SharedPreferences sharedPreferences;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = getSharedPreferences("User Details",MODE_PRIVATE);
        name = sharedPreferences.getString("Name",null);
        title = findViewById(R.id.title);
        title.setText("Welcome "+name);
    }
}
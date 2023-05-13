package com.example.textileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    CardView omLayout, radheyLayout, settingLayout, riyalayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        omLayout = findViewById(R.id.om_layout);
        riyalayout = findViewById(R.id.riya_layout);
        radheyLayout = findViewById(R.id.radhey_layout);
        settingLayout = findViewById(R.id.setting_layout);
        omLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OmActivity.class);
                startActivity(intent);
            }
        });
        radheyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OmActivity.class);
                startActivity(intent);
            }
        });
        riyalayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OmActivity.class);
                startActivity(intent);
            }
        });
        settingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OmActivity.class);
                startActivity(intent);
            }
        });
    }

}
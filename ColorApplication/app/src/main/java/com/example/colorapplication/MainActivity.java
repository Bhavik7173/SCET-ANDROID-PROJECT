package com.example.colorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner colorsp;
    String color[] = {"RED", "BLUE", "GREEN", "YELLOW"};
    LinearLayout linearLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorsp = findViewById(R.id.colorsspinner);
        linearLayout = findViewById(R.id.llayout);
        colorsp.setOnItemSelectedListener(this);
        ArrayAdapter ad
                = new ArrayAdapter(this,android.R.layout.simple_spinner_item,color);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        colorsp.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0)
        {
            linearLayout.setBackgroundColor(Color.RED);
        } else if (i==1) {
            linearLayout.setBackgroundColor(Color.BLUE);
        } else if (i==2) {
            linearLayout.setBackgroundColor(Color.GREEN);
        } else if (i==3) {
            linearLayout.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp;
    String color[] = {"RED","YELLOW","GREY","GREEN","BLUE"};
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = findViewById(R.id.cspinner);
        linearLayout = findViewById(R.id.layout);
        sp.setOnItemSelectedListener(this);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,color);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("demo","Position : " + i);
        if(i==0)
        {
            linearLayout.setBackgroundColor(Color.RED);
        } else if (i==1) {
            linearLayout.setBackgroundColor(Color.YELLOW);
        } else if (i==2) {
            linearLayout.setBackgroundColor(Color.GRAY);
        } else if (i==3) {
            linearLayout.setBackgroundColor(Color.GREEN);
        } else if (i==4) {
            linearLayout.setBackgroundColor(Color.BLUE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
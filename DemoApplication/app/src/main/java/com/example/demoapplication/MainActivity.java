package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //called when activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test","on create method");
        Toast.makeText(MainActivity.this,"OnCreate Method",Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"OnCreate Method",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"OnCreate Method",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","on start method");
        Toast.makeText(MainActivity.this,"OnStart Method",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test","on resume method");
        Toast.makeText(MainActivity.this,"onResume Method",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","on Pause method");
        Toast.makeText(MainActivity.this,"OnPause Method",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","on stop method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test","on restart method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","on destroy method");
    }
}
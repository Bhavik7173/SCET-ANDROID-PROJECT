package com.example.dempapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sub;
    EditText name;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sub = findViewById(R.id.submitBtn);
        name = findViewById(R.id.edt1);


//        Toast.makeText(MainActivity.this, uname, Toast.LENGTH_LONG).show();
//        sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                uname = name.getText().toString();
//                Log.d("scet",uname);
//                Toast.makeText(MainActivity.this, uname , Toast.LENGTH_LONG).show();
//            }
//        });
    }

    public void addTask(View v) {
        uname = name.getText().toString();
        Log.d("scet", uname);
        Toast.makeText(getApplicationContext(), uname, Toast.LENGTH_LONG).show();
    }
}
package com.example.dailogapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    Button datebtn, alertBtn, timeBtn;
    TextView datetxt, alerttxt, timetxt;
    int day, month, year, hour, min, sec;
    AlertDialog.Builder alertdailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datebtn = findViewById(R.id.dateBtn);
        alerttxt = findViewById(R.id.alertTxt);
        alertBtn = findViewById(R.id.alertBtn);
        datetxt = findViewById(R.id.dateTxt);
        timeBtn = findViewById(R.id.timeBtn);
        timetxt = findViewById(R.id.timeTxt);

        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);

                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Log.d("scet_log", i + "\t" + i1+1 + "\t" + i2);
                        int mon = Integer.parseInt(String.valueOf(i1))+1;
                        datetxt.setText(i+"/"+mon+"/"+i2);
                    }
                }, year, month, day);
                datePicker.show();
            }
        });

        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertdailog = new AlertDialog.Builder(MainActivity.this);
                alertdailog.setMessage("Do You want to exit?");
                alertdailog.setCancelable(false);
                alertdailog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Toast.makeText(MainActivity.this, "Click on Yes Button", Toast.LENGTH_SHORT).show();
                    }
                });
                alertdailog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(MainActivity.this, "Click on No Button", Toast.LENGTH_SHORT).show();
                    }
                });
                alertdailog.setIcon(R.drawable.ic_launcher_background);
                AlertDialog alert = alertdailog.create();
                alert.setTitle("Exit DailogBox");
                alert.show();
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                min = calendar.get(Calendar.MINUTE);
                sec = calendar.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(MainActivity.this, ""+i+":"+i1, Toast.LENGTH_SHORT).show();
                        timetxt.setText(i+":"+i1);
                    }
                }, hour, min,true);
                timePickerDialog.show();
            }
        });
    }
}
package com.example.myapplication;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {

    Button submit;
    EditText number;
    TextView textView;
    int mul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        submit = findViewById(R.id.submit);
        number = findViewById(R.id.numberEdt);
        textView = findViewById(R.id.printTable);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer stringBuffer = new StringBuffer();
                String value = number.getText().toString();
                for(int i=1;i<11;i++)
                {
                    mul = Integer.parseInt(value) * i;
                    stringBuffer.append(value + " * " + i + " = " + mul + "\n\n");
                    Log.d("demo",mul+"");

                }
                textView.setText(stringBuffer);
            }
        });
    }
}
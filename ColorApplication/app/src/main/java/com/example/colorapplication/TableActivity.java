package com.example.colorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {

    Button submit;
    TextView display;
    EditText number;
    double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        submit = findViewById(R.id.getTable);
        display = findViewById(R.id.tableTxt);
        number = findViewById(R.id.edt);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer buffer = new StringBuffer();
                String tableno = number.getText().toString();
                for (int i = 1; i < 11; i++) {
                    sum = i * Double.parseDouble(tableno);
                    buffer.append(Double.parseDouble(tableno) + " * " + i + " = " + sum + "\n\n");
                }
                display.setText(buffer);

            }
        });
    }
}
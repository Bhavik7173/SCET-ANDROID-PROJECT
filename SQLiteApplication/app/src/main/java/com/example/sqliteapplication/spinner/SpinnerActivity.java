package com.example.sqliteapplication.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sqliteapplication.R;

import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edit1;
    Button add;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spin = findViewById(R.id.spinner);
        add = findViewById(R.id.addBtn);
        edit1 = findViewById(R.id.inputEdt);

        spin.setOnItemSelectedListener(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = edit1.getText().toString();
                DataBaseHandler db = new DataBaseHandler(getApplicationContext());
                db.insertItem(item);
                edit1.setText("");
                loadSpinnerData();
            }
        });
        loadSpinnerData();
    }

    private void loadSpinnerData() {
        DataBaseHandler databaseHandler = new DataBaseHandler(getApplicationContext());
        List<String> item = databaseHandler.getAllItems();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameEdt, contactEdt, emailEdt;
    Button submitBtn, resetBtn;
    RecyclerView recyclerView;
    String name, phone, email;
   ArrayList<ContactModel> contactModel;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdt = findViewById(R.id.unameEdt);
        contactEdt = findViewById(R.id.ucontactEdt);
        emailEdt = findViewById(R.id.uemailEdt);

        resetBtn = findViewById(R.id.resetBtn);
        submitBtn = findViewById(R.id.submiBtn);

        recyclerView = findViewById(R.id.rcv);
        contactModel = new ArrayList<>();
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEdt.setText("");
                contactEdt.setText("");
                emailEdt.setText("");
            }
        });
        editData();
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameEdt.getText().toString();
                phone = contactEdt.getText().toString();
                email = emailEdt.getText().toString();

                contactModel.add(new ContactModel(name,phone,email));
                ContactAdapter contactAdapter  = new ContactAdapter(MainActivity.this,contactModel);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(contactAdapter);
                contactAdapter.notifyItemInserted(contactModel.size());

                nameEdt.setText("");
                contactEdt.setText("");
                emailEdt.setText("");
                submitBtn.setText("SUBMIT");
            }
        });
    }
    private void editData() {
        if (getIntent().getBundleExtra("contact_detail") != null) {
            Bundle bundle = getIntent().getBundleExtra("contact_detail");

            nameEdt.setText(bundle.getString("name"));
            contactEdt.setText(bundle.getString("contact"));
            emailEdt.setText(bundle.getString("email"));

            submitBtn.setText("Edit");
            //submit.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
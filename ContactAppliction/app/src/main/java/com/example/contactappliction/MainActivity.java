package com.example.contactappliction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText nameEdt, contactEdt, emailEdt;
    Button submit, reset;
    RecyclerView recyclerView;
    String name, phone, email;
    ArrayList<ContactModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setID();
        arrayList = new ArrayList<>();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEdt.setText("");
                contactEdt.setText("");
                emailEdt.setText("");
            }
        });
        updateDetails();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameEdt.getText().toString();
                phone = contactEdt.getText().toString();
                email = emailEdt.getText().toString();

                arrayList.add(new ContactModel(name, phone, email));
                ContactAdapter contactAdapter = new ContactAdapter(MainActivity.this, arrayList);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(contactAdapter);
                contactAdapter.notifyItemInserted(arrayList.size());

                nameEdt.setText("");
                contactEdt.setText("");
                emailEdt.setText("");
                submit.setText("Submit");
            }
        });
    }

    private void updateDetails() {
        if (getIntent().getBundleExtra("contact_detail") != null) {
            Bundle bundle = getIntent().getBundleExtra("contact_detail");
            nameEdt.setText(bundle.getString("name"));
            contactEdt.setText(bundle.getString("contact"));
            emailEdt.setText(bundle.getString("email"));
            submit.setText("Update");
        }
    }

    private void setID() {
        nameEdt = findViewById(R.id.unameEdt);
        contactEdt = findViewById(R.id.ucontactEdt);
        emailEdt = findViewById(R.id.uemailEdt);

        submit = findViewById(R.id.submiBtn);
        reset = findViewById(R.id.resetBtn);
        recyclerView = findViewById(R.id.rcv);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
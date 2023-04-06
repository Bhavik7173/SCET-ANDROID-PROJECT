package com.example.linkifyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText email, mob;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView helpdeskTextView = findViewById(R.id.helpdesk_text_view);
        email = findViewById(R.id.emailEdt);
        mob = findViewById(R.id.mobEdt);
        submit = findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String helpdeskEmail = email.getText().toString();
                String helpdeskPhoneNumber = mob.getText().toString();

                helpdeskTextView.setText("Email: " + helpdeskEmail + "\nPhone: " + helpdeskPhoneNumber);

                Pattern emailPattern = Pattern.compile(helpdeskEmail);
                Linkify.addLinks(helpdeskTextView,emailPattern,"mailto:");

                Pattern phonePattern = Pattern.compile(helpdeskPhoneNumber);
                Linkify.addLinks(helpdeskTextView, phonePattern, "tel:");
            }
        });
    }
}
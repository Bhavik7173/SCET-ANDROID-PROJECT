package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView signup;
    EditText emailEdt,passwordEdt;
    Button submitBtn;
    SharedPreferences sharedPreferences;
    String name,email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //read the from shared File


        sharedPreferences = getSharedPreferences("User Details",MODE_PRIVATE);
        signup = findViewById(R.id.text3);
        submitBtn = findViewById(R.id.b1);
        emailEdt = findViewById(R.id.text1);
        passwordEdt = findViewById(R.id.text2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailEdt.getText().toString();
                pass = passwordEdt.getText().toString();
                if(email.equals(sharedPreferences.getString("Email",null)) && pass.equals(sharedPreferences.getString("Password",null)))
                {
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
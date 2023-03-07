package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    EditText nameEdt, emailEdt, passEdt, mobileEdt, cpassEdt;
    Button submit, reset;
    String name, pass, email, mobile, cpass;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nameEdt = findViewById(R.id.nameEdt);
        mobileEdt = findViewById(R.id.mobEdt);
        emailEdt = findViewById(R.id.emailEdt);
        passEdt = findViewById(R.id.passEdt);
        cpassEdt = findViewById(R.id.cpassEdt);

        submit = findViewById(R.id.submitBtn);
        reset = findViewById(R.id.resetBtn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEdt.setText("");
                emailEdt.setText("");
                passEdt.setText("");
                mobileEdt.setText("");
                cpassEdt.setText("");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameEdt.getText().toString();
                mobile = mobileEdt.getText().toString();
                email = emailEdt.getText().toString();
                pass = passEdt.getText().toString();
                cpass = cpassEdt.getText().toString();

                int temp = 0;
                if(name.isEmpty())
                {
                    temp++;
                    nameEdt.setError("Please Enter Name!!");
                }
                if(mobile.isEmpty() || mobile.length()!=10)
                {
                    temp++;
                    mobileEdt.setError("Please Enter Mobile!!");
                }
                if(email.isEmpty())
                {
                    temp++;
                    emailEdt.setError("Please Enter Email!!");
                }
                if(pass.isEmpty())
                {
                    temp++;
                    passEdt.setError("Please Enter Password!!");
                }
                if(cpass.isEmpty())
                {
                    temp++;
                    cpassEdt.setError("Please Enter Confirm Password!!");
                }
                if(temp==0)
                {
                    if(pass.equals(cpass))
                    {
                        SharedPreferences sharedPreferences = getSharedPreferences("User Details",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Name",name);
                        editor.putString("Mobile",mobile);
                        editor.putString("Email",email);
                        editor.putString("Password",pass);
                        editor.commit();
                        Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
package com.example.firebaseauthenticate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText emailEdt,passwordEdt;
    Button registerBtn;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEdt = findViewById(R.id.email);
        passwordEdt = findViewById(R.id.passwd);
        registerBtn = findViewById(R.id.btnregister);
        progressBar = findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }
    public void registerUser()
    {
        String email,passsword;
        progressBar.setVisibility(View.VISIBLE);
        email = emailEdt.getText().toString();
        passsword = passwordEdt.getText().toString();

        if(email.isEmpty())
        {
            Toast.makeText(this, "Please Enter the email!!!", Toast.LENGTH_SHORT).show();
        }
        if(passsword.isEmpty())
        {
            Toast.makeText(this, "Please Enter the password!!!", Toast.LENGTH_SHORT).show();
        }

        mAuth.createUserWithEmailAndPassword(email,passsword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this, "Successfully Register", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            Log.d("gisurat",task.toString());
                        }
                    }
                });
    }
}
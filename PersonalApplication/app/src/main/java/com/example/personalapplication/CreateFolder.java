package com.example.personalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.personalapplication.retro.FileResponse;
import com.example.personalapplication.retro.RetroInterface;
import com.example.personalapplication.retro.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateFolder extends AppCompatActivity {

    Button submit;
    EditText folderName;
    RetrofitClient retroInterface;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_folder);

        submit = findViewById(R.id.submit);
        folderName = findViewById(R.id.folderEdt);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String packageName = folderName.getText().toString();
                retroInterface.getClient(CreateFolder.this).create(RetroInterface.class).create(packageName).enqueue(new Callback<FileResponse>() {
                    @Override
                    public void onResponse(Call<FileResponse> call, Response<FileResponse> response) {
                        Log.d("response_success", response.body().toString());
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(getApplicationContext(), MainActivity.class);
                            main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(main);
                        }
                    }

                    @Override
                    public void onFailure(Call<FileResponse> call, Throwable t) {
                        Log.d("response_fail", t.toString());
//                pimage.setText(t.toString());
                        Toast.makeText(getApplicationContext(), "Request failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
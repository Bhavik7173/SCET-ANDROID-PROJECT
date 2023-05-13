package com.example.contactjsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShowDetail extends AppCompatActivity {

    String name, contact, email, country;
    EditText nameEdt, contactEdt, emailEdt, countryEdt;
    Button editBtn, deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        contact = intent.getStringExtra("contact");
        email = intent.getStringExtra("email");
        country = intent.getStringExtra("country");

        nameEdt = findViewById(R.id.nameEdt);
        contactEdt = findViewById(R.id.contactEdt);
        emailEdt = findViewById(R.id.emailEdt);
        countryEdt = findViewById(R.id.nationEdt);
        editBtn = findViewById(R.id.editBtn);
        deleteBtn = findViewById(R.id.deleteBtn);

        nameEdt.setText(name);
        contactEdt.setText(contact);
        emailEdt.setText(email);
        countryEdt.setText(country);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = openFileInput("contact.json");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }

                    JSONObject obj = new JSONObject(stringBuilder.toString());
                    JSONArray jsonArray = obj.getJSONArray("contacts");

                    // Step 2: Traverse through the JSON array object and find the data that needs to be updated.
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String nName = jsonObject.getString("name");
                        if (name.equals(nName)) {
                            // Step 3: Update the data in the JSON array object.
                            jsonObject.put("name", nName);
                            break;
                        }
                    }

                    // Step 4: Write the updated JSON array object back to the file.
                    FileOutputStream fileOutputStream = openFileOutput("contact.json", Context.MODE_PRIVATE);
                    fileOutputStream.write(jsonArray.toString().getBytes());
                    fileOutputStream.close();
                    onBackPressed();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (JSONException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
                ;
    }
    private void enabled() {
        nameEdt.setEnabled(true);
        contactEdt.setEnabled(true);
        countryEdt.setEnabled(true);
        emailEdt.setEnabled(true);
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("contact.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
package com.example.contactjsonproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> contact = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();
    ArrayList<String> country = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named colors
            JSONArray userArray = obj.getJSONArray("contacts");
            // implement a loop to get colors list data
            for (int i = 0; i < userArray.length(); i++) {
                // create a JSONObject for fetching single color data
                JSONObject userDetail = userArray.getJSONObject(i);
                // fetch color name and category and store it in arraylist
                name.add(userDetail.getString("name"));
                contact.add(userDetail.getString("contact"));
                email.add(userDetail.getString("email"));
                country.add(userDetail.getString("country"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, name,contact,email,country);
        recyclerView.setAdapter(customAdapter);

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
}
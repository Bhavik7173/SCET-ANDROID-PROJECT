package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button fetchBtn;
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchBtn = findViewById(R.id.fetchData);
        databaseHandler = new DatabaseHandler(this);

        databaseHandler.addContact(new Contact("Bhavik","1234567899","101"));
        databaseHandler.addContact(new Contact("Kush","6358942136","102"));
        databaseHandler.addContact(new Contact("Kartik","1596321475","103"));
        databaseHandler.addContact(new Contact("Jash","9874563210","104"));
        databaseHandler.addContact(new Contact("Avi","7412589630","105"));

//        List<Contact> contacts = databaseHandler.getAllContact();
//        for(Contact contact: contacts)
//        {
//            String data= "ID :" + contact.getId() +"Contact Name : "+ contact.getName()+"Contact No :"+ contact.getMobile();
//            Log.d("scet",data);
//        }

        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Contact> contacts = databaseHandler.getAllContact();
                for(Contact contact: contacts)
                {
                    String data= "ID :" + contact.getId() +"Contact Name : "+ contact.getName()+"Contact No :"+ contact.getMobile();
                    Log.d("scet",data);
                }
            }
        });

    }
}
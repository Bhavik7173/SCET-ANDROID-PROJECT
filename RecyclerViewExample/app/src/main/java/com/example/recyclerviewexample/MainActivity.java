package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyData myData[];
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        myData = new MyData[]{
                new MyData("Email", android.R.drawable.ic_dialog_email),
                new MyData("Play", android.R.drawable.ic_media_play),
                new MyData("Pause", android.R.drawable.ic_media_pause),
                new MyData("Edit Menu", android.R.drawable.ic_menu_edit),
                new MyData("Delete", android.R.drawable.ic_delete),
                new MyData("Info", android.R.drawable.ic_dialog_info),
                new MyData("Map", android.R.drawable.ic_dialog_map)
        };

        MyDataAdapter mydatadapter  = new MyDataAdapter(myData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mydatadapter);
    }
}
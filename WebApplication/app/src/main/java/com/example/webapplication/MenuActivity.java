package com.example.webapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

public class MenuActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    Button popup, con;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        con = findViewById(R.id.con);
        popup = findViewById(R.id.popUp);
        registerForContextMenu(con);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuActivity.this, "Long Press on Button to show the context menu", Toast.LENGTH_SHORT).show();
            }
        });

        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MenuActivity.this,view);
                popupMenu.setOnMenuItemClickListener(MenuActivity.this);
                popupMenu.inflate(R.menu.pop_menu);
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, "PopUp Menu Selected Items", Toast.LENGTH_SHORT).show();
        switch (menuItem.getItemId())
        {
            case R.id.aboutus:
                Toast.makeText(this, "Selected Menu is About Us" , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.rateus:
                Toast.makeText(this, "Selected Menu is Rate Us" , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Toast.makeText(this, "Selected Menu is Logout" , Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(this, "Selected Menu is Search" , Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0,v.getId(),0,"Search");
        menu.add(0,v.getId(),0,"Rate Us");
        menu.add(0,v.getId(),0,"Logout");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "Selected Item is " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
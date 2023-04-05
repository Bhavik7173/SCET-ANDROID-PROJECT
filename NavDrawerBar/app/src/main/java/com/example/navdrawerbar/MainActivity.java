package com.example.navdrawerbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ListView listView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DataModel dataModel[];
    CharSequence mDrawerTitle, mTitle;
    String navMenuTitle[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        listView = findViewById(R.id.left_drawer);

        //ActionBar with DrawerBar Listerner
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerTitle = mTitle = getTitle();
        navMenuTitle = getResources().getStringArray(R.array.nav_menu);
        //Utilize the data on Drawer Layout
        dataModel = new DataModel[4];
        dataModel[0] = new DataModel(R.drawable.baseline_home_24, "Home");
        dataModel[1] = new DataModel(R.drawable.baseline_music_note_24, "Music");
        dataModel[2] = new DataModel(R.drawable.baseline_email_24, "Email");
        dataModel[3] = new DataModel(R.drawable.baseline_logout_24, "Logout");

        DrawerCustomAdapter drawerCustomAdapter = new DrawerCustomAdapter(this, R.layout.list_view_item_row, dataModel);
        listView.setAdapter(drawerCustomAdapter);
        listView.setOnItemClickListener(new DrawerItemClickListener());
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


    }

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            selectItem(i);
        }
    }

    private void selectItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                Log.d("scet", "Home Fragment");
                break;
            case 1:
                fragment = new MusicFragment();
                Log.d("scet", "Music Fragment");
                break;
            case 2:
                fragment = new EmailFragment();
                Log.d("scet", "Email Fragment");
                break;
            case 3:
                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.fragment_logout);

                TextView message = dialog.findViewById(R.id.message_text_view);
                Button yesBtn = dialog.findViewById(R.id.yes_button);
                Button noBtn = dialog.findViewById(R.id.no_button);
                dialog.show();
                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Log.d("scet", "Logout");
                drawerLayout.closeDrawer(listView);
                break;
            default:
                break;
        }
        if (fragment != null) {
            Log.d("scet_null", "Home Fragment");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            listView.setItemChecked(position, true);
            listView.setSelection(position);
            setTitle(navMenuTitle[position]);
            drawerLayout.closeDrawer(listView);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            Log.d("scet_action", item + "");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
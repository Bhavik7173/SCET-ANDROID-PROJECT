package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.navigationdrawer.adapter.DrawerItemCustomAdapter;
import com.example.navigationdrawer.fragment.ContactUsFragment;
import com.example.navigationdrawer.fragment.HomeFragment;
import com.example.navigationdrawer.fragment.LogoutFragment;
import com.example.navigationdrawer.fragment.RateUsFragment;
import com.example.navigationdrawer.fragment.TaskFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mNavigationDrawerItemTitles;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open_nav, R.string.close_nav);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DataModel[] drawerItem = new DataModel[5];

        drawerItem[0] = new DataModel(R.drawable.home, "Home");
        drawerItem[1] = new DataModel(R.drawable.task, "Manage Task");
        drawerItem[2] = new DataModel(R.drawable.rateus, "Rate Us");
        drawerItem[3] = new DataModel(R.drawable.contactus, "Contact Us");
        drawerItem[4] = new DataModel(R.drawable.logout, "Logout");

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            Log.d("scet_student", String.valueOf(item));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new TaskFragment();
                break;
            case 2:
                fragment = new RateUsFragment();
                break;
            case 3:
                fragment = new ContactUsFragment();
                break;
            case 4:
                fragment = new LogoutFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}
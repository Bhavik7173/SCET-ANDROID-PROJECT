package com.example.tabactivity.dynamicTabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tabactivity.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);

        // Initialize array list
        ArrayList<String> arrayList=new ArrayList<>(0);
        arrayList.add("Calls");
        arrayList.add("Status");
        arrayList.add("Chats");
        tabLayout.setupWithViewPager(viewPager);
        prepareViewPager(viewPager,arrayList);
    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        MainFragment mainFragment = new MainFragment();
        for(int i=0;i<arrayList.size();i++)
        {
            Bundle bundle = new Bundle();
            bundle.putString("title",arrayList.get(i));
            mainFragment.setArguments(bundle);
            tabAdapter.addFragment(mainFragment,arrayList.get(i));
            mainFragment = new MainFragment();
        }
        viewPager.setAdapter(tabAdapter);
    }
}
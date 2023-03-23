package com.example.imageapplication;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.imageapplication.fragment.CallFragment;
import com.example.imageapplication.fragment.ChatFragment;
import com.example.imageapplication.fragment.StatusFragment;

public class TabAdapter extends FragmentPagerAdapter {
    Context context;
    int tabcount;
    public TabAdapter(Context context, FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.context = context;
        this.tabcount = tabCount;
    }

    @Override
    public int getCount() {
        return tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                ChatFragment chatFragment = new ChatFragment();
                return chatFragment;
            case 1:
                StatusFragment statusFragment = new StatusFragment();
                return statusFragment;
            case 2:
                CallFragment callFragment = new CallFragment();
                return callFragment;
            default:
                return null;
        }
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}

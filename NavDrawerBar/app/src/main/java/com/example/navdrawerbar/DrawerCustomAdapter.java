package com.example.navdrawerbar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawerCustomAdapter extends ArrayAdapter<DataModel> {

    Context context;
    int layout;
    DataModel dataModel[];

    public DrawerCustomAdapter(Context context, int layout, DataModel[] dataModel) {
        super(context, layout, dataModel);
        this.context = context;
        this.layout = layout;
        this.dataModel = dataModel;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        view = layoutInflater.inflate(layout, parent, false);
        ImageView img = view.findViewById(R.id.imageViewIcon);
        TextView txt = view.findViewById(R.id.textViewName);

        DataModel folder = dataModel[position];
        img.setImageResource(folder.icon);
        txt.setText(folder.name);

        return view;

    }
}

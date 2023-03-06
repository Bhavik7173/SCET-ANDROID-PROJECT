package com.example.recyclerviewexample;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.ViewHolder> {

    private MyData myData[];

    public MyDataAdapter(MyData[] myData) {
        this.myData = myData;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final MyData myList = myData[position];
        holder.desc.setText(myData[position].getDescription());
        holder.img.setImageResource(myData[position].getImg());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Click On " + myList.getDescription(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return myData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView desc;
        ImageView img;
        LinearLayout relativeLayout;

        public ViewHolder(View view) {
            super(view);
            this.relativeLayout = view.findViewById(R.id.relativelayout);
            this.img = view.findViewById(R.id.imageView);
            this.desc = view.findViewById(R.id.textView);
        }
    }
}

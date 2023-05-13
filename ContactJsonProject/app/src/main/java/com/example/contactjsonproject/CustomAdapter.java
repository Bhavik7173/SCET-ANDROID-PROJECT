package com.example.contactjsonproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<String> name;
    ArrayList<String> country;
    ArrayList<String> contact;
    ArrayList<String> email;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> name, ArrayList<String> contact, ArrayList<String> email, ArrayList<String> country) {
        this.contact = contact;
        this.country = country;
        this.name = name;
        this.email = email;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;

    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // set the data in items
        holder.name.setText("Name : "+name.get(position));
        holder.contact.setText("Contact : "+contact.get(position));
        holder.email.setText("Email : "+email.get(position));
        holder.country.setText("Country : "+country.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with color name on item click
                Toast.makeText(context, name.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        holder.arrowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ShowDetail.class);
                intent.putExtra("name",name.get(position));
                intent.putExtra("contact",contact.get(position));
                intent.putExtra("email",email.get(position));
                intent.putExtra("country",country.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("gilog",name.size()+"");
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, contact, email, country;// init the item view's
        ImageView arrowImg;
        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.nameEdt);
            contact = (TextView) itemView.findViewById(R.id.contactEdt);
            email = (TextView) itemView.findViewById(R.id.emailEdt);
            country = (TextView) itemView.findViewById(R.id.countryEdt);
            arrowImg = (ImageView) itemView.findViewById(R.id.arrowImg);

        }
    }

}

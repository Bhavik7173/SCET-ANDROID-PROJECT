package com.example.contactapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public ArrayList<ContactModel> contactModel;
    Context context;
    AlertDialog.Builder alertdailog;

    public ContactAdapter(Context context, ArrayList<ContactModel> contactModel) {
        this.contactModel = contactModel;
        this.context = context;
    }


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        final ContactModel myList = contactModel.get(position);
        holder.name.setText("Name: " + myList.getUname());
        holder.mob.setText(myList.getUcontact());
        holder.email.setText(myList.getUemail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Click On " + myList.getUname(), Toast.LENGTH_LONG).show();
            }
        });
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertdailog = new AlertDialog.Builder(context);
                alertdailog.setMessage("Do You want to exit?");
                alertdailog.setCancelable(false);
                alertdailog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        contactModel.remove(holder.getPosition());
                        notifyDataSetChanged();
                        Toast.makeText(context, "Click on Yes Button", Toast.LENGTH_SHORT).show();
                    }
                });
                alertdailog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(context, "Click on No Button", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = alertdailog.create();

                alert.show();
            }
        });

        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("name", myList.getUname());
                bundle.putString("contact", myList.getUcontact());
                bundle.putString("email", myList.getUemail());

                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("contact_detail", bundle);
                Log.d("gilog",bundle+"");
                context.startActivity(intent);

            }
        });
    }



    @Override
    public int getItemCount() {
        return contactModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, mob, email;
        CardView cardView;
        Button editBtn, deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameEdt);
            mob = itemView.findViewById(R.id.mobEdt);
            email = itemView.findViewById(R.id.emailEdt);
            cardView = itemView.findViewById(R.id.cardlayout);
            editBtn = itemView.findViewById(R.id.editBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }

}

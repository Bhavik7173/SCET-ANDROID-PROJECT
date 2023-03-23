package com.example.imageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button selectBtn;
    ImageView img;
    int Select_Picture = 300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectBtn = findViewById(R.id.pictureButton);
        img = findViewById(R.id.imgView);
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });
    }

    private void imageChooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),Select_Picture);

    }
    public void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            if(requestCode == Select_Picture)
            {
                Uri imageView = data.getData();
                img.setImageURI(imageView);
            }
        }
    }
}
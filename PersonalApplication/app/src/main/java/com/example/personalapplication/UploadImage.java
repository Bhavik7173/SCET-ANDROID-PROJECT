package com.example.personalapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.personalapplication.retro.FileResponse;
import com.example.personalapplication.retro.FolderResponse;
import com.example.personalapplication.retro.PathModel;
import com.example.personalapplication.retro.RetroInterface;
import com.example.personalapplication.retro.RetrofitClient;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadImage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button uploadImg, chooseImg;
    EditText imgName;
    Spinner folderName;
    ImageView imgView;
    String imagePath, folderPath;
    File imageFile, folderNewPath;
    RetrofitClient retroInterface;
    String[] courses;
    ArrayList<FolderResponse> course;
    ArrayList<String> finalFolder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);

        uploadImg = findViewById(R.id.uploadBtn);
        chooseImg = findViewById(R.id.chooseBtn);
        imgView = findViewById(R.id.imgView);
        imgName = findViewById(R.id.nameEdt);
        folderName = findViewById(R.id.spinner);

        folderName.setOnItemSelectedListener(this);
        finalFolder = new ArrayList<>();
        setSpinnerData();

        chooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 0);
            }
        });
        uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage(folderPath);
            }
        });
    }

    private void setSpinnerData() {
        retroInterface.getClient(this).create(RetroInterface.class).fetchData().enqueue(new Callback<ArrayList<FolderResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<FolderResponse>> call, Response<ArrayList<FolderResponse>> response) {
                Log.d("response_success", response.body().toString());
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();
                    Log.d("gilog", response.body().toString());
                    course = response.body();
                    for(int i=0;i<course.size();i++)
                    {
                        finalFolder.add(course.get(i).getPackageName());
                    }
                    ArrayAdapter ad = new ArrayAdapter(UploadImage.this, android.R.layout.simple_spinner_item, finalFolder);
                    ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    folderName.setAdapter(ad);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FolderResponse>> call, Throwable t) {
                Log.d("response_fail", t.toString());
//                pimage.setText(t.toString());
                Toast.makeText(getApplicationContext(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadImage(String folderPath) {
        PathModel pathModel = new PathModel(folderPath);
        Toast.makeText(this, "" + folderPath, Toast.LENGTH_SHORT).show();
        Log.d("file__Path", imagePath);// Create a file using the absolute path of the image
        imageFile = new File(imagePath);
        folderNewPath = new File(folderPath);
        Log.d("gilog", folderNewPath + "");
        Log.d("file__", imageFile.getAbsolutePath());// Create a file using the absolute path of the image

        RequestBody reqBody = RequestBody.create(MediaType.parse("multipart/form-file"), imageFile);
        MultipartBody.Part partImage = MultipartBody.Part.createFormData("file", imageFile.getName(), reqBody);

//        String imagename = folderPath+ "/" +  imageFile;
//        RequestBody requestBody2 = RequestBody.create(MediaType.parse("*/*"), imageFile);
//        MultipartBody.Part imageupload = MultipartBody.Part.createFormData("companylogo", imagename, requestBody2);
//        RequestBody companylogo_request = RequestBody.create(MediaType.parse("text/plain"), imagename);


        retroInterface.getClient(this).create(RetroInterface.class).upload(pathModel, partImage).enqueue(new Callback<FileResponse>() {
            @Override
            public void onResponse(Call<FileResponse> call, Response<FileResponse> response) {
                Log.d("response_success", response.body().toString());
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();
                    Intent main = new Intent(getApplicationContext(), MainActivity.class);
                    main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(main);
                }
            }

            @Override
            public void onFailure(Call<FileResponse> call, Throwable t) {
                Log.d("response_fail", t.toString());
//                pimage.setText(t.toString());
                Toast.makeText(getApplicationContext(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(UploadImage.this, "Unable to choose file", Toast.LENGTH_SHORT).show();
                return;
            }
            Uri imageuri = data.getData();
            imagePath = getRealPathFromUri(imageuri);
            imgName.setText(imagePath);
            imgView.setImageURI(imageuri);
        }
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader cursorLoader = new CursorLoader(getApplicationContext(), uri, projection, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, course.get(i) + "", Toast.LENGTH_SHORT).show();
        folderPath = String.valueOf(course.get(i));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
package com.example.personalapplication.retro;


import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetroInterface {

    @Multipart
    @POST("upload")
    Call<FileResponse> upload(@Part("folderPath") PathModel folderPath, @Part MultipartBody.Part image);

//    @Multipart
//    @POST("upload.php")
//    Call<FileResponse> upload(@Part MultipartBody.Part image,@Part("companylogo") RequestBody companylogo_request);


    @GET("/create")
    Call<FileResponse> create(@Query("folder") String packageName);

    @GET("/fetchData")
    Call<ArrayList<FolderResponse>> fetchData();
}

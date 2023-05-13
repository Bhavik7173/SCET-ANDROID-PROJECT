package com.example.personalapplication.retro;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.110.195:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}

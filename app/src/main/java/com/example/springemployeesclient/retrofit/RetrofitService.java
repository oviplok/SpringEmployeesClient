package com.example.springemployeesclient.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    Retrofit retrofit;

    public RetrofitService(){
        intializeRetrofit();
    }

    private void intializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.94:9000")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}

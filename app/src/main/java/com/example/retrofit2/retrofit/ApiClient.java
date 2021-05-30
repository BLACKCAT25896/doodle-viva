package com.example.retrofit2.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://run.mocky.io/";     //https://jsonbin.io/60b2618a504bb717baf65d6b
    private static ApiClient mInstance;
    private Retrofit retrofit;

    private ApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiClient getInstance()
    {
        if (mInstance==null){
            mInstance = new ApiClient();
        }return mInstance;
    }
    public RetrofitInterface getApi(){
        return retrofit.create(RetrofitInterface.class);
    }


}


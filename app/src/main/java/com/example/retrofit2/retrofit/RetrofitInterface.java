package com.example.retrofit2.retrofit;

import com.example.retrofit2.JSONResponse;
import com.example.retrofit2.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {


    @GET("v3/08754fcc-ce3d-4801-be87-6f9b1ac45635")
    Call<JSONResponse> getCategories();


}
////https://api.jsonbin.io/b/60b2543432b631172658e20b
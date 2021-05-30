package com.example.retrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofit2.retrofit.ApiClient;
import com.example.retrofit2.retrofit.RetrofitInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RetrofitInterface retrofitInterface;
    private List<User> userList;
    private List<Category> categories;
    private UserAdapter adapter;
    private JSONResponse jsonResponse;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Doodle Inc Viva");


        init();
        getData();
    }

    private void getData() {
        retrofitInterface = ApiClient.getInstance().getApi();

        Call<JSONResponse> call = retrofitInterface.getCategories();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                 jsonResponse = response.body();
                categories = new ArrayList<>(Arrays.asList(jsonResponse.getCategories()));
                putDataIntoRecyclerView(categories);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });


    }

    private void putDataIntoRecyclerView(List<Category> categories) {
         categoryAdapter= new CategoryAdapter(this,categories);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         recyclerView.setAdapter(categoryAdapter);
    }

    private void init() {
        categories = new ArrayList<>();
        recyclerView = findViewById(R.id.userInfoRecyclerView);
    }
}
//https://run.mocky.io/v3/1dafc915-086a-44b4-b597-dcc8f70689e5



//https://run.mocky.io/v3/08754fcc-ce3d-4801-be87-6f9b1ac45635
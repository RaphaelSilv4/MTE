package com.example.eudescarto.retrofit;


import com.example.eudescarto.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAPI {
    @GET("/User")
    Call<List<User>> findAll();

    @
}

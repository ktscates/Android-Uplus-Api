package com.example.uplusapi;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiUtils {

    @POST("register")
    Call<Register> register();

    @POST("login")
    Call<Login> login();


}


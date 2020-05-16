package com.example.uplusapi;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("register")
    Call register(@Path("username") String username, @Path("password") String password);
}


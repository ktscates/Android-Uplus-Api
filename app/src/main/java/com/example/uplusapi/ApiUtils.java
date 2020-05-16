package com.example.uplusapi;

public class ApiUtils {

    public static final String BASE_URL = "http://localhost:8000/api/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}

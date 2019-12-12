package com.item.example.beans;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("User/findUser")
    Call<User> login(@Query("username") String username,@Query("password") String password);

}

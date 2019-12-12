package com.item.testproject2.service;

import com.item.testproject2.beans.KePu;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KePuService {

    @GET("KePu/queryAllKePuList")
    Call<KePu> queryAllKePuList();


}

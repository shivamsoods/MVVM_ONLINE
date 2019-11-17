package com.example.shivam_wission.network;


import com.example.shivam_wission.models.FirebaseApiResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET(".json")
    Call<Map<String,FirebaseApiResponse>> getUserList();

    //TODO: post request to add users
}

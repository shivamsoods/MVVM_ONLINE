package com.example.shivam_wission.network;


import com.example.shivam_wission.models.FirebaseApiResponse;
import com.google.gson.JsonObject;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    @GET(".json")
    Call<Map<String, FirebaseApiResponse>> getUserList();


    @PUT("{userId}.json")
    Call<JsonObject> createUser(@Path(value = "userId") String userId,
            @Body JsonObject jsonObject);
}

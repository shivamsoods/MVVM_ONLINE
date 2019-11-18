package com.example.shivam_wission.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.shivam_wission.AddUserActivity;
import com.example.shivam_wission.models.FirebaseApiResponse;
import com.example.shivam_wission.network.RetrofitClient;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserRepository {

    private static final String TAG="ADD USER REPO";
    private static AddUserRepository instance;

    public static synchronized AddUserRepository getInstance() {
        if (instance == null) {
            instance = new AddUserRepository();
        }
        return instance;
    }

    public void addNewUser(JsonObject j) {



        String userId=generateUserId();
        RetrofitClient.getInstance()
                .getApi()
                .createUser(userId,j)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Log.d(TAG, "onResponse: "+response.body());
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });

    }
    private String generateUserId(){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");

        return ft.format(dNow);
    }
}

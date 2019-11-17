package com.example.shivam_wission.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.shivam_wission.models.FirebaseApiResponse;
import com.example.shivam_wission.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainUserRepository {

    private static MainUserRepository instance;
    private MutableLiveData<List<FirebaseApiResponse>> LiveDataList = new MutableLiveData<>();
    private ArrayList<FirebaseApiResponse> dataSet = new ArrayList<>();

    public static MainUserRepository getInstance() {
        if (instance == null) {
            instance = new MainUserRepository();
        }
        return instance;
    }

    public MutableLiveData<List<FirebaseApiResponse>> getMainUsers() {
        RetrofitClient.getInstance()
                .getApi()
                .getUserList()
    .enqueue(new Callback<Map<String, FirebaseApiResponse>>() {
        @Override
        public void onResponse(Call<Map<String, FirebaseApiResponse>> call, Response<Map<String, FirebaseApiResponse>> response) {
            final Map<String,FirebaseApiResponse> responseMap=response.body();
            final FirebaseApiResponse firebaseApiResponse=responseMap.get("u1");

            Log.d("USER REPO", "onResponse: "+firebaseApiResponse);
            if(!responseMap.isEmpty()){
                dataSet.add(firebaseApiResponse);
                LiveDataList.setValue(dataSet);
            }

        }

        @Override
        public void onFailure(Call<Map<String, FirebaseApiResponse>> call, Throwable t) {
            Log.d("USER REPO", "onFailure: "+t);
        }
    });
        return LiveDataList;
    }

}

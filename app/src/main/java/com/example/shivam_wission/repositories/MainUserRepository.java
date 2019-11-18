package com.example.shivam_wission.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
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
    private static String TAG = "USER REPO";

    private static MainUserRepository instance;

    private MutableLiveData<List<FirebaseApiResponse>> LiveDataList = new MutableLiveData<>();

    public static synchronized MainUserRepository getInstance() {
        if (instance == null) {
            instance = new MainUserRepository();
        }
        return instance;
    }


    public MutableLiveData<List<FirebaseApiResponse>> getMainUsers() {
        final ArrayList<FirebaseApiResponse> dataSet = new ArrayList<>();

        LiveDataList.setValue(dataSet);
        RetrofitClient.getInstance()
                .getApi()
                .getUserList()
                .enqueue(new Callback<Map<String, FirebaseApiResponse>>() {
                    @Override
                    public void onResponse(Call<Map<String, FirebaseApiResponse>> call, Response<Map<String, FirebaseApiResponse>> response) {
                        final Map<String, FirebaseApiResponse> responseMap = response.body();
                        FirebaseApiResponse firebaseApiResponse;

                        assert responseMap != null;
                        if (!responseMap.isEmpty()) {
                            for (String userId : responseMap.keySet()) {
                                firebaseApiResponse = responseMap.get(userId);
                                dataSet.add(firebaseApiResponse);
                            }
                            Log.d(TAG, "onResponse: getMainUser " + dataSet.size());

                            LiveDataList.setValue(dataSet);
                        }

                    }

                    @Override
                    public void onFailure(Call<Map<String, FirebaseApiResponse>> call, Throwable t) {

                    }
                });

        return LiveDataList;
    }





}

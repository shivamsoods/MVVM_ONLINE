package com.example.shivam_wission.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shivam_wission.models.FirebaseApiResponse;
import com.example.shivam_wission.repositories.MainUserRepository;
import com.google.gson.JsonObject;

import java.util.List;


public class MainViewModel extends ViewModel {

    private MutableLiveData<List<FirebaseApiResponse>> mMainUsers;
    private MainUserRepository mRepo;

    public void init(){
        if(mMainUsers!= null){
            return;
        }
        mRepo = MainUserRepository.getInstance();
        mMainUsers= mRepo.getMainUsers();

    }


    public LiveData<List<FirebaseApiResponse>> getMainUsers(){
        return mMainUsers;
    }


}

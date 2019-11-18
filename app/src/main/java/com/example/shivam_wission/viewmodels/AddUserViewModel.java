package com.example.shivam_wission.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shivam_wission.models.FirebaseApiResponse;
import com.example.shivam_wission.repositories.AddUserRepository;
import com.google.gson.JsonObject;

import java.util.List;

public class AddUserViewModel extends ViewModel {

    private AddUserRepository mRepo;

    public void init(){
        mRepo = AddUserRepository.getInstance();

    }


    public void addNewUser(JsonObject jsonObject){
     mRepo.addNewUser(jsonObject);
    }
}

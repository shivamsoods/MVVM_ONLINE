package com.example.shivam_wission.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.shivam_wission.repositories.AddUserRepository;
import com.google.gson.JsonObject;


public class AddUserViewModel extends ViewModel {

    private AddUserRepository mRepo;

    public void init(){
        mRepo = AddUserRepository.getInstance();

    }


    public void addNewUser(JsonObject jsonObject){
     mRepo.addNewUser(jsonObject);
    }
}

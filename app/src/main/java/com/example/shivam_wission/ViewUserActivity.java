package com.example.shivam_wission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewUserActivity extends AppCompatActivity {

    private TextView mName, mEmail, mPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_model_layout);

        mName = findViewById(R.id.tv_model_name);
        mEmail =findViewById(R.id.tv_model_email);
        mPhone =findViewById(R.id.tv_model_phone);

        Intent intent=getIntent();
        setTitle("View User");
        if(intent.hasExtra("name")){
            mName.setText(intent.getStringExtra("name"));
        }
        if(intent.hasExtra("email")){
            mEmail.setText(intent.getStringExtra("email"));
        }
        if(intent.hasExtra("phone")){
            mPhone.setText(intent.getStringExtra("phone"));
        }
    }
}

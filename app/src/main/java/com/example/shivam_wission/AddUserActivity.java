package com.example.shivam_wission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUserActivity extends AppCompatActivity {

    private EditText etName,etEmail,etPhone;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        etName=findViewById(R.id.et_add_name);
        etEmail=findViewById(R.id.et_add_email);
        etPhone=findViewById(R.id.et_add_phone);

        btnSubmit=findViewById(R.id.btn_add_submit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,email,phone;

            }
        });

    }
}

package com.example.shivam_wission;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.shivam_wission.adapters.MainRecyclerAdapter;
import com.example.shivam_wission.models.FirebaseApiResponse;
import com.example.shivam_wission.viewmodels.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainRecyclerAdapter mAdapter;
    private MainViewModel mMainViewModel;
    private FloatingActionButton mFab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_main);
        mFab = findViewById(R.id.fab_main);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.init();

        mMainViewModel.getMainUsers().observe(this, new Observer<List<FirebaseApiResponse>>() {
            @Override
            public void onChanged(List<FirebaseApiResponse> firebaseApiResponses) {
                mMainViewModel.getMainUsers().getValue();
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();


        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddUserActivity.class));

            }
        });

        mAdapter.setOnItemClickListner(new MainRecyclerAdapter.onItemClickListner() {
            @Override
            public void onItemClick(FirebaseApiResponse firebaseApiResponse) {
                Intent intent=new Intent(MainActivity.this,ViewUserActivity.class);
                intent.putExtra("name",firebaseApiResponse.getName());
                intent.putExtra("email",firebaseApiResponse.getEmail());
                intent.putExtra("phone",firebaseApiResponse.getPhone());
                startActivity(intent);
            }
        });
    }

    private void initRecyclerView() {
        mAdapter = new MainRecyclerAdapter(mMainViewModel.getMainUsers().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }

}

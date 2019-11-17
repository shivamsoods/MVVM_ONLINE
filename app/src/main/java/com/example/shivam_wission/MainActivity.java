package com.example.shivam_wission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shivam_wission.adapters.MainRecyclerAdapter;
import com.example.shivam_wission.models.FirebaseApiResponse;
import com.example.shivam_wission.viewmodels.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainRecyclerAdapter mAdapter;
    private MainViewModel mMainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_main);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.init();

        mMainViewModel.getMainUsers().observe(this, new Observer<List<FirebaseApiResponse>>() {
            @Override
            public void onChanged(List<FirebaseApiResponse> firebaseApiResponses) {
                mAdapter.notifyDataSetChanged();

            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {
        mAdapter = new MainRecyclerAdapter( mMainViewModel.getMainUsers().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}

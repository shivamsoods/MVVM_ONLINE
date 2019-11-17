package com.example.shivam_wission.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shivam_wission.R;
import com.example.shivam_wission.models.FirebaseApiResponse;

import java.util.List;


public class MainRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FirebaseApiResponse> mUserList;



    public MainRecyclerAdapter(List<FirebaseApiResponse> MainUserList) {
    mUserList=MainUserList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_model_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

       ((ViewHolder) viewHolder).mName.setText(mUserList.get(i).getName());
        ((ViewHolder) viewHolder).mEmail.setText(mUserList.get(i).getEmail());
        ((ViewHolder) viewHolder).mPhone.setText(mUserList.get(i).getPhone());



    }

    @Override
    public int getItemCount() {
     return mUserList.size();

    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName,mEmail,mPhone;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.tv_model_name);
            mEmail = itemView.findViewById(R.id.tv_model_email);
            mPhone = itemView.findViewById(R.id.tv_model_phone);


        }
    }
}

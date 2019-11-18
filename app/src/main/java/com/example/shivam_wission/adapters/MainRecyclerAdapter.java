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
    private onItemClickListner listner;


    public MainRecyclerAdapter(List<FirebaseApiResponse> MainUserList) {
        mUserList = MainUserList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_model_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        FirebaseApiResponse firebaseApiResponse = mUserList.get(i);

        ((ViewHolder) viewHolder).mName.setText(firebaseApiResponse.getName());
        ((ViewHolder) viewHolder).mEmail.setText(firebaseApiResponse.getEmail());
        ((ViewHolder) viewHolder).mPhone.setText(firebaseApiResponse.getPhone());


    }

    @Override
    public int getItemCount() {
        return mUserList.size();

    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName, mEmail, mPhone;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.tv_model_name);
            mEmail = itemView.findViewById(R.id.tv_model_email);
            mPhone = itemView.findViewById(R.id.tv_model_phone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listner != null && position != RecyclerView.NO_POSITION) {
                        listner.onItemClick(mUserList.get(position));
                    }
                }
            });
        }
    }

    public interface onItemClickListner {
        void onItemClick(FirebaseApiResponse firebaseApiResponse);
    }

    public void setOnItemClickListner(onItemClickListner listner) {
        this.listner = listner;
    }
}

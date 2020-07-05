package com.example.p_collapsing_toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UserViewHolder> {
    private List<User> mData;


    public UserRecyclerViewAdapter(List<User> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_d,parent,false);
        UserViewHolder userViewHolder =new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
                holder.tvAccount.setText(mData.get(position).getAccount());
                holder.tvPwd.setText(mData.get(position).getPassword());
                holder.tvNum.setText(mData.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvAccount,tvPwd,tvNum;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
          tvAccount =  itemView.findViewById(R.id.tvAccount);
          tvPwd =itemView.findViewById(R.id.tvPwd);
          tvNum =   itemView.findViewById(R.id.tvNum);
        }
    }

}

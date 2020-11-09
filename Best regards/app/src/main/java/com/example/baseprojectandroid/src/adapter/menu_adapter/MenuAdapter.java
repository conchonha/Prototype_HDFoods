package com.example.baseprojectandroid.src.adapter.menu_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.models.menu_models.MenuModels;
import com.example.baseprojectandroid.src.repositories.MenuRepositories;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private Context mContext;
    private int mLayout;
    private ArrayList<MenuModels>mArrayMenu;

    public MenuAdapter(ArrayList<MenuModels> mArrayMenu,Context mContext, int mLayout) {
        this.mContext = mContext;
        this.mLayout = mLayout;
        this.mArrayMenu = mArrayMenu;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, mLayout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuModels menuModels = mArrayMenu.get(position);
        Picasso.with(mContext).load(menuModels.getmImage()).into(holder.mImage);
        holder.mName.setText(menuModels.getmName());
        holder.mMoney.setText(menuModels.getmMoney());
    }

    @Override
    public int getItemCount() {
        return mArrayMenu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private TextView mName, mMoney;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.img_food);
            mName = itemView.findViewById(R.id.txt_namefood);
            mMoney = itemView.findViewById(R.id.txt_money);
        }
    }
}
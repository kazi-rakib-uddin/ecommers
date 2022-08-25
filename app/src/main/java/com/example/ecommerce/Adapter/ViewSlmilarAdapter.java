package com.example.ecommerce.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.Activity.SinglePageActivity;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.CustomTopBrandBinding;

import java.util.ArrayList;

public class ViewSlmilarAdapter extends RecyclerView.Adapter<ViewSlmilarAdapter.MyViewHolder> {

    ArrayList<CategoryModel> arrayList_catagory;
    Context context;

    public ViewSlmilarAdapter(Context context, ArrayList<CategoryModel> arrayList_catagory) {
        this.arrayList_catagory = arrayList_catagory;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_view_similar,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.mobileName.setText(arrayList_catagory.get(position).getName());

        Glide
                .with(holder.itemView)
                .load(arrayList_catagory.get(position).getImage())
                .centerCrop()
                .into(holder.binding.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(new Intent(context, SinglePageActivity.class));
            }
        });


        holder.binding.discPrice.setPaintFlags(holder.binding.discPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return arrayList_catagory.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CustomTopBrandBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomTopBrandBinding.bind(itemView);
        }
    }
}

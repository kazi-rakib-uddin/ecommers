package com.example.ecommerce.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.CatagoryItemBinding;
import com.example.ecommerce.databinding.CustomSubCategoryItemBinding;

import java.util.ArrayList;

public class SubCatagoryAdapter extends RecyclerView.Adapter<SubCatagoryAdapter.MyViewHolder> {

    ArrayList<CategoryModel> arrayList_catagory;
    Context context;

    public SubCatagoryAdapter(Context context, ArrayList<CategoryModel> arrayList_catagory) {
        this.arrayList_catagory = arrayList_catagory;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_sub_category_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.txtName.setText(arrayList_catagory.get(position).getName());
        holder.binding.phoneName.setText(arrayList_catagory.get(position).getName());

        if (arrayList_catagory.get(position).getName().equals("realme"))
        {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#ffc915"));
            holder.binding.phoneName.setTextColor(Color.parseColor("#000000"));
        }
        else if (arrayList_catagory.get(position).getName().equals("POCO"))
        {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#D3DC46"));
            holder.binding.phoneName.setTextColor(Color.parseColor("#000000"));
        }
        else if (arrayList_catagory.get(position).getName().equals("SAMSUNG"))
        {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#0E5ED2"));
        }
        else if (arrayList_catagory.get(position).getName().equals("narzo"))
        {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#BCE0FC"));
            holder.binding.phoneName.setTextColor(Color.parseColor("#000000"));
        }
        else if (arrayList_catagory.get(position).getName().equals("MI"))
        {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#E27224"));
        }
        else if (arrayList_catagory.get(position).getName().equals("oppo"))
        {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#318129"));
        }
        else if (arrayList_catagory.get(position).getName().equals("vivo"))
        {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#619BEF"));
        }
        else if (arrayList_catagory.get(position).getName().equals("Apple"))
        {
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#313132"));
        }

    }

    @Override
    public int getItemCount() {
        return arrayList_catagory.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CustomSubCategoryItemBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomSubCategoryItemBinding.bind(itemView);
        }
    }
}

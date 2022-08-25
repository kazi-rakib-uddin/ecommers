package com.example.ecommerce.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ecommerce.Adapter.AddressAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityAddressBinding;
import com.example.ecommerce.databinding.ActivityCheckOutBinding;

import java.util.ArrayList;

public class AddressActivity extends AppCompatActivity {

    ActivityAddressBinding binding;
    ArrayList<CategoryModel> arrayList_top_brand = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_top_cart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        address();
        binding.rvAddress.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        binding.addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AddressActivity.this,AddAddressActivity.class));
            }
        });
    }


    private void address()
    {
        arrayList_top_brand.add(new CategoryModel("Kazi Sani","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Kazi Sani","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));


        binding.rvAddress.setAdapter(new AddressAdapter(this,arrayList_top_brand));

    }
}
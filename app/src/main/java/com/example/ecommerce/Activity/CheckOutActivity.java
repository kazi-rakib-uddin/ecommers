package com.example.ecommerce.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ecommerce.Adapter.AddressAdapter;
import com.example.ecommerce.Adapter.CheckOutCartAdapter;
import com.example.ecommerce.Adapter.TopBrandAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityCheckOutBinding;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {

    ActivityCheckOutBinding binding;
    ArrayList<CategoryModel> arrayList_top_brand = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_top_cart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckOutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        address();
        TopBrand();
        //binding.rvCartItem.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        binding.rvAddress.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        binding.btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(CheckOutActivity.this,PaymentActivity.class));
            }
        });


        binding.addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(CheckOutActivity.this,AddAddressActivity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void address()
    {
        arrayList_top_brand.add(new CategoryModel("Kazi Sani","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Kazi Sani","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));


        binding.rvAddress.setAdapter(new AddressAdapter(this,arrayList_top_brand));

    }



    private void TopBrand()
    {
        arrayList_top_cart.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_cart.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));

        binding.rvCartItem.setAdapter(new CheckOutCartAdapter(this,arrayList_top_cart));

    }


}
package com.example.ecommerce.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ecommerce.Adapter.CartAdapter;
import com.example.ecommerce.Adapter.TopBrandAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;
    ArrayList<CategoryModel> arrayList_top_brand = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        TopBrand();
        //binding.rvCart.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        binding.btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(CartActivity.this,CheckOutActivity.class));
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

    private void TopBrand()
    {
        arrayList_top_brand.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        binding.rvCart.setAdapter(new CartAdapter(this,arrayList_top_brand));

    }

}
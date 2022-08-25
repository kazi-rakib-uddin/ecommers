package com.example.ecommerce.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ecommerce.Adapter.OrderAdapter;
import com.example.ecommerce.Adapter.TimelineAdapter;
import com.example.ecommerce.Adapter.TrackProductAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityTrackOrderBinding;

import java.util.ArrayList;

public class TrackOrderActivity extends AppCompatActivity {

    ActivityTrackOrderBinding binding;
    ArrayList<CategoryModel> arrayList_top_brand = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_top_brand1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrackOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        TopBrand();
        Track();
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
        //arrayList_top_brand.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        binding.rvProduct.setAdapter(new TrackProductAdapter(this,arrayList_top_brand));

    }


    private void Track()
    {
        arrayList_top_brand1.add(new CategoryModel("Ordered","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_brand1.add(new CategoryModel("Ready To Ship","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand1.add(new CategoryModel("Out For Delivery","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        binding.rvTrack.setAdapter(new TimelineAdapter(arrayList_top_brand1));

    }
}
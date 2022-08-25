package com.example.ecommerce.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ecommerce.Adapter.TopBrandAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityDealOfDayBinding;

import java.util.ArrayList;

public class DealOfDayActivity extends AppCompatActivity {

    ActivityDealOfDayBinding binding;
    ArrayList<CategoryModel> arrayList_great_sale = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDealOfDayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Greatsale();
    }


    private void Greatsale()
    {
        arrayList_great_sale.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Redmi Note 10S 64 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Vivo Y1s 32 GB","https://m.media-amazon.com/images/I/51dPne4jLcS._SL1200_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Redmi Note 10 Pro Max","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));


        binding.rvDeal.setAdapter(new TopBrandAdapter(this,arrayList_great_sale));

    }
}
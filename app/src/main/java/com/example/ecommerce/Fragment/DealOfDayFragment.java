package com.example.ecommerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.Adapter.TopBrandAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.FragmentDealOfDayBinding;

import java.util.ArrayList;


public class DealOfDayFragment extends Fragment {

    FragmentDealOfDayBinding binding;
    ArrayList<CategoryModel> arrayList_great_sale = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_deal_of_day, container, false);

        binding = FragmentDealOfDayBinding.inflate(getLayoutInflater());

        Greatsale();

        return binding.getRoot();
    }

    private void Greatsale()
    {
        arrayList_great_sale.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Redmi Note 10S 64 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Vivo Y1s 32 GB","https://m.media-amazon.com/images/I/51dPne4jLcS._SL1200_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Redmi Note 10 Pro Max","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));


        binding.rvDeal.setAdapter(new TopBrandAdapter(getContext(),arrayList_great_sale));

    }
}
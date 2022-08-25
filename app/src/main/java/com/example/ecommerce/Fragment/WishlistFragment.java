package com.example.ecommerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.Adapter.WishlistAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.FragmentWishlistBinding;

import java.util.ArrayList;


public class WishlistFragment extends Fragment {

    FragmentWishlistBinding binding;
    ArrayList<CategoryModel> arrayList_top_brand = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_wishlist, container, false);

        binding = FragmentWishlistBinding.inflate(getLayoutInflater());


        TopBrand();

        return binding.getRoot();
    }

    private void TopBrand()
    {
        arrayList_top_brand.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        binding.rvWishlist.setAdapter(new WishlistAdapter(getContext(),arrayList_top_brand));

    }
}
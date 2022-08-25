package com.example.ecommerce.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.Adapter.AllCatagoryAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.FragmentAllCategoryBinding;

import java.util.ArrayList;


public class AllCategoryFragment extends Fragment {

    FragmentAllCategoryBinding binding;
    ArrayList<CategoryModel> arrayList_catagory = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_all_category, container, false);

        binding = FragmentAllCategoryBinding.inflate(getLayoutInflater());

        catagoryItem();

        return binding.getRoot();

    }

    private void catagoryItem()
    {
        arrayList_catagory.add(new CategoryModel("Top Offers","https://rukminim1.flixcart.com/flap/128/128/image/f15c02bfeb02d15d.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Grocery","https://rukminim1.flixcart.com/flap/128/128/image/29327f40e9c4d26b.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Mobile","https://rukminim1.flixcart.com/flap/128/128/image/22fddf3c7da4c4f4.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Fashion","https://rukminim1.flixcart.com/flap/128/128/image/82b3ca5fb2301045.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Electronics","https://rukminim1.flixcart.com/flap/128/128/image/69c6589653afdb9a.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Home","https://rukminim1.flixcart.com/flap/128/128/image/ab7e2b022a4587dd.jpg?q=100"));
        arrayList_catagory.add(new CategoryModel("Home","https://rukminim1.flixcart.com/flap/128/128/image/ab7e2b022a4587dd.jpg?q=100"));
        arrayList_catagory.add(new CategoryModel("Top Offers","https://rukminim1.flixcart.com/flap/128/128/image/f15c02bfeb02d15d.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Grocery","https://rukminim1.flixcart.com/flap/128/128/image/29327f40e9c4d26b.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Mobile","https://rukminim1.flixcart.com/flap/128/128/image/22fddf3c7da4c4f4.png?q=100"));


        binding.rvCategory.setAdapter(new AllCatagoryAdapter(getContext(),arrayList_catagory));

    }
}
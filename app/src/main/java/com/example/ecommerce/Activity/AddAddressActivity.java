package com.example.ecommerce.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityAddAddressBinding;

public class AddAddressActivity extends AppCompatActivity {

    ActivityAddAddressBinding binding;

    private static final String[] question = new String[] {
            "West Bangel", "Mumbai", "Delhi"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, question);
        binding.spinnerState.setAdapter(adapter);

    }
}
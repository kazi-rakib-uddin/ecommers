package com.example.ecommerce.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity extends AppCompatActivity {

    ActivityForgetPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.etNewPassword.setVisibility(View.VISIBLE);
                binding.etConfirmPassword.setVisibility(View.VISIBLE);
                binding.btnResetPassword.setVisibility(View.VISIBLE);
                binding.txtReset.setVisibility(View.VISIBLE);

                binding.etPhoneNo.setVisibility(View.GONE);
                binding.btnSendOtp.setVisibility(View.GONE);
                binding.txtForgot.setVisibility(View.GONE);
            }
        });


        binding.btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ForgetPasswordActivity.this,LoginActivity.class));
                finish();
            }
        });

    }
}
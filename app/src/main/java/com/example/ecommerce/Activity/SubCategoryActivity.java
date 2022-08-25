package com.example.ecommerce.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.ecommerce.Adapter.BannerAdapter;
import com.example.ecommerce.Adapter.CatagoryAdapter;
import com.example.ecommerce.Adapter.SliderAdapterExample;
import com.example.ecommerce.Adapter.SubCatagoryAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.Model.Slider_Image_Model;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivitySubCategoryBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class SubCategoryActivity extends AppCompatActivity {

    ActivitySubCategoryBinding binding;
    ArrayList<CategoryModel> arrayList_catagory = new ArrayList<>();
    ArrayList<Slider_Image_Model> arrayList_slider = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_banner_faction = new ArrayList<>();
    private SliderAdapterExample adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);


        arrayList_slider.add(new Slider_Image_Model("","https://rukminim1.flixcart.com/flap/1800/1800/image/769326543b5321a4.jpg?q=80"));
        arrayList_slider.add(new Slider_Image_Model("","https://rukminim1.flixcart.com/flap/1688/280/image/31b89762a2c3f32a.jpeg?q=50"));
        arrayList_slider.add(new Slider_Image_Model("","https://rukminim1.flixcart.com/flap/1688/280/image/946b9beb7858fd31.jpeg?q=50"));
        arrayList_slider.add(new Slider_Image_Model("","https://rukminim1.flixcart.com/flap/1688/280/image/a024b92aa53c0e72.jpeg?q=50"));

        adapter = new SliderAdapterExample(this,arrayList_slider);
        binding.imageSlider.setSliderAdapter(adapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(3);
        binding.imageSlider.setAutoCycle(true);
        binding.imageSlider.startAutoCycle();

        binding.imageSlider.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + binding.imageSlider.getCurrentPagePosition());
            }
        });



        catagoryItem();
        Banner();

        binding.txtDisc.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.txtDisc2.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.txtDisc3.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.txtDisc4.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.txtDisc5.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.txtDisc6.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.txtDisc7.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.txtDisc8.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

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

    private void catagoryItem()
    {
        arrayList_catagory.add(new CategoryModel("realme",""));
        arrayList_catagory.add(new CategoryModel("POCO",""));
        arrayList_catagory.add(new CategoryModel("SAMSUNG",""));
        arrayList_catagory.add(new CategoryModel("narzo",""));
        arrayList_catagory.add(new CategoryModel("MI",""));
        arrayList_catagory.add(new CategoryModel("oppo",""));
        arrayList_catagory.add(new CategoryModel("vivo",""));
        arrayList_catagory.add(new CategoryModel("Apple",""));


        binding.rvCategory.setAdapter(new SubCatagoryAdapter(this,arrayList_catagory));

    }


    private void Banner()
    {
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));



        binding.rvBanner.setAdapter(new BannerAdapter(this,arrayList_banner_faction));

    }

}
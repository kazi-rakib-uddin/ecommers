package com.example.ecommerce.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ecommerce.Adapter.BannerAdapter;
import com.example.ecommerce.Adapter.SinglePageImageAdapter;
import com.example.ecommerce.Adapter.TopBrandAdapter;
import com.example.ecommerce.Adapter.ViewSlmilarAdapter;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.Model.Slider_Image_Model;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivitySinglePageBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class SinglePageActivity extends AppCompatActivity {



    ArrayList<CategoryModel> arrayList_top_brand = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_banner_faction = new ArrayList<>();

    RecyclerView rv_top_brand;
    ActivitySinglePageBinding binding;
    BottomSheetDialog bottomSheetDialog;
    RecyclerView rv_view_similar;
    ImageView img_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySinglePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        TopBrand();
        newMobile();

        binding.txtDisc.setPaintFlags(binding.txtDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        binding.rvImageSlide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                binding.txtCount.setText("0"+String.valueOf(position+1)+ " / "+"0"+SinglePageImageAdapter.arrayList_catagory.size());
            }

            @Override
            public void onPageSelected(int position) {

                //Toast.makeText(SinglePageActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        binding.viewSimiliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog = new BottomSheetDialog(SinglePageActivity.this,R.style.BottomSheetDialogTheme);
                View view1 = LayoutInflater.from(SinglePageActivity.this).inflate(R.layout.bottom_sheet_view_similar,
                        (LinearLayout) view.findViewById(R.id.buttom_sheet_content));

                rv_view_similar = view1.findViewById(R.id.rv_view_similar);
                img_cancel = view1.findViewById(R.id.img_cancel);

                img_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        bottomSheetDialog.dismiss();
                    }
                });

                TopBrand2();

                bottomSheetDialog.setContentView(view1);
                bottomSheetDialog.show();


            }
        });



        binding.txtBarganing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // custom dialog
                final Dialog dialog = new Dialog(SinglePageActivity.this);
                dialog.setContentView(R.layout.barganng_alert_dialog);

                dialog.show();
            }
        });
    }

    private void TopBrand()
    {
        arrayList_top_brand.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Redmi Note 10S 64 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Vivo Y1s 32 GB","https://m.media-amazon.com/images/I/51dPne4jLcS._SL1200_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Redmi Note 10 Pro Max","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));


        binding.rvTopBrand.setAdapter(new TopBrandAdapter(this,arrayList_top_brand));

    }


    private void TopBrand2()
    {
        arrayList_top_brand.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Redmi Note 10S 64 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Vivo Y1s 32 GB","https://m.media-amazon.com/images/I/51dPne4jLcS._SL1200_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Redmi Note 10 Pro Max","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));


        rv_view_similar.setAdapter(new ViewSlmilarAdapter(this,arrayList_top_brand));

    }

    private void newMobile()
    {
        arrayList_banner_faction.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_banner_faction.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_banner_faction.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        arrayList_banner_faction.add(new CategoryModel("Redmi Note 10S 64 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));


        binding.rvImageSlide.setAdapter(new SinglePageImageAdapter(this,arrayList_banner_faction));

    }
}
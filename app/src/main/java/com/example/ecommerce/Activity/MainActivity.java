package com.example.ecommerce.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.Adapter.BannerAdapter;
import com.example.ecommerce.Adapter.CatagoryAdapter;
import com.example.ecommerce.Adapter.NewFashionAdapter;
import com.example.ecommerce.Adapter.SliderAdapterExample;
import com.example.ecommerce.Adapter.TopBrandAdapter;
import com.example.ecommerce.Fragment.AllCategoryFragment;
import com.example.ecommerce.Fragment.DealOfDayFragment;
import com.example.ecommerce.Fragment.HomeFragment;
import com.example.ecommerce.Fragment.ProfileFragment;
import com.example.ecommerce.Fragment.WishlistFragment;
import com.example.ecommerce.Model.CategoryModel;
import com.example.ecommerce.Model.Slider_Image_Model;
import com.example.ecommerce.R;
import com.example.ecommerce.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;

    ActivityMainBinding binding;
    ArrayList<CategoryModel> arrayList_catagory = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_top_brand = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_new_faction = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_banner_faction = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_great_sale = new ArrayList<>();
    ArrayList<CategoryModel> arrayList_new_mobile = new ArrayList<>();
    ArrayList<Slider_Image_Model> arrayList_slider = new ArrayList<>();
    ArrayList<Slider_Image_Model> arrayList_banner = new ArrayList<>();
    RecyclerView rv_category, rv_top_brand, rv_new_faction, rv_banner, rv_great_sale, rv_new_mobile;
    SliderView sliderView;
    private SliderAdapterExample adapter;
    private TextView view_more_top_brand, view_more_fashion, view_more_great_sale;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab_deal_of_day;
    Fragment selectedFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(contentMainBinding.getRoot());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fab_deal_of_day = findViewById(R.id.fab_deal_of_day);
        bottomNavigationView.setBackground(null);

       /* rv_category = findViewById(R.id.rv_category);
        rv_top_brand = findViewById(R.id.rv_top_brand);
        rv_new_faction = findViewById(R.id.rv_new_faction);
        rv_banner = findViewById(R.id.rv_banner);
        rv_great_sale = findViewById(R.id.rv_great_sale);
        rv_new_mobile = findViewById(R.id.rv_new_mobile);
        sliderView = findViewById(R.id.imageSlider);
        view_more_top_brand = findViewById(R.id.view_more_top_brand);
        view_more_fashion = findViewById(R.id.view_more_fashion);
        view_more_fashion = findViewById(R.id.view_more_fashion);
        view_more_great_sale = findViewById(R.id.view_more_great_sale);
        */

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content,new HomeFragment()).commit();


        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        binding.drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            drawerToggle.getDrawerArrowDrawable().setColor(getColor(R.color.colorWhite));
        } else {
            drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimary));
        }

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
        selectDrawerItem(navigationView.getMenu().getItem(0));
        navigationView.setCheckedItem(navigationView.getMenu().getItem(0));


        fab_deal_of_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedFragment = new DealOfDayFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content,selectedFragment).commit();
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                
                switch (item.getItemId())
                {
                    case R.id.home:

                        selectedFragment = new HomeFragment();

                        break;

                    case R.id.category:

                        selectedFragment = new AllCategoryFragment();

                        break;

                    case R.id.profile:

                        selectedFragment = new ProfileFragment();
                        break;

                    case R.id.deal_of_day:

                        selectedFragment = new WishlistFragment();

                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content,selectedFragment).commit();

                return true;
            }
        });


       /* catagoryItem();
        TopBrand();
        NewFaction();
        Banner();
        Greatsale();
        newMobile();


        arrayList_slider.add(new Slider_Image_Model("","https://rukminim1.flixcart.com/flap/1800/1800/image/769326543b5321a4.jpg?q=80"));
        arrayList_slider.add(new Slider_Image_Model("","https://rukminim1.flixcart.com/flap/1688/280/image/31b89762a2c3f32a.jpeg?q=50"));
        arrayList_slider.add(new Slider_Image_Model("","https://rukminim1.flixcart.com/flap/1688/280/image/946b9beb7858fd31.jpeg?q=50"));
        arrayList_slider.add(new Slider_Image_Model("","https://rukminim1.flixcart.com/flap/1688/280/image/a024b92aa53c0e72.jpeg?q=50"));



        adapter = new SliderAdapterExample(this,arrayList_slider);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });



        view_more_top_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ViewMoreActivity.class));
            }
        });

        view_more_fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ViewMoreActivity.class));
            }
        });

        view_more_great_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ViewMoreActivity.class));
            }
        });*/



    }


    public void selectDrawerItem(MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.nav_account:


                startActivity(new Intent(MainActivity.this,AccountActivity.class));
                break;


            case R.id.nav_logout:

                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;

            case R.id.nav_cart:

                startActivity(new Intent(MainActivity.this,CartActivity.class));
                break;

            case R.id.nav_order:

                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;

            case R.id.nav_category:

                startActivity(new Intent(MainActivity.this,AllCategoryActivity.class));
                break;
        }



        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        binding.drawerLayout.closeDrawers();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        final MenuItem menuItem = menu.findItem(R.id.menu_cart);
        View view = menuItem.getActionView();
        TextView txt_cart_count = view.findViewById(R.id.txt_cart_count);
        txt_cart_count.setText("2");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_notification:
                startActivity(new Intent(MainActivity.this,NotificationActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void catagoryItem()
    {
        arrayList_catagory.add(new CategoryModel("Top Offers","https://rukminim1.flixcart.com/flap/128/128/image/f15c02bfeb02d15d.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Grocery","https://rukminim1.flixcart.com/flap/128/128/image/29327f40e9c4d26b.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Mobile","https://rukminim1.flixcart.com/flap/128/128/image/22fddf3c7da4c4f4.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Fashion","https://rukminim1.flixcart.com/flap/128/128/image/82b3ca5fb2301045.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Electronics","https://rukminim1.flixcart.com/flap/128/128/image/69c6589653afdb9a.png?q=100"));
        arrayList_catagory.add(new CategoryModel("Home","https://rukminim1.flixcart.com/flap/128/128/image/ab7e2b022a4587dd.jpg?q=100"));


        rv_category.setAdapter(new CatagoryAdapter(this,arrayList_catagory));

    }



    private void TopBrand()
    {
        arrayList_top_brand.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Redmi Note 10S 64 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Vivo Y1s 32 GB","https://m.media-amazon.com/images/I/51dPne4jLcS._SL1200_.jpg"));
        arrayList_top_brand.add(new CategoryModel("Redmi Note 10 Pro Max","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));


        rv_top_brand.setAdapter(new TopBrandAdapter(this,arrayList_top_brand));

    }



    private void NewFaction()
    {
        arrayList_new_faction.add(new CategoryModel("GoSriKi Women's Cotton Straight Kurta with Checkered Trouser","https://m.media-amazon.com/images/I/61eM1vzP7BL._UL1500_.jpg"));
        arrayList_new_faction.add(new CategoryModel("ANNI DESIGNER Women's Pure Cotton Flower Print Kurta with Palazzo","https://m.media-amazon.com/images/I/61FHZoLpZhL._UL1500_.jpg"));
        arrayList_new_faction.add(new CategoryModel("OM SAI LATEST CREATION Designer Slub Rayon","https://m.media-amazon.com/images/I/61Ree+7fLOL._UL1500_.jpg"));
        arrayList_new_faction.add(new CategoryModel("Rajnandini Women's Red Crepe Printed","https://m.media-amazon.com/images/I/71EkBDJA4mL._UL1463_.jpg"));
        arrayList_new_faction.add(new CategoryModel("Rytras Women's Cotton Printed Anarkali","https://m.media-amazon.com/images/I/71+-e+-yUjL._UL1440_.jpg"));
        arrayList_new_faction.add(new CategoryModel("Janasya Women's A-Line Crepe Kurta","https://m.media-amazon.com/images/I/71WTxTRa1NL._UL1500_.jpg"));


        rv_new_faction.setAdapter(new NewFashionAdapter(this,arrayList_new_faction));

    }


    private void Banner()
    {
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));
        arrayList_banner_faction.add(new CategoryModel("","https://i.pinimg.com/originals/ca/e7/2c/cae72ce86998abcadd5051acd91a696b.jpg"));



        rv_banner.setAdapter(new BannerAdapter(this,arrayList_banner_faction));

    }



    private void Greatsale()
    {
        arrayList_great_sale.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Redmi Note 10S 64 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Vivo Y1s 32 GB","https://m.media-amazon.com/images/I/51dPne4jLcS._SL1200_.jpg"));
        arrayList_great_sale.add(new CategoryModel("Redmi Note 10 Pro Max","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));


        rv_great_sale.setAdapter(new TopBrandAdapter(this,arrayList_great_sale));

    }



    private void newMobile()
    {
        arrayList_new_mobile.add(new CategoryModel("Redmi 9A 32 GB","https://m.media-amazon.com/images/I/71hEzQGO5qL._SL1500_.jpg"));
        arrayList_new_mobile.add(new CategoryModel("Realme C11 32 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));
        arrayList_new_mobile.add(new CategoryModel("Tecno Spark 7 32 GB","https://m.media-amazon.com/images/I/71qdbEfle6S._SL1500_.jpg"));
        arrayList_new_mobile.add(new CategoryModel("Redmi Note 10S 64 GB","https://m.media-amazon.com/images/I/618UBhFmaQS._SL1500_.jpg"));


        rv_new_mobile.setAdapter(new TopBrandAdapter(this,arrayList_new_mobile));

    }





    public void addNewItem(View view) {
        Slider_Image_Model sliderItem = new Slider_Image_Model("","");
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        adapter.addItem(sliderItem);
    }





   /* private void sliderBanner()
    {

        arraySliderList.add(new Slider_Image_Model("https://rukminim1.flixcart.com/flap/844/140/image/946b9beb7858fd31.jpeg?q=50"));
        arraySliderList.add(new Slider_Image_Model("https://rukminim1.flixcart.com/flap/50/50/image/7529010932d66f48.jpg?q=50"));
        arraySliderList.add(new Slider_Image_Model("https://rukminim1.flixcart.com/flap/844/140/image/946b9beb7858fd31.jpeg?q=50"));
        arraySliderList.add(new Slider_Image_Model("https://rukminim1.flixcart.com/flap/844/140/image/946b9beb7858fd31.jpeg?q=50"));

        sliderImage();
    }*/



}
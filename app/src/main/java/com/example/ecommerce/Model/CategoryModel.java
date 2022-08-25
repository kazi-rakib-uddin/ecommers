package com.example.ecommerce.Model;

public class CategoryModel {

    String name, image;

    public CategoryModel(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}

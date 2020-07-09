package com.example.clothesseller;

import java.io.Serializable;

public class Clothes implements Serializable{
    String name;
    String imageFileName1;
    String imageFileName2;
    String imageFileName3;
    String category;
    String description;
    String price;
    Integer views;


    //basic constructor when all the objects parameters are provided on creation
    public Clothes(String name, String imageFileName1, String imageFileName2, String imageFileName3, String category, String price, String description, Integer views) {

        this.name=name;
        this.imageFileName1=imageFileName1;
        this.imageFileName2=imageFileName2;
        this.imageFileName3=imageFileName3;
        this.category=category;
        this.price=price;
        this.description=description;
        this.views = views;

    }

    //alternate constructor if a description is not included to give a message that one isn't available
    public Clothes(String name, String imageFileName1, String imageFileName2, String imageFileName3, String category, String price, Integer views) {

        this.name=name;
        this.imageFileName1=imageFileName1;
        this.imageFileName2=imageFileName2;
        this.imageFileName3=imageFileName3;
        this.category=category;
        this.price=price;
        this.views = views;
        this.description="No description available at this moment. ";

    }
    //getter for all our object paramters which are used to set the views for a product

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImageFileName1() {
        return imageFileName1;
    }

    public String getImageFileName2 () { return imageFileName2; }

    public String getImageFileName3 () { return imageFileName3; }

    public String getPrice () { return price; }

    public  String getViews () { return views.toString(); }

}
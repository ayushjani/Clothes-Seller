package com.example.clothesseller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;


import java.util.List;

public class ClothesActivity extends AppCompatActivity {
   //variable to refer to our Recycler view
    RecyclerView lvClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

        //Intent received from the main activity when clicking on one of the cardviews
        //name of the string that is passed through is called category

        Intent thisIntent = getIntent();
        final String Category = thisIntent.getStringExtra("category");

        //if statements check for a specific string on the string variable category and will select what list to show
        if (Category.equals("TShirt")) {
            //list of T-Shirt items are generated to this list
            List<Clothes> TShirtsList = ClothesProvider.getTShirts();
            //adaptor is used to convert the list into views to the specified layout structure
            final ClothesAdaptor itemsAdapter = new ClothesAdaptor(this, R.layout.clothes_list_view_item, TShirtsList);
            //Recycler view uses the adaptor to generate the list of individual card views
            lvClothes = (RecyclerView) findViewById(R.id.listView_clothes);
            lvClothes.setAdapter(itemsAdapter);
            lvClothes.setLayoutManager(new LinearLayoutManager(this));
            //title of this view in the action bar
            setTitle("Category: T-Shirts");
            //transition of sliding to the right
            overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);

        } else if (Category.equals("Pants")){

            List<Clothes> PantsList = ClothesProvider.getPants();
            ClothesAdaptor itemsAdapter = new ClothesAdaptor(this, R.layout.clothes_list_view_item, PantsList);
            lvClothes = (RecyclerView) findViewById(R.id.listView_clothes);
            lvClothes.setAdapter(itemsAdapter);
            lvClothes.setLayoutManager(new LinearLayoutManager(this));
            setTitle("Category: Pants");

        }else if (Category.equals("Jackets")) {

            List<Clothes> JacketsList = ClothesProvider.getJackets();
            ClothesAdaptor itemsAdapter = new ClothesAdaptor(this, R.layout.clothes_list_view_item, JacketsList);
            lvClothes = (RecyclerView) findViewById(R.id.listView_clothes);
            lvClothes.setAdapter(itemsAdapter);
            lvClothes.setLayoutManager(new LinearLayoutManager(this));
            setTitle("Category: Jackets");

        }
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.transition.slide_in_left, R.transition.slide_out_right);
    }
}

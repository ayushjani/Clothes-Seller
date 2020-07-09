package com.example.clothesseller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView hotDeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //all the views specific to their ID's in the layout file
        CardView t_ShirtsCardView = (CardView) findViewById(R.id.cardTShirts);
        CardView pantsCardView = (CardView) findViewById(R.id.cardPants);
        CardView jacketsCardView = (CardView) findViewById(R.id.cardJackets);
        final SearchView searchView = (SearchView) findViewById(R.id.searchBar);


        List<Clothes> salesList = ClothesProvider.getSaleitems();
        final HotDealsAdapter DealsAdapter = new HotDealsAdapter(this, R.layout.hot_deals_layout, salesList);

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        hotDeals = (RecyclerView) findViewById(R.id.top_picks);
        hotDeals.setAdapter(DealsAdapter);
        hotDeals.setLayoutManager(horizontalLayoutManager);

        //onlclick listeners to send an intent to the clothes activity depending on what cardview is selected
        t_ShirtsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tShirtsIntent = new Intent(getBaseContext(), ClothesActivity.class);
                tShirtsIntent.putExtra("category", "TShirt");
                startActivity(tShirtsIntent);
                overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);

            }
        });

        jacketsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent jacketsIntent = new Intent(getBaseContext(), ClothesActivity.class);
                jacketsIntent.putExtra("category", "Jackets");
                startActivity(jacketsIntent);
                overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);

            }
        });

        pantsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pantsIntent = new Intent(getBaseContext(), ClothesActivity.class);
                pantsIntent.putExtra("category", "Pants");
                startActivity(pantsIntent);
                overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);

            }
        });


        //checking if the search bar is selected to take the user to the search activity
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent searchIntent = new Intent(getBaseContext(), SearchActivity.class);
                startActivity(searchIntent);

            }
        });



    }

}
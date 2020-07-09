package com.example.clothesseller;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


//TODO Message when search results have nothing
public class SearchActivity extends AppCompatActivity {

    RecyclerView mySearchList;
    ClothesAdaptor clothesAdaptor;
    SearchView mySearchView;
    TextView emptyFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //generate a list of clothes
        List<Clothes> list = new ArrayList<>();
        list.addAll(ClothesProvider.getTShirts());
        list.addAll(ClothesProvider.getPants());
        list.addAll(ClothesProvider.getJackets());

        mySearchList = findViewById(R.id.searchList);
        mySearchView = findViewById(R.id.searchBar);
        emptyFilter = findViewById(R.id.empty_filter_text);

        //reuses the same adaptor which can take the user to the details activity
        clothesAdaptor = new ClothesAdaptor(this, R.layout.clothes_list_view_item,list);
        mySearchList.setAdapter(clothesAdaptor);
        mySearchList.setLayoutManager(new LinearLayoutManager(this));



        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                clothesAdaptor.getFilter().filter(newText);

                //check if the list has no elements to change the visibility of a view to display a message to the user

                if (clothesAdaptor.getItemCount()==0) {
                    emptyFilter.setVisibility(View.VISIBLE);


                } else if (clothesAdaptor.getItemCount() != 0){
                    emptyFilter.setVisibility(View.GONE);

                }
                return true;
            }
        });

    }

}
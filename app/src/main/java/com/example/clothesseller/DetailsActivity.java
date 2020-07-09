package com.example.clothesseller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;

//TODO Implement details and also add separators between sections of the details screen
public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "item";

    ViewPager viewPager;

    private TextView tvItemName;
    private TextView tvItemDes;
    private TextView tvItemPrice;
    private TextView tvItemType;
    private TextView tvItemViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvItemName = (TextView)findViewById(R.id.itemName);
        tvItemDes = (TextView)findViewById(R.id.itemDescription);
        tvItemPrice = (TextView)findViewById(R.id.itemPrice);
        tvItemType = (TextView)findViewById(R.id.itemtype);
        tvItemViews = (TextView)findViewById(R.id.ItemViews);

        Intent thisIntent = getIntent();

        getIncomingIntent(thisIntent);

    }

    private void getIncomingIntent(Intent intent){
        if(intent.hasExtra(EXTRA_ITEM)){
            Clothes item = (Clothes) intent.getSerializableExtra(ClothesAdaptor.EXTRA_ITEM);
            setItemDetails(item);
            overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
        }
    }

    private void setItemDetails(Clothes item){

        //Sets the app bar title to Name of selected item
        this.setTitle(item.getName());


        //Sets the name shown in the detailed view to the name of the selected item
        this.tvItemName.setText(item.getName());

        this.tvItemDes.setText(item.getDescription());
        this.tvItemPrice.setText(item.getPrice());
        this.tvItemType.setText(item.getCategory());
        this.tvItemViews.setText(item.getViews());

        //Gets the ids of the images of the selected item, prep work for the Image slider
        int selectedItemImageID1 = this.getBaseContext().getResources().getIdentifier(item.getImageFileName1(), "drawable", getBaseContext().getPackageName());
        int selectedItemImageID2 = this.getBaseContext().getResources().getIdentifier(item.getImageFileName2(), "drawable", getBaseContext().getPackageName());
        int selectedItemImageID3 = this.getBaseContext().getResources().getIdentifier(item.getImageFileName3(), "drawable", getBaseContext().getPackageName());

        Integer[] itemsImages = {selectedItemImageID1, selectedItemImageID2, selectedItemImageID3};

        //Creates a ViewPager used to make the image slider
        viewPager = (ViewPager)findViewById(R.id.myViewPager);
        ImageAdapter imageAdapter = new ImageAdapter(this,itemsImages);
        viewPager.setAdapter(imageAdapter);

    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.transition.slide_in_left, R.transition.slide_out_right);
    }

}
package com.example.clothesseller;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ClothesAdaptor extends RecyclerView.Adapter<ClothesAdaptor.ViewHolder> implements Filterable {

    public static final String EXTRA_ITEM = "item";
    private int tLayoutID;
    private List<Clothes> tClothes;
    private List<Clothes> getTClothesFiltered;
    private Context tContext;



    public ClothesAdaptor(@NonNull Context context, int resource, @NonNull List<Clothes> objects) {
        tLayoutID = resource;
        tContext = context;
        tClothes = objects;
        this.getTClothesFiltered=tClothes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(tContext).inflate(R.layout.clothes_list_view_item, parent, false));


    }

    //function sets the unused views off-screen to have the data displayed accordingly
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //gets the specific clothes item with a reference to its position in the list
        final Clothes currentClothes = tClothes.get(position);

        //setting the views with the ids, using the getters on the object to get the relevant information
        //specific to this clothes object
        holder.tvItemName.setText(currentClothes.getName());
        holder.tvItemPrice.setText(currentClothes.getPrice());

        int i = tContext.getResources().getIdentifier(currentClothes.getImageFileName1(), "drawable", tContext.getPackageName());
        holder.ivImage1.setImageResource(i);


        //the intent to take you to the details activity is done here with the onclick listener method
        //the specific clothes object is set here to be passed through to the details activity to prepare the views
        //used by the search activity and the clothes activity
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent itemIntent = new Intent(tContext, DetailsActivity.class);
                itemIntent.putExtra(DetailsActivity.EXTRA_ITEM, currentClothes);
                tContext.startActivity(itemIntent);
            }
        });

    }

    //returns the size of the clothes list
    @Override
    public int getItemCount() {

        return this.tClothes.size();

    }

    //overrided function to filter out the list for the search activity
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {



            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();

                //checks the character sequence provided against the names of all the items
                //if the string matches then it will be added to the list to be displayed in the search activity
                if(constraint == null || constraint.length() == 0) {

                    filterResults.count = getTClothesFiltered.size();
                    filterResults.values = getTClothesFiltered;
                } else {
                    String searchCharacter = constraint.toString().toLowerCase();

                    List<Clothes> resultsData = new ArrayList<>();

                    for( Clothes clothes: getTClothesFiltered){
                        if(clothes.getName().toLowerCase().contains(searchCharacter)) {

                            resultsData.add(clothes);
                        }
                    }


                    filterResults.count = resultsData.size();
                    filterResults.values = resultsData;

                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                //updates the list of clothes with the newly filtered list
                //also tells when the list has been changed
                tClothes = (List<Clothes>) filterResults.values;
                notifyDataSetChanged();

            }
         };

        return filter;
    }

    //tidy method to store all the used views and assign them to the relevant IDs for the cardviews.
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImage1;
        private TextView tvItemName;
        private TextView tvItemPrice;
        private View parentView;

        public ViewHolder (@NonNull View view) {
            super(view);
            this.parentView = view;
            this.ivImage1 = (ImageView) view.findViewById(R.id.clothes_image_view);
            this.tvItemName = (TextView) view.findViewById(R.id.clothes_text_view);
            this.tvItemPrice = (TextView)view.findViewById(R.id.clothes_price_view);
        }
    }


}

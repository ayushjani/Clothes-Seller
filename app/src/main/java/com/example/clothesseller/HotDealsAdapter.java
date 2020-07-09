package com.example.clothesseller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HotDealsAdapter extends RecyclerView.Adapter<HotDealsAdapter.ViewHolder> {

    public static final String EXTRA_ITEM = "item";
    private int tLayoutID;
    private List<Clothes> tClothes;
    private Context tContext;

    public HotDealsAdapter(@NonNull Context context, int resource, @NonNull List<Clothes> objects) {
    tLayoutID = resource;
    tContext = context;
    tClothes = objects;
    }

    @NonNull
    @Override
    public HotDealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotDealsAdapter.ViewHolder(
                LayoutInflater.from(tContext).inflate(R.layout.hot_deals_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HotDealsAdapter.ViewHolder holder, int position) {

        final Clothes currentClothes = tClothes.get(position);
        holder.tvItemName.setText(currentClothes.getName());
//      holder.tvItemView.setText(currentClothes.getViews() + " Views");
        holder.tvItemPrice.setText(currentClothes.getPrice());


        int i = tContext.getResources().getIdentifier(currentClothes.getImageFileName1(), "drawable", tContext.getPackageName());
        holder.ivImage1.setImageResource(i);

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent itemIntent = new Intent(tContext, DetailsActivity.class);
                itemIntent.putExtra(DetailsActivity.EXTRA_ITEM, currentClothes);
                tContext.startActivity(itemIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.tClothes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivImage1;
        private TextView tvItemName;
//      private TextView tvItemView;
        private TextView tvItemPrice;

        private View parentView;

        public ViewHolder (@NonNull View view) {
            super(view);
            this.parentView = view;
            this.ivImage1 = (ImageView) view.findViewById(R.id.hot_deals_image);
            this.tvItemName = (TextView)view.findViewById(R.id.hot_deals_item);
//            this.tvItemView = (TextView)view.findViewById(R.id.top_views);
            this.tvItemPrice = (TextView)view.findViewById(R.id.hot_deals_price);

        }
    }
}
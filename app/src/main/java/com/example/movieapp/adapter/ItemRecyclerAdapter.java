package com.example.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.MovieDetails;
import com.example.movieapp.R;
import com.example.movieapp.model.CategoryItem;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {
Context context;
List<CategoryItem> categoryItemList;

    public ItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_recycler_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Glide.with(context).load(categoryItemList.get(position).getPoster_path()).into(holder.itemImage);
   holder.itemImage.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent i=new Intent(context, MovieDetails.class);
           i.putExtra("movieId",categoryItemList.get(position).getId());
           i.putExtra("movieName",categoryItemList.get(position).getOriginal_title());
           i.putExtra("movieImageUrl",categoryItemList.get(position).getPoster_path());
           i.putExtra("movieFile",categoryItemList.get(position).getVideo());
           context.startActivity(i); }
   });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class ItemViewHolder extends  RecyclerView.ViewHolder{
ImageView itemImage;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage=itemView.findViewById(R.id.item_image);
        }
    }
}
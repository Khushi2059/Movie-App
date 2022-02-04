package com.example.movieapp.ui.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.data.model.CategoryItemData;
import com.example.movieapp.ui.main.view.MovieDetailsActivity;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {
    Context context;
    List<CategoryItemData> categoryItemList;

    public ItemRecyclerAdapter(Context context, List<CategoryItemData> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    public void setAdapter(List<CategoryItemData> categoryItemList) {
        this.categoryItemList = categoryItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_recycler_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Glide.with(context).load(categoryItemList.get(position).getPoster_path()).into(holder.itemImage);
        holder.itemImage.setOnClickListener(view -> {
            Intent i = new Intent(context, MovieDetailsActivity.class);
            i.putExtra("movieId", categoryItemList.get(position).getId());
            i.putExtra("movieName", categoryItemList.get(position).getOriginal_title());
            i.putExtra("movieImageUrl", categoryItemList.get(position).getPoster_path());
            i.putExtra("movieFile", categoryItemList.get(position).getVideo());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}
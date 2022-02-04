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
import com.example.movieapp.data.model.MovieData;
import com.example.movieapp.ui.main.view.MovieDetailsActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    public final Context mcontext;
    private List<MovieData> mData;

    public RecyclerViewAdapter(Context mcontext, List<MovieData> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    public void SetAdapter(List<MovieData> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        v = inflater.inflate(R.layout.cat_recycler_row_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(mcontext)
                .load("https://image.tmdb.org/t/p/original" + mData.get(holder.getAdapterPosition()).getPoster_path())
                .into(holder.poster_path);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mcontext, MovieDetailsActivity.class);
                i.putExtra("id", mData.get(holder.getAdapterPosition()).getId());
                i.putExtra("original_name", mData.get(holder.getAdapterPosition()).getOriginal_title());
                i.putExtra("poster_path", "https://image.tmdb.org/t/p/original" + mData.get(holder.getAdapterPosition()).getPoster_path());
                i.putExtra("movieFile", mData.get(holder.getAdapterPosition()).getVideo());
                mcontext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView poster_path;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            poster_path = itemView.findViewById(R.id.item_image);
        }
    }

}

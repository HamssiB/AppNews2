package com.me.appnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public TextView newsTitle;
        public ImageView newsImage;
        public TextView newsTimestamp;

        public NewsViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsImage = itemView.findViewById(R.id.newsImage);
            newsTimestamp = itemView.findViewById(R.id.newsTime);
        }
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.newsTitle.setText(news.title);
        holder.newsTimestamp.setText(news.timestamp);
        // Utilisez une bibliothèque comme Glide ou Picasso pour charger l'image
        // Glide.with(context).load(news.imageUrl).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}

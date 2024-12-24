
package com.me.appnews;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ViewPager2 carouselViewPager;
    private RecyclerView newsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Configurer la liste des actualités
        newsRecyclerView = findViewById(R.id.newsRecyclerView);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("Title 1", "https://example.com/image1.jpg", "2 hours ago"));
        newsList.add(new News("Title 2", "https://example.com/image2.jpg", "3 hours ago"));
        newsRecyclerView.setAdapter(new NewsAdapter(this, newsList));
    }
}

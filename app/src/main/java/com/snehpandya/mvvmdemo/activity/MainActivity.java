package com.snehpandya.mvvmdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.snehpandya.mvvmdemo.R;
import com.snehpandya.mvvmdemo.data.ArticleAdapter;
import com.snehpandya.mvvmdemo.databinding.MainAB;
import com.snehpandya.mvvmdemo.model.Article;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainAB binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);


        List<Article> articleList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            articleList.add(new Article("Article " + i, i, true));
        }

        ArticleAdapter articleAdapter = new ArticleAdapter(articleList, this);
        binding.recyclerview.setAdapter(articleAdapter);
    }
}

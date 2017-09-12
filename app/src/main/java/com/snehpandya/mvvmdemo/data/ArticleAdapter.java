package com.snehpandya.mvvmdemo.data;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snehpandya.mvvmdemo.R;
import com.snehpandya.mvvmdemo.databinding.ListItemBinding;
import com.snehpandya.mvvmdemo.model.Article;
import com.snehpandya.mvvmdemo.viewmodel.ArticleViewModel;

import java.util.List;

/**
 * Created by Sneh on 12-09-2017.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private List<Article> mArticles;
    private Context mContext;

    public ArticleAdapter(List<Article> articles, Context context) {
        mArticles = articles;
        mContext = context;
    }

    @Override
    public ArticleAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ArticleViewHolder holder, int position) {
        ListItemBinding binding = holder.binding;
        binding.setViewModel(new ArticleViewModel(mArticles.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding binding;

        public ArticleViewHolder(ListItemBinding binding) {
            super(binding.linearlayout);
            this.binding = binding;
        }
    }
}

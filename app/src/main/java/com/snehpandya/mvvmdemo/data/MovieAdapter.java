package com.snehpandya.mvvmdemo.data;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.snehpandya.mvvmdemo.R;
import com.snehpandya.mvvmdemo.databinding.ListAB;
import com.snehpandya.mvvmdemo.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sneh.pandya on 13/09/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/w342";
    private List<Result> mList;

    public MovieAdapter(List<Result> list) {
        this.mList = list;
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListAB binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        Picasso.with(holder.mListItemBinding.getRoot().getContext())
                .load(IMAGE_URL + mList.get(position).getPosterPath())
                .into(holder.mListItemBinding.imageview);
        holder.mListItemBinding.imageview.setMinimumHeight(340);
        holder.mListItemBinding.imageview.setAdjustViewBounds(true);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private ListAB mListItemBinding;

        MovieViewHolder(ListAB binding) {
            super(binding.getRoot());
            this.mListItemBinding = binding;
        }
    }
}
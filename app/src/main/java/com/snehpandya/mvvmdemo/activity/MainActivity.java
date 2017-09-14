package com.snehpandya.mvvmdemo.activity;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.snehpandya.mvvmdemo.R;
import com.snehpandya.mvvmdemo.data.MovieAdapter;
import com.snehpandya.mvvmdemo.databinding.MainAB;
import com.snehpandya.mvvmdemo.model.Result;
import com.snehpandya.mvvmdemo.viewmodel.MoviesViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MoviesViewModel mMoviesViewModel = new MoviesViewModel();
    private List<Result> mResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMoviesViewModel.getMovies();

        MainAB binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMoviesViewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                mResults = ((MoviesViewModel) observable).getResults();
                MovieAdapter mMovieAdapter = new MovieAdapter(mResults);
                binding.recyclerview.setAdapter(mMovieAdapter);
            }
        });

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

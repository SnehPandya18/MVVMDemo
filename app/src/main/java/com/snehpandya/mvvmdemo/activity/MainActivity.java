package com.snehpandya.mvvmdemo.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.snehpandya.mvvmdemo.R;
import com.snehpandya.mvvmdemo.databinding.MainAB;
import com.snehpandya.mvvmdemo.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainAB binding;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainViewModel();
        mViewModel.setGreet("Hola!");
        binding.setViewModel(mViewModel);
    }
}

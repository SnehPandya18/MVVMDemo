package com.snehpandya.mvvmdemo.viewmodel;

/**
 * Created by Sneh on 11-09-2017.
 */

public class MainViewModel {

    private String greet = "Hello!";

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }
}

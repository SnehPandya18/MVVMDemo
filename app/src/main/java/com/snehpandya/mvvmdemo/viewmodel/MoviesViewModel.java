package com.snehpandya.mvvmdemo.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.snehpandya.mvvmdemo.BR;
import com.snehpandya.mvvmdemo.apiservice.RetrofitService;
import com.snehpandya.mvvmdemo.model.Response;
import com.snehpandya.mvvmdemo.model.Result;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sneh.pandya on 13/09/17.
 */

public class MoviesViewModel extends BaseObservable {

    private List<Result> results = new ArrayList<>();
    private RetrofitService retrofitService = new RetrofitService();

    public MoviesViewModel() {
    }

    @Bindable
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
        notifyPropertyChanged(BR.results);
    }

    public void getMovies() {
        io.reactivex.Observable<Response> responseObservable = retrofitService.mTMDBApi.popularResponse("YOUR_API_KEY", 1);
        responseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateView, this::handleError);
    }

    private void updateView(Response response) {
        List<Result> results = response.getResults();
        setResults(results);
    }

    private void handleError(Throwable throwable) {
        Log.d("TAG", "handleError: " + throwable);
    }
}
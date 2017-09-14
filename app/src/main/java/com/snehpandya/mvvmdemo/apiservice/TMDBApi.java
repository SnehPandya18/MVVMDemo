package com.snehpandya.mvvmdemo.apiservice;

import com.snehpandya.mvvmdemo.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sneh.pandya on 13/09/17.
 */

public interface TMDBApi {


    @GET("3/movie/popular")
    Observable<Response> popularResponse(@Query("api_key") String key, @Query("page") int page);
}

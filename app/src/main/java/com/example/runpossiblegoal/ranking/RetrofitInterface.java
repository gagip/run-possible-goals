package com.example.runpossiblegoal.ranking;

import com.example.runpossiblegoal.sqlite.Pedometer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @GET("ranking/{rank}")
    Call<Rank> getRank(@Path("rank") int rank);

    @POST("write/")
    Call<Rank> write(Pedometer pedometer);
}


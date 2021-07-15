package com.example.runpossiblegoal.ranking;

import com.google.gson.annotations.SerializedName;


public class Rank {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("stepCount")
    public String stepCount;


    // toString()을 Override 해주지 않으면 객체 주소값을 출력함
    @Override
    public String toString() {
        return "PostResult{" +
                "id=" +id +
                ", name=" + name +
                ", stepCount=" + stepCount + '\'' +
                '}';
    }
}
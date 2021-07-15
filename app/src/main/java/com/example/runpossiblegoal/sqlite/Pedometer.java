package com.example.runpossiblegoal.sqlite;


import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pedometer")
public class Pedometer {

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    @SerializedName("id")
    private int _id;

    @DatabaseField
    @SerializedName("startTime")
    private long startTime;

    @DatabaseField
    @SerializedName("endTime")
    private long endTime;

    @DatabaseField
    @SerializedName("stepCount")
    private int stepCount;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }
}

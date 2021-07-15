package com.example.runpossiblegoal.sqlite;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static DBManager instance;
    private DBManager() {}
    public static DBManager getInstance() {
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    private DBBaseHelper dbHelpter;

    public void setDBhelpter(Context context) {
        dbHelpter = new DBBaseHelper(context);
    }

    public List<Pedometer> getPedometerList(){
        List<Pedometer> pedometers = new ArrayList<>();
        try{
            Dao<Pedometer, Integer> dao = dbHelpter.getStandardInfosDao();
            pedometers = dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedometers;
    }


    public void insertPeodomter(Pedometer pedometer) {
        try {
            dbHelpter.getStandardInfosDao().create(pedometer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

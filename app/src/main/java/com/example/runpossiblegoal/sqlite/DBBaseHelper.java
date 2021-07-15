package com.example.runpossiblegoal.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBBaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "pedometer.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Pedometer,Integer> dao;

    public DBBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Pedometer.class);  //Table 생성
        } catch (SQLException e) {
            Log.e(OrmLiteSqliteOpenHelper.class.getName(), "Unable to create datbases", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Pedometer.class, true);    //업데이트시 테이블 삭제
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(OrmLiteSqliteOpenHelper.class.getName(),
                    "Unable to upgrade database from version " + oldVersion + " to new " + newVersion, e);
        }
    }

    public Dao<Pedometer, Integer> getStandardInfosDao() throws SQLException {
        if (dao == null) {
            dao = getDao(Pedometer.class);
        }
        return dao;
    }
}

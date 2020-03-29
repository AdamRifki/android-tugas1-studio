package com.example.myapplication2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Databasehelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbjadwal.db";
    private static final int DATABASE_VERSION = 1;

    public Databasehelper(Context context){
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    //TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db){
     //TODO Auto-generated constructor stub
     String sql = "create table tbjadwal(no integer primary key," +
                    "namamk text null," +
                    "kelas text null," +
                    "hari text null," +
                    "jam text null," +
                    "ruangan text null," +
                    "namadosen text null);";
     Log.d("Data", "onCreate: " + sql);
     db.execSQL(sql);
     sql = "INSERT INTO tbjadwal(no, namamk, kelas, hari, jam, ruangan, namadosen) VALUES('1', 'Pemrograman Java', 'IFB3D', 'Senin', '10:30', 'Lab C', 'Nasrudin bin Idris');";
     db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
        //TODO Auto-generated constructor stub
    }
}

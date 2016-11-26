package com.imoon.app.imoonapp.movie;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public class MovieDAO extends SQLiteOpenHelper {
    public MovieDAO(Context context) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }


    public void add(MovieDTO param){
        String sql = String.format("INSERT INTO Movie(column1,column2) VALUES('%s','%s');");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();

    }
    public int count(){
        String sql = String.format("SELECT COUNT(*) FROM Movie;");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        return 0;
    }
    public MovieDTO findOne(String key){
        String sql = String.format("SELECT * FROM Movie WHERE column = '%s';",key);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        return null;
    }
    public ArrayList<MovieDTO> findBy(MovieDTO param){
        String sql = String.format("SELECT * FROM Movie WHERE column = '%s';");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        return  null;
    }
    public ArrayList<MovieDTO> list(){
        String sql = "SELECT * FROM Movie;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        return  null;
    }
    public void update(MovieDTO param){
        String sql = String.format("UPDATE Movie SET column1 = '%s', column2 = '%s' WHERE column = '%s';");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public void delete(String key){
        String sql = String.format("DELETE FROM Movie WHERE column = '%s';", key);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
}

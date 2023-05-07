package com.example.seryoso_na_rekap.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLInput;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_name = "Userdata.db";
    private static final String DB_table = "UserNotes";
    private String id;


    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table " +  DB_table + "(title TEXT primary key, notes TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists UserNotes");
    }

    public Boolean insertuserData(String title, String notes){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("notes",notes);
        long result = DB.insert("UserNotes", null, contentValues);
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean Update_userData(String title, String notes){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("notes",notes);
        Cursor cursor = DB.rawQuery("Select * from UserNotes where name = ?", new String[]{title});
        if (cursor.getCount()>0) {
            long result = DB.update("UserNotes", contentValues, "name=?", new String[]{title});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else
        {
            return false;
        }
    }

    public Boolean Delete_userData(String title, String notes) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from UserNotes where name = ?", new String[]{title});
        if (cursor.getCount() > 0) {
            long result = DB.delete("UserNotes", "name=?", new String[]{title});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from UserNotes", null);
        return cursor;
    }

}

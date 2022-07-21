package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="user.db";
    public static final String TABLE_NAME="info";
    public static final String ID="id";
    public static final String NAME="name";
    public static final String PASSWORD="password";
    public static final int DB_VERSION=1;


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = ("CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + PASSWORD + " TEXT" + ")");
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String upquery="drop table if exists "+TABLE_NAME;
        sqLiteDatabase.execSQL(upquery);

    }

    public long savedata(Model m)
    {
     SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(NAME,m.getName());
        values.put(PASSWORD,m.getPass());

        //sqLiteDatabase.insert(TABLE_NAME,ID,values);
        long data = sqLiteDatabase.insert(TABLE_NAME,ID,values);

        return data;

    }





}

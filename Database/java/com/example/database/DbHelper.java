package com.example.database;

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
    public static final String NUMBER="number";
    public static final int DB_VERSIOn=1;
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSIOn);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query= ("CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + NUMBER + " TEXT" + ")");
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String upquery="drop table if exists "+TABLE_NAME;
        sqLiteDatabase.execSQL(upquery);
    }
    public Long savedata(Model m)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(NAME,m.getName());
        values.put(NUMBER,m.getNumber());

        long data=db.insert(TABLE_NAME,ID,values);
        return data;
    }

    public List<Model> viewdata()
    {
        ArrayList<Model> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String col[]={ID,NAME,NUMBER};
        Cursor cursor=db.query(TABLE_NAME,col,null,null,null,null,null);
        while(cursor.moveToNext())
        {
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String number=cursor.getString(2);

            Model m =new Model();
            m.setId(id);
            m.setName(name);
            m.setNumber(number);
            list.add(m);



        }

        return list;
    }
}

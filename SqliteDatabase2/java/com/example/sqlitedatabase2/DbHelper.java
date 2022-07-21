package com.example.sqlitedatabase2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION=1;
    public static final String DB_NAME="user.db";
    public static final String TABLE_NAME="info";
    public static final String ID="id";
    public static final String NAME="name";
    public static final String NUMBER="number";


    public DbHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
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
        String upquery = " drop table if exists "+TABLE_NAME;
        sqLiteDatabase.execSQL(upquery);
    }

    public long insert(Model model)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(NAME,model.getName());
        values.put(NUMBER,model.getNumber());

        long id = sqLiteDatabase.insert(TABLE_NAME,ID,values);

        return id;
    }

    public List<Model> readdata()
    {
        ArrayList<Model> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String col[]={ID,NAME,NUMBER};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,col,null,null,null,null,null);

        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String name=cursor.getString(1);
            String number = cursor.getString(2);

            Model model = new Model();
            model.setId(id);
            model.setName(name);
            model.setNumber(number);
            list.add(model);
        }

        return list;
    }

    public void deletedata(int id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String delequery = ID+"="+id;
        sqLiteDatabase.delete(TABLE_NAME,delequery,null);
    }

    public void updatedata(Model model)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, model.getId());
        values.put(NAME,model.getName());
        values.put(NUMBER,model.getNumber());
        String updquery = ID+"="+model.getId();
        sqLiteDatabase.update(TABLE_NAME,values,updquery,null);
    }



}

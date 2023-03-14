package com.example.sqliteapplication.spinner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SpinnerDB";
    private static final String TABLE_NAME = "Products";
    private static final String productID = "ID";
    private static final String pname = "Name";

    public DataBaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table = "CREATE TABLE " + TABLE_NAME + " ( " + productID + " INTEGER PRIMARY KEY, " + pname + " TEXT )";
        sqLiteDatabase.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String table = "DROP TABLE IF EXISTS " + TABLE_NAME ;
        sqLiteDatabase.execSQL(table);
        onCreate(sqLiteDatabase);
    }

    public List<String> getAllItems() {
       List<String> list = new ArrayList<String>();

       String sql = "SELECT * FROM " + TABLE_NAME;
       SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToFirst())
        {
            do {
                list.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }

    public void insertItem(String item) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(pname,item);
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }
}

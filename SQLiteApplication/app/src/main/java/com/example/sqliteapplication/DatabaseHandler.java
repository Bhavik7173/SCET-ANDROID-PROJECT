package com.example.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AndroidDB";
    private static final String TABLE_NAME = "Contact";
    private static final String contactID = "contactID";
    private static final String cname = "contactName";
    private static final String cmobile = "contact";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void addContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(contactID,contact.getId());
        contentValues.put(cname, contact.getName());
        contentValues.put(cmobile, contact.getMobile());
        Log.d("scet_db_content",contentValues+"");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put(contactID, contact.getId());
        contentValues.put(cname, contact.getName());
        contentValues.put(cmobile, contact.getMobile());

        return db.update(TABLE_NAME, contentValues, contactID + "=?", new String[]{String.valueOf(contact.getId())});

    }

    public void deleteContact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,contactID+"=?",new String[]{String.valueOf(contact.getId())});
        db.close();
    }
    public List<Contact> getAllContact() {
        List<Contact> contactList = new ArrayList<Contact>();

        String sql = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                Log.d("scet_db_getallcontact",cursor.getString(0)+" : "+cursor.getString(1)+" : "+ cursor.getString(2)+" : ");
                contact.setId(cursor.getString(0));
                contact.setName(cursor.getString(1));
                contact.setMobile(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + contactID + " INTEGER PRIMARY KEY," + cname + " TEXT, " + cmobile
                + " TEXT " + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

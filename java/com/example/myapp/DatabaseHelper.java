package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;
    private Object ContentValues;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    private static final String TABLE_CREATE = "create table contacts (id INTEGER primary key not null  , " +
            "username TEXT not null , password TEXT not null);";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USERNAME , c.getUsername());
        values.put(COLUMN_PASSWORD , c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public String searchPass(String username){
        db = this.getReadableDatabase();
        String query = "select username, password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        //a is username and b is password
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()){
            do {
              a = cursor.getString(0);
              if (a.equals(username)){
                  b = cursor.getString(1);
                  break;
              }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

package com.techlabs.paresh.testsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, int version) {
        super(context, name, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table authenticateLogin " +
                        "(username text primary key, password text)"
        );
        ContentValues values = new ContentValues();
        values.put("username", "deval");
        values.put("password", "pass@123");
        db.insert("authenticateLogin", null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }

    public boolean authenticateUser(String username1, String password1) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM authenticateLogin WHERE username='" + username1 + "' AND password='" + password1+"'";
        Cursor c=db.rawQuery(selectQuery,null);
        Log.d("count",""+c.getCount());

        c.moveToFirst();
        if(c.getCount()>0){
            return true;
        }
        return false;
    }
}

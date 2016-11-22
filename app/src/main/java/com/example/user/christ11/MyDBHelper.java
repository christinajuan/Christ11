package com.example.user.christ11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2016/11/21.
 */

public class MyDBHelper extends SQLiteOpenHelper{
    private String creatETable =
            "CREATE TABLE cust(id INTEGER PRIMARY KEY AUTOINCREMENT, cname TEXT,birthday DATE, tel TEXT)";

    public MyDBHelper(Context context, String name,
                      SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(creatETable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

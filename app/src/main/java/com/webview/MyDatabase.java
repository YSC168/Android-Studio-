package com.webview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String CREAT_BOOK="create table Book("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "pages integer,"
            + "name text)";

    public static final String CREAT_GATEGORY="create table Category("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "pages integer,"
            + "name text)";
    private Context mContext;
    public MyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAT_BOOK);
        sqLiteDatabase.execSQL(CREAT_GATEGORY);
        Toast.makeText(mContext,"creat success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("drop table if exists Book");
sqLiteDatabase.execSQL("drop table if exists Category");
onCreate(sqLiteDatabase);
    }
}

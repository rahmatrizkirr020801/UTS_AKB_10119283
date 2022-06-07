/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.rahmatullahrizki.uts_akb_10119283.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// selasa 7 juni 2022, 1011983, Rahmatullah Rizki, IF7

public class DataHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "harian.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE catatan(id TEXT PRIMARY KEY,  judul text not null, isi text not null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg, int arg1, int arg2) {

    }


}

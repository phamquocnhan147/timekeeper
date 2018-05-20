package com.example.us.quocnhan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.Time;

/**
 * Created by us on 14/04/18.
 */

public class car extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Time";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "timekeeper";
    private static final String ID = "_id";
    private static final String day = "ngay";
    private static final String month = "thang";
    private static final String year = "nam";
    private static final String hour = "gio";
 ;

    public car(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = " create table " + TABLE_NAME +
                "("+
                ID + " integer primary key autoincrement, " +
                day + " text, " +
                month + " text, " +
                year + " text, " +
                hour + " text, " +


                ")";
        sqLiteDatabase.execSQL(sql);
        ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }


    public void taotime(String ngay, String thang, String nam, String gio){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues noidung = new ContentValues();
        noidung.put(day, String.valueOf(ngay));
        noidung.put(month, String.valueOf(thang));
        noidung.put(year, String.valueOf(nam));
        noidung.put(hour, String.valueOf(gio));

        String nullColumHack = null;
        db.insert(TABLE_NAME, nullColumHack, noidung);
    }
    public Cursor getAllCar(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor con_tro = db.rawQuery("select * from " + TABLE_NAME, null);
        return con_tro;
    }
    public boolean xoatime(String maxe){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,day + " = " +"'"+maxe+"'",null)>0;
    }
    public  boolean suatime(String ngay, String thang, String nam, String gio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues noidung = new ContentValues();
        noidung.put(day, String.valueOf(ngay));
        noidung.put(month, String.valueOf(thang));
        noidung.put(year, String.valueOf(nam));
        noidung.put(hour, String.valueOf(gio));

        return db.update(TABLE_NAME,noidung,day+ " = " +"'"+ngay+"'",null)>0;
    }
}

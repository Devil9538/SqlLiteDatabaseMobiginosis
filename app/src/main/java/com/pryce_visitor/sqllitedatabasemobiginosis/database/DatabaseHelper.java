package com.pryce_visitor.sqllitedatabasemobiginosis.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pryce_visitor.sqllitedatabasemobiginosis.note.Note;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes_db";

    public DatabaseHelper( Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

//        used to create database
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        used to create table
//        this method is called only once by the android OS
            db.execSQL(Note.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveData(String note){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues con= new ContentValues();
        con.put(Note.COLUMN_NOTE,note);
        database.insert(Note.Table_Name,null,con);
        database.close();

    }

    public List<Note> readData(){

        List<Note> notes= new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Note.Table_Name + " ORDER BY " +
                Note.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(Note.Column_Id)));
                note.setData(cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

// close db connection
        db.close();

        return notes;

    }
}

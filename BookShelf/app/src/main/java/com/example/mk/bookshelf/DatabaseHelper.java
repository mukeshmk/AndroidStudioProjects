package com.example.mk.bookshelf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Admin on 05-01-2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private String TAG = this.getClass().getSimpleName();

    private static final String DATABASE_NAME = "books";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_BOOKS = "books";

    private static final String KEY_CODE = "code";
    private static final String KEY_BNAME = "bname";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_PRICE = "price";



    String CREATE_TABLE_CALL = "CREATE TABLE IF NOT EXISTS " + TABLE_BOOKS + "(" + KEY_CODE + " INTEGER," + KEY_BNAME + " TEXT," + KEY_AUTHOR + " TEXT," + KEY_PRICE
            + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Log.v(TAG, "CREATE TABLE CALL: " + CREATE_TABLE_CALL);
        db.execSQL(CREATE_TABLE_CALL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }

    public long createBook(Books books) {
        long c;

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CODE, books.getCode());
        values.put(KEY_BNAME, books.getName());
        values.put(KEY_AUTHOR, books.getAuthor());
        values.put(KEY_PRICE, books.getPrice());

        c = database.insert(TABLE_BOOKS, null, values);
        database.close();
        return c;

    }

    /* Method for fetching record from Database */
    public ArrayList<Books> getAllBooks() {
        String query = "SELECT DISTINCT " + KEY_CODE + ", " + KEY_BNAME + ", " + KEY_AUTHOR + ", " + KEY_PRICE + "  FROM " + TABLE_BOOKS;
        ArrayList<Books> books = new ArrayList<Books>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery(query, null);
        if (c != null) {
            while (c.moveToNext()) {
                int code = c.getInt(c.getColumnIndex(KEY_CODE));
                String name = c.getString(c.getColumnIndex(KEY_BNAME));
                String author = c.getString(c.getColumnIndex(KEY_AUTHOR));
                String price = c.getString(c.getColumnIndex(KEY_PRICE));

                Books book = new Books();
                book.setCode(code);
                book.setName(name);
                book.setAuthor(author);
                book.setPrice(price);

                /*Log.v("DBHelper: ", "Name: " + name);
                Log.v("DBHelper: ", "Code: " + code);
                Log.v("DBHelper: ", "Author: " + author);
                Log.v("DBHelper: ", "Price: " + price);*/

                books.add(book);
            }
        }

        return books;

    }
/* This method is used to get a single record from Database.
   I have given an example, you have to do something like this. */

    public Books getBooksByCode(int code) {
        String query = "SELECT * FROM " + TABLE_BOOKS + " WHERE " + KEY_CODE + " = " + code;
        Books books = new Books();
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery(query, null);

        if (c.getCount() > 0) {

            c.moveToFirst();
            code = c.getInt(c.getColumnIndex(KEY_CODE));
            String name = c.getString(c.getColumnIndex(KEY_BNAME));
            String author = c.getString(c.getColumnIndex(KEY_AUTHOR));
            String price = c.getString(c.getColumnIndex(KEY_PRICE));

            books.setCode(code);
            books.setName(name);
            books.setAuthor(author);
            books.setPrice(price);

            /*Log.v("DBHelper: ", "Name: " + name);
            Log.v("DBHelper: ", "Code: " + code);
            Log.v("DBHelper: ", "Author: " + author);
            Log.v("DBHelper: ", "Price: " + price);*/

        }
        return books;
    }
}
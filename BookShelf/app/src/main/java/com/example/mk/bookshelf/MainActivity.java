package com.example.mk.bookshelf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Books> bookList;
    MyAdapter adapter;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("books", Context.MODE_PRIVATE, null);

        gridView = (GridView) findViewById(R.id.gv_books);

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        //bookList = new ArrayList<Books>();

        databaseHelper.onCreate(db);
        Books b = new Books();

        b.setCode(1);
        b.setName("Harry Potter 1");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1200");
        databaseHelper.createBook(b);

        b.setCode(2);
        b.setName("Harry Potter 2");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1200");
        databaseHelper.createBook(b);

        b.setCode(3);
        b.setName("Harry Potter 3");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1200");
        databaseHelper.createBook(b);

        b.setCode(4);
        b.setName("Harry Potter 4");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1200");
        databaseHelper.createBook(b);

        bookList = databaseHelper.getAllBooks();
        adapter = new MyAdapter(MainActivity.this, bookList);
        gridView.setAdapter(adapter);

    }
}

package com.example.mk.bookshelfgo;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingList extends AppCompatActivity {

    GridView gridView;
    ArrayList<Books> bookList;
    MyAdapter adapter;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);

        db = openOrCreateDatabase("books", Context.MODE_PRIVATE, null);

        gridView = (GridView) findViewById(R.id.gv_books);

        DatabaseHelper databaseHelper = new DatabaseHelper(ShoppingList.this);
        //bookList = new ArrayList<Books>();

        databaseHelper.onCreate(db);
        Books b = new Books();

        b.setCode(1);
        b.setName("Harry Potter 1");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1000");
        databaseHelper.createBook(b);

        b.setCode(2);
        b.setName("Harry Potter 2");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1200");
        databaseHelper.createBook(b);

        b.setCode(3);
        b.setName("Harry Potter 3");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1400");
        databaseHelper.createBook(b);

        b.setCode(4);
        b.setName("Harry Potter 4");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1600");
        databaseHelper.createBook(b);

        b.setCode(5);
        b.setName("Harry Potter 5");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 1800");
        databaseHelper.createBook(b);

        b.setCode(6);
        b.setName("Harry Potter 6");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 2000");
        databaseHelper.createBook(b);

        b.setCode(7);
        b.setName("Harry Potter 7");
        b.setAuthor("J. K. Rowling");
        b.setPrice("Rs. 2200");
        databaseHelper.createBook(b);

        b.setCode(8);
        b.setName("Book 8");
        b.setAuthor("Author 8");
        b.setPrice("Rs. 2400");
        databaseHelper.createBook(b);

        b.setCode(9);
        b.setName("Book 9");
        b.setAuthor("Author 9");
        b.setPrice("Rs. 2600");
        databaseHelper.createBook(b);

        b.setCode(10);
        b.setName("Book 10");
        b.setAuthor("Author 10");
        b.setPrice("Rs. 2800");
        databaseHelper.createBook(b);

        b.setCode(11);
        b.setName("Book 11");
        b.setAuthor("Author 11");
        b.setPrice("Rs. 3000");
        databaseHelper.createBook(b);

        b.setCode(12);
        b.setName("Book 12");
        b.setAuthor("Author 12");
        b.setPrice("Rs. 3200");
        databaseHelper.createBook(b);


        bookList = databaseHelper.getAllBooks();
        adapter = new MyAdapter(ShoppingList.this, bookList);
        gridView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.cart:
                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(this,AddtoCart.class);
                startActivity(i1);
                break;
            case R.id.back:
                Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(this,Welcome.class);
                startActivity(i2);
                break;
            case R.id.logout:
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(this,LogIn.class);
                startActivity(i3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}

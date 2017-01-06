package com.example.mk.bookshelfgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddtoCart extends AppCompatActivity implements View.OnClickListener{

    TextView t1, t2 ,t3;
    Button buy;

    SharedPreferences sp;
    Books bk1 = new Books(), bk2  = new Books(), bk3 = new Books(), bk4 = new Books() ,bk5 = new Books();
    int b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addto_cart);

        t1 = (TextView)findViewById(R.id.bk1);
        t2 = (TextView)findViewById(R.id.bk2);
        t3 = (TextView)findViewById(R.id.bk3);

        buy = (Button)findViewById(R.id.buy);
        buy.setOnClickListener(this);

        SQLiteDatabase db = openOrCreateDatabase("books",Context.MODE_PRIVATE, null);
        DatabaseHelper databaseHelper = new DatabaseHelper(AddtoCart.this);
        databaseHelper.onCreate(db);

        sp = getSharedPreferences("cart", MODE_PRIVATE);

        b1 = sp.getInt("book0",0);
        bk1 = databaseHelper.getBooksByCode(b1);
        t1.setText(bk1.getName()+" "+bk1.getPrice());

        b2 = sp.getInt("book1",0);
        bk2 = databaseHelper.getBooksByCode(b2);
        t2.setText(bk2.getName()+" "+bk2.getPrice());

        b3 = sp.getInt("book2",0);
        bk3 = databaseHelper.getBooksByCode(b3);
        t3.setText(bk3.getName()+" "+bk3.getPrice());
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Thanks for shopping !!", Toast.LENGTH_SHORT).show();
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

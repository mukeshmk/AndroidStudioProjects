package com.example.mk.bookshelfgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetails extends AppCompatActivity implements View.OnClickListener {

    Button add, btm;
    Integer[] mThumbIds = {
            R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j,
            R.drawable.k, R.drawable.l,
    };
    String bname, author, price;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_details);

        Intent i0 = getIntent();

        bname = i0.getStringExtra("bname");
        author = i0.getStringExtra("author");
        price = i0.getStringExtra("price");
        pos = i0.getIntExtra("pos",0);

        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);

        btm = (Button) findViewById(R.id.btm);
        btm.setOnClickListener(this);

        ImageView img = (ImageView) findViewById(R.id.bimg);
        TextView bnametv = (TextView) findViewById(R.id.bname1);
        TextView authortv = (TextView) findViewById(R.id.bauthor);
        TextView pricetv = (TextView) findViewById(R.id.bprice);

        img.setImageResource(mThumbIds[pos]);
        bnametv.setText(bname);
        authortv.setText(author);
        pricetv.setText(price);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.add:
                break;

            case R.id.btm: Intent i = new Intent(this, ShoppingList.class);
                this.startActivity(i);
        }
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(this,LogIn.class);
                startActivity(i2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}

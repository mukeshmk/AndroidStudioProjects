package com.example.mk.bookshelfgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Welcome extends AppCompatActivity implements View.OnClickListener{

    Button shop, scanqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        scanqr = (Button)findViewById(R.id.scanqr);
        scanqr.setOnClickListener(this);

        shop = (Button)findViewById(R.id.shop);
        shop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scanqr:
                Intent i1 = new Intent(this,ScanQR.class);
                startActivity(i1);
                break;
            case R.id.shop:
                Intent i2 = new Intent(this,ShoppingList.class);
                startActivity(i2);
                break;
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

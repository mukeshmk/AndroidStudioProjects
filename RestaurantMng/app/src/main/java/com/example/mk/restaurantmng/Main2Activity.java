package com.example.mk.restaurantmng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    Button dinein, takeaway;
    TextView t;
    String un, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        un = i.getStringExtra("unm");
        pwd = i.getStringExtra("pwd");

        t = (TextView)findViewById(R.id.wel);
        t.setText("Welcome "+un+"!!");

        dinein = (Button)findViewById(R.id.dinein);
        dinein.setOnClickListener(this);
        takeaway = (Button)findViewById(R.id.takeaway);
        takeaway.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout r1 = (RelativeLayout) findViewById(R.id.activity_main);

        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Intent i4 = new Intent(this,MainActivity.class);
                startActivity(i4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dinein:
                Intent i5 = new Intent(this,Main5Activity.class);
                i5.putExtra("unm",un);
                startActivity(i5);

                break;
            case R.id.takeaway:
                Intent i6 = new Intent(this,Main6Activity.class);
                i6.putExtra("unm",un);
                startActivity(i6);

                break;
        }
    }
}

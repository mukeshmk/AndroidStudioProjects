package com.example.mk.votingsystem;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    TextView wel;
    RadioButton c1, c2, c3;
    Button vote;

    String un, vt;
    int flag=0;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        un = i.getStringExtra("unm");

        wel=(TextView) findViewById(R.id.wel);
        wel.setText("Welcome "+ un);

        c1 = (RadioButton) findViewById(R.id.c1);
        c2 = (RadioButton) findViewById(R.id.c2);
        c3 = (RadioButton) findViewById(R.id.c3);

        vote = (Button) findViewById(R.id.vote);
        vote.setOnClickListener(this);

        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS votes(uname VARCHAR,vote VARCHAR);");
    }

    @Override
    public void onClick(View v) {
        if(c1.isChecked()) {
            db.execSQL("INSERT INTO votes VALUES('"+un+"','1');");
            flag=1;
            vt="1";
        }
        else if(c2.isChecked()) {
            db.execSQL("INSERT INTO votes VALUES('"+un+"','2');");
            flag=1;
            vt="2";
        }
        else if(c3.isChecked()) {
            db.execSQL("INSERT INTO votes VALUES('"+un+"','3');");
            flag=1;
            vt="3";
        }

        Intent i = new Intent(this,Main4Activity.class);
        startActivity(i);
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
            case R.id.stat:
                Intent i2 = new Intent(this,Main5Activity.class);
                startActivity(i2);
                Toast.makeText(this, "Status", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Intent i3 = new Intent(this,MainActivity.class);
                startActivity(i3);
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

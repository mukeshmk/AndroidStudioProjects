package com.example.mk.votingsystem;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener{

    TextView c1, c2, c3;
    Button back, see;

    String con1="0", con2="0", con3="0";
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        c1 = (TextView)findViewById(R.id.c1);
        c2 = (TextView)findViewById(R.id.c2);
        c3 = (TextView)findViewById(R.id.c3);

        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(this);

        see = (Button)findViewById(R.id.see);
        see.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.see:
                db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
                Cursor c=db.rawQuery("SELECT COUNT(vote) FROM votes WHERE vote=1", null);

                if(c.getCount()==0)
                {
                    return;
                }
                while(c.moveToNext())
                {
                    con1 = c.getString(0);
                    c1.setText("No of Votes for Contestent 1 :"+con1);
                }
                c=db.rawQuery("SELECT COUNT(vote) FROM votes WHERE vote=2", null);
                if(c.getCount()==0)
                {
                    return;
                }
                while(c.moveToNext())
                {
                    con2 = c.getString(0);
                    c2.setText("No of Votes for Contestent 2 :"+con2);
                }
                c=db.rawQuery("SELECT COUNT(vote) FROM votes WHERE vote=3", null);
                if(c.getCount()==0)
                {
                    return;
                }
                while(c.moveToNext())
                {
                    con3 = c.getString(0);
                    c3.setText("No of Votes for Contestent 3 :"+con3);
                }
                break;
            case R.id.back:
                Intent i1 = new Intent(this,MainActivity.class);
                startActivity(i1);
                break;
        }
    }
}

package com.example.mk.restaurantmng;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity implements  View.OnClickListener{

    String qty[];
    EditText qtys1, qtys2, qtya1, qtya2, qtym1, qtym2, qtyd1, qtyd2;
    CheckBox cs1, cs2, ca1, ca2, cm1, cm2, cd1, cd2;
    Button order;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        qty = new String[]{"1","2","3"};

        qtys1 = (EditText) findViewById(R.id.qtys1);

        qtys2 = (EditText) findViewById(R.id.qtys2);

        qtya1 = (EditText) findViewById(R.id.qtya1);

        qtya2 = (EditText) findViewById(R.id.qtya2);


        qtym1 = (EditText) findViewById(R.id.qtym1);

        qtym2 = (EditText) findViewById(R.id.qtym2);

        qtyd1 = (EditText) findViewById(R.id.qtyd1);

        qtyd2 = (EditText) findViewById(R.id.qtyd2);


        cs1=(CheckBox)findViewById(R.id.cs1);
        cs2=(CheckBox)findViewById(R.id.cs2);
        ca1=(CheckBox)findViewById(R.id.ca1);
        ca2=(CheckBox)findViewById(R.id.ca2);
        cm1=(CheckBox)findViewById(R.id.cm1);
        cm2=(CheckBox)findViewById(R.id.cm2);
        cd1=(CheckBox)findViewById(R.id.cd1);
        cd2=(CheckBox)findViewById(R.id.cd2);

        order=(Button)findViewById(R.id.order);
        order.setOnClickListener(this);

    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();


    }

    @Override
    public void onClick(View v) {

        db = openOrCreateDatabase("rest", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS REST(Menu_items VARCHAR(20),Qty VARCHAR(20));");

        if(cs1.isChecked())
            db.execSQL("INSERT INTO REST VALUES('"+cs1.getText()+"','"+qtys1.getText()+"');");

        if(cs2.isChecked())
            db.execSQL("INSERT INTO REST VALUES('"+cs2.getText()+"','"+qtys2.getText()+"');");

        if(ca1.isChecked())
            db.execSQL("INSERT INTO REST VALUES('"+ca1.getText()+"','"+qtya1.getText()+"');");

        if(ca2.isChecked())
            db.execSQL("INSERT INTO REST VALUES('"+ca2.getText()+"','"+qtya2.getText()+"');");

        if(cm1.isChecked())
            db.execSQL("INSERT INTO REST VALUES('"+cm1.getText()+"','"+qtym1.getText()+"');");

        if(cm2.isChecked())
            db.execSQL("INSERT INTO REST VALUES('"+cm2.getText()+"','"+qtym2.getText()+"');");

        if(cd1.isChecked())
            db.execSQL("INSERT INTO REST VALUES('"+cd1.getText()+"','"+qtyd1.getText()+"');");

        if(cd2.isChecked())
            db.execSQL("INSERT INTO REST VALUES('"+cd2.getText()+"','"+qtyd2.getText()+"');");

        Cursor c = db.rawQuery("SELECT * FROM REST", null);
        if(c.getCount()==0)
        {
            showMessage("Error","No Items Ordered");
            return;
        }
        StringBuffer buf = new StringBuffer();
        while(c.moveToNext())
        {
            buf.append("Item: "+c.getString(0)+"\n");
            buf.append("Quantity: "+c.getString(1)+"\n");
        }
        showMessage("Order Details", buf.toString());

        db.execSQL("DROP TABLE IF EXISTS REST;");


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

}

package com.example.mk.endsem;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminModify extends AppCompatActivity implements View.OnClickListener{

    EditText enm, eid, dept, phno, address;
    Button add;

    String n, i, d, p, a, empid;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_modify);

        Intent i = getIntent();
        empid = i.getStringExtra("empid");

        enm = (EditText)findViewById(R.id.enm);
        eid = (EditText)findViewById(R.id.eid);
        dept = (EditText)findViewById(R.id.dept);
        phno = (EditText)findViewById(R.id.phno);
        address = (EditText)findViewById(R.id.address);

        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        Cursor c1=db.rawQuery("SELECT * FROM employee WHERE eid='"+empid+"'", null);
        if(c1.moveToFirst())
        {
            enm.setText(c1.getString(0));
            eid.setText(c1.getString(1));
            dept.setText(c1.getString(2));
            phno.setText(c1.getString(3));
            address.setText(c1.getString(4));
        }
        else
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        n = enm.getText().toString().trim();
        i = eid.getText().toString().trim();
        d = dept.getText().toString().trim();
        p = phno.getText().toString().trim();
        a = address.getText().toString().trim();

        if (n.equals("")||a.equals("")||d.equals("")||p.equals("")||a.equals("")) {
            Toast.makeText(this, "Make sure to Enter all fields !!", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
            db.execSQL("DELETE FROM employee WHERE eid='"+empid+"'");
            db.execSQL("INSERT INTO employee VALUES('"+n+"','"+i+"','"+d+"','"+p+"','"+a+"');");

            Toast.makeText(this, "Employee Modified!", Toast.LENGTH_SHORT).show();

            Intent i1 = new Intent(this, AdminPage.class);
            startActivity(i1);
        }
    }
}

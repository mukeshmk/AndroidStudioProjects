package com.example.mk.endsem;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAdd extends AppCompatActivity implements View.OnClickListener{

    EditText enm, eid, dept, phno, address;
    Button add;

    String n, i, d, p, a;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add);

        enm = (EditText)findViewById(R.id.enm);
        eid = (EditText)findViewById(R.id.eid);
        dept = (EditText)findViewById(R.id.dept);
        phno = (EditText)findViewById(R.id.phno);
        address = (EditText)findViewById(R.id.address);

        add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);

        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS employee(name VARCHAR,eid VARCHAR, dept VARCHAR, phno VARCHAR, addrss VARCHAR);");
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
            db.execSQL("INSERT INTO employee VALUES('"+n+"','"+i+"','"+d+"','"+p+"','"+a+"');");
            Toast.makeText(this, "Employee Added!", Toast.LENGTH_SHORT).show();

            Intent i1 = new Intent(this, AdminPage.class);
            startActivity(i1);
        }
    }
}

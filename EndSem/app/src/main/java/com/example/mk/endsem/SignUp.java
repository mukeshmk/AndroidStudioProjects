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

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    EditText eid, unm, pwd, cpwd;
    Button signup;

    String i, un, p, cp;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        eid = (EditText)findViewById(R.id.eid);
        unm = (EditText)findViewById(R.id.unm);
        pwd = (EditText)findViewById(R.id.pwd);
        cpwd = (EditText)findViewById(R.id.cpwd);

        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);

        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,age VARCHAR, uname VARCHAR, pwd VARCHAR);");
    }

    @Override
    public void onClick(View v) {
        i = eid.getText().toString().trim();
        un = unm.getText().toString().trim();
        p = pwd.getText().toString().trim();
        cp = cpwd.getText().toString().trim();

        if (un.equals("")||p.equals("")||cp.equals("")) {
            Toast.makeText(this, "Make sure to Enter all fields !!", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
            Cursor c1=db.rawQuery("SELECT * FROM employee WHERE eid='"+i+"'", null);
            if(c1.moveToFirst())
            {
                db.execSQL("INSERT INTO users VALUES('"+i+"','"+un+"','"+p+"');");

                Toast.makeText(this, "Log In to Continue", Toast.LENGTH_SHORT).show();

                Intent i1 = new Intent(this, LogIn.class);
                startActivity(i1);
            }
            else
            {
                Toast.makeText(this, "Error no such Emp ID", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

package com.example.mk.restaurantmng;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText unm, pwd;
    Button login, signup;

    String u,p,u1,p1;
    int flag = 0;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unm = (EditText)findViewById(R.id.unm);
        pwd = (EditText)findViewById(R.id.pwd);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);

        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,phno VARCHAR, addrs VARCHAR, uname VARCHAR, pwd VARCHAR);");
        db.execSQL("INSERT INTO users VALUES('root','123456789','root','Root', 'root');");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                u = unm.getText().toString().trim();
                p = pwd.getText().toString().trim();

                db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
                Cursor c=db.rawQuery("SELECT * FROM users", null);
                if(c.getCount()==0)
                {
                    flag=2;
                    return;
                }
                while(c.moveToNext())
                {
                    u1 = c.getString(3);
                    p1 = c.getString(4);
                    if(u.equals(u1)&&u.equals("Admin")) {
                        Intent i3 = new Intent(this, Main4Activity.class);
                        startActivity(i3);
                        i3.putExtra("unm", u);
                        i3.putExtra("pwd", p);
                        flag=1;
                    }
                    else if(u.equals(u1)&&p.equals(p1)) {
                        Intent i1 = new Intent(this, Main2Activity.class);
                        i1.putExtra("unm", u);
                        i1.putExtra("pwd", p);
                        startActivity(i1);

                        flag=1;
                    }
                }
                if(flag==0) {
                    Toast.makeText(this, "LogIn Error !!", Toast.LENGTH_SHORT).show();
                }
                else if(flag==2) {
                    Toast.makeText(this, "DB Error !!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.signup:
                Intent i2 = new Intent(this,Main3Activity.class);
                startActivity(i2);
                break;
        }
    }
}

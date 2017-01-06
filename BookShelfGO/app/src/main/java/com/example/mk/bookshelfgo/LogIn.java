package com.example.mk.bookshelfgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    EditText eml, pwd;
    Button login, signup;

    String u,p,u1,p1;
    int flag = 0;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        eml = (EditText)findViewById(R.id.eml);
        pwd = (EditText)findViewById(R.id.pwd);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);

        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,age VARCHAR, email VARCHAR, pwd VARCHAR);");
        db.execSQL("INSERT INTO users VALUES('root','21','root@email.com','root');");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                u = eml.getText().toString().trim();
                p = pwd.getText().toString().trim();

                SharedPreferences sf=getSharedPreferences("cart", Context.MODE_PRIVATE);
                SharedPreferences.Editor preferencesEditor = sf.edit();

                preferencesEditor.putInt("int",0);
                preferencesEditor.clear();
                preferencesEditor.apply();

                db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
                Cursor c=db.rawQuery("SELECT * FROM users", null);
                if(c.getCount()==0)
                {
                    flag=2;
                    return;
                }
                while(c.moveToNext())
                {
                    u1 = c.getString(2);
                    p1 = c.getString(3);
                    if(u.equals(u1)&&p.equals(p1)) {
                        Intent i1 = new Intent(this, Welcome.class);
                        startActivity(i1);
                        i1.putExtra("unm", u);
                        i1.putExtra("pwd", p);
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
                Intent i2 = new Intent(this,SignUp.class);
                startActivity(i2);
                break;
        }
    }
}

package com.example.mk.endsem;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity implements View.OnClickListener{

    EditText unm, pwd;
    Button login, signup;

    String u,p,u1,p1;
    int flag = 0;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        unm = (EditText)findViewById(R.id.unm);
        pwd = (EditText)findViewById(R.id.pwd);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Async.AsyncTaskRunner runner = new Async.AsyncTaskRunner();
                runner.execute(unm.getText().toString().trim(),pwd.getText().toString().trim());
            }
        });
        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);

        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(empid VARCHAR, post VARCHAR, uname VARCHAR, pwd VARCHAR);");
        db.execSQL("INSERT INTO users VALUES('0','admin','admin','admin');");
        db.execSQL("INSERT INTO users VALUES('0','head','hr','hr');");
        db.execSQL("INSERT INTO users VALUES('0','head','finance','finance');");
    }

    @Override
    public void onClick(View v) {
        Intent i2 = new Intent(LogIn.this,SignUp.class);
        startActivity(i2);
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("DB Process..."); // Calls onProgressUpdate()
            try {
                        u = params[0];
                        p = params[1];

                        if(u.equals("admin")&&p.equals("admin")) {
                            Intent i1 = new Intent(LogIn.this, AdminPage.class);
                            startActivity(i1);
                            i1.putExtra("unm", u);
                            i1.putExtra("pwd", p);
                            flag=1;
                        }
                        if(u.equals("hr")&&p.equals("hr")) {
                            Intent i2 = new Intent(LogIn.this, DeptPage.class);
                            startActivity(i2);
                            i2.putExtra("unm", u);
                            i2.putExtra("pwd", p);
                            flag=1;
                        }
                        if(u.equals("finance")&&p.equals("finance")) {
                            Intent i2 = new Intent(LogIn.this, DeptPage.class);
                            startActivity(i2);
                            i2.putExtra("unm", u);
                            i2.putExtra("pwd", p);
                            flag=1;
                        }
                        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
                        Cursor c=db.rawQuery("SELECT * FROM users", null);
                        if(c.getCount()==0)
                        {
                            flag=2;
                        }
                        while(c.moveToNext())
                        {
                            u1 = c.getString(2);
                            p1 = c.getString(3);
                            if(u.equals(u1)&&p.equals(p1)) {
                                Intent i1 = new Intent(LogIn.this, AdminPage.class);
                                startActivity(i1);
                                i1.putExtra("unm", u);
                                i1.putExtra("pwd", p);
                                flag=1;
                            }
                        }
                        if(flag==0) {
                            Toast.makeText(LogIn.this, "LogIn Error !!", Toast.LENGTH_SHORT).show();
                        }
                        else if(flag==2) {
                            Toast.makeText(LogIn.this, "DB Error !!", Toast.LENGTH_SHORT).show();
                        }
                resp = "DB Process Complete";
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            Toast.makeText(LogIn.this, "DB Process Done", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(LogIn.this,
                    "ProgressDialog",
                    "Wait for DB Process");
        }


        @Override
        protected void onProgressUpdate(String... text) {
            Toast.makeText(LogIn.this, text[0], Toast.LENGTH_SHORT).show();
        }
    }
}

    /*
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                u = unm.getText().toString().trim();
                p = pwd.getText().toString().trim();

                if(u.equals("admin")&&p.equals("admin")) {
                    Intent i1 = new Intent(this, AdminPage.class);
                    startActivity(i1);
                    i1.putExtra("unm", u);
                    i1.putExtra("pwd", p);
                    flag=1;
                }
                if(u.equals("hr")&&p.equals("hr")) {
                    Intent i2 = new Intent(this, DeptPage.class);
                    startActivity(i2);
                    i2.putExtra("unm", u);
                    i2.putExtra("pwd", p);
                    flag=1;
                }
                if(u.equals("finance")&&p.equals("finance")) {
                    Intent i2 = new Intent(this, DeptPage.class);
                    startActivity(i2);
                    i2.putExtra("unm", u);
                    i2.putExtra("pwd", p);
                    flag=1;
                }
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
                        Intent i1 = new Intent(this, AdminPage.class);
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
    }*/
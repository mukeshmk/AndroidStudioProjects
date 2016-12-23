package com.example.mk.labex07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        String un = i.getStringExtra("unm");
        String pwd = i.getStringExtra("pwd");

        t1=(EditText) findViewById(R.id.t1);
        t1.setText(un);
        t2=(EditText) findViewById(R.id.t2);
        t2.setText(pwd);
    }
}
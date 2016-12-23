package com.example.mk.labex08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1=(EditText)findViewById(R.id.t1);
        b1=(Button)findViewById(R.id.ck);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        String s = e1.getText().toString().trim();
        i.putExtra("val",s);
        setResult(123,i);
        finish();
    }
}
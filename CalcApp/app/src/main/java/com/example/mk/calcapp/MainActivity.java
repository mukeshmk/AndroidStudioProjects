package com.example.mk.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;
    Button pul, min, mul, div, eql;
    Button mc, mp, mm, mr, c, pm;
    EditText disp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disp = (EditText) findViewById(R.id.disp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d0:
                Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

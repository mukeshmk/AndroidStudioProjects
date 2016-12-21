package com.example.mk.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    double val1=0, val2=0, res=0;
    int op, dec=0, i=1;

    Button d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;
    Button pul, min, mul, div, eql, dot;
    Button mc, mp, mm, mr, c, pm;
    TextView disp;

    void calcop() {
        if(op==0) {
            res=val2;
        }
        if(op==1) {
            res=val1+val2;
        }
        if(op==2) {
            res=val1-val2;
        }
        if(op==3) {
            res=val1*val2;
        }
        if(op==4) {
            res=val1/val2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disp = (TextView) findViewById(R.id.disp);

        d0 = (Button) findViewById(R.id.d0);
        d0.setOnClickListener(this);

        d1 = (Button) findViewById(R.id.d1);
        d1.setOnClickListener(this);

        d2 = (Button) findViewById(R.id.d2);
        d2.setOnClickListener(this);

        d3 = (Button) findViewById(R.id.d3);
        d3.setOnClickListener(this);

        d4 = (Button) findViewById(R.id.d4);
        d4.setOnClickListener(this);

        d5 = (Button) findViewById(R.id.d5);
        d5.setOnClickListener(this);

        d6 = (Button) findViewById(R.id.d6);
        d6.setOnClickListener(this);

        d7 = (Button) findViewById(R.id.d7);
        d7.setOnClickListener(this);

        d8 = (Button) findViewById(R.id.d8);
        d8.setOnClickListener(this);

        d9 = (Button) findViewById(R.id.d9);
        d9.setOnClickListener(this);

        dot = (Button) findViewById(R.id.dot);
        dot.setOnClickListener(this);

        c = (Button) findViewById(R.id.c);
        c.setOnClickListener(this);

        eql = (Button) findViewById(R.id.eql);
        eql.setOnClickListener(this);

        pul = (Button) findViewById(R.id.pul);
        pul.setOnClickListener(this);

        min = (Button) findViewById(R.id.min);
        min.setOnClickListener(this);

        mul = (Button) findViewById(R.id.mul);
        mul.setOnClickListener(this);

        div = (Button) findViewById(R.id.div);
        div.setOnClickListener(this);

        pm = (Button) findViewById(R.id.pm);
        pm.setOnClickListener(this);

        mc = (Button) findViewById(R.id.mc);
        mc.setOnClickListener(this);

        mp = (Button) findViewById(R.id.mp);
        mp.setOnClickListener(this);

        mm = (Button) findViewById(R.id.mm);
        mm.setOnClickListener(this);

        mr = (Button) findViewById(R.id.mr);
        mr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d0:
                disp.append("0");
                if(dec==0)
                    val2 = val2 * 10 + 0;
                else if(dec==1) {
                    val2 = val2 + 0;
                    i++;
                }
                break;
            case R.id.d1:
                disp.append("1");
                if(dec==0)
                    val2 = val2 * 10 + 1;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 1;
                    i++;
                }
                break;
            case R.id.d2:
                disp.append("2");
                if(dec==0)
                    val2 = val2 * 10 + 2;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 2;
                    i++;
                }
                break;
            case R.id.d3:
                disp.append("3");
                if(dec==0)
                    val2 = val2 * 10 + 3;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 3;
                    i++;
                }
                break;
            case R.id.d4:
                disp.append("4");
                if(dec==0)
                    val2 = val2 * 10 + 4;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 4;
                    i++;
                }
                break;
            case R.id.d5:
                disp.append("5");
                if(dec==0)
                    val2 = val2 * 10 + 5;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 5;
                    i++;
                }
                break;
            case R.id.d6:
                disp.append("6");
                if(dec==0)
                    val2 = val2 * 10 + 6;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 6;
                    i++;
                }
                break;
            case R.id.d7:
                disp.append("7");
                if(dec==0)
                    val2 = val2 * 10 + 7;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 7;
                    i++;
                }
                break;
            case R.id.d8:
                disp.append("8");
                if(dec==0)
                    val2 = val2 * 10 + 8;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 8;
                    i++;
                }
                break;
            case R.id.d9:
                disp.append("9");
                if(dec==0)
                    val2 = val2 * 10 + 9;
                else if(dec==1) {
                    val2 = val2 + java.lang.Math.pow(10, -i) * 9;
                    i++;
                }
                break;
            case R.id.dot:
                disp.append(".");
                if(dec==0) {
                    dec = 1;
                    Toast.makeText(this, "DOT", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                break;
            case R.id.c:
                disp.setText("");
                val2 = 0;
                dec=0;
                i=1;
                break;
            case R.id.eql:
                calcop();
                op=0;
                Toast.makeText(this, Double.toString(res), Toast.LENGTH_SHORT).show();
                disp.setText(Double.toString(res));
                val2=res;
                break;
            case R.id.pul:
                val1 = val2;
                val2 = 0;
                op=1;
                dec=0;
                i=1;
                disp.setText("");
                break;
            case R.id.min:
                val1 = val2;
                val2 = 0;
                op=2;
                dec=0;
                i=1;
                disp.setText("");
                break;
            case R.id.mul:
                val1 = val2;
                val2 = 0;
                op=3;
                dec=0;
                i=1;
                disp.setText("");
                break;
            case R.id.div:
                val1 = val2;
                val2 = 0;
                op=4;
                dec=0;
                i=1;
                disp.setText("");
                break;
            case R.id.pm:
                val2 = -val2;
                disp.setText(Double.toString(val2));
                break;
            case R.id.mc:
                Toast.makeText(this, "MC", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mp:
                Toast.makeText(this, "MP", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mm:
                Toast.makeText(this, "MM", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mr:
                Toast.makeText(this, "MR", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

package com.example.mk.labex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button b1, b2, b3;
    TextView et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.bt1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.bt2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.bt3);
        b3.setOnClickListener(this);

        et = (TextView) findViewById(R.id.textid1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                Toast.makeText(this, "Clicked Button 1 !!", Toast.LENGTH_SHORT).show();
                et.setText("Hello User !!");
                break;
            case R.id.bt2:
                Toast.makeText(this, "Clicked Button 2 !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt3:
                Toast.makeText(this, "Clicked Button 3 !!", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}

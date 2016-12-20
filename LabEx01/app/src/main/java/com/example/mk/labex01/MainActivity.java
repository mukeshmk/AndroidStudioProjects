package com.example.mk.labex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.bt1);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "You KNOW to CLICK yey !", Toast.LENGTH_SHORT).show();
    }
}

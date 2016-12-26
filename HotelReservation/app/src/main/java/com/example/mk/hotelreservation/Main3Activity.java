package com.example.mk.hotelreservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent i = getIntent();
        String text = i.getStringExtra("nm") + i.getStringExtra("no") + i.getStringExtra("bed") + i.getStringExtra("suite");

        t=(TextView) findViewById(R.id.t);
        t.setText(text);

    }
}

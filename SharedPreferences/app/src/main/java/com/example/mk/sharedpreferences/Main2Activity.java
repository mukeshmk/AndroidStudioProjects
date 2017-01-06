package com.example.mk.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText t1, t2;
    String s1, s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = (EditText)findViewById(R.id.t1);
        t2 = (EditText)findViewById(R.id.t2);
        SharedPreferences mPreferences = getSharedPreferences("myfile", MODE_PRIVATE);

        s1 = mPreferences.getString("text1",s1);
        t1.setText(s1);
        s2 = mPreferences.getString("text2",s2);
        t2.setText(s2);
    }
}

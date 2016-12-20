package com.example.mk.labex02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox c1,c2;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c2 = (CheckBox) findViewById(R.id.checkBox2);

        bt1 = (Button) findViewById(R.id.button);
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(c1.isChecked() && c2.isChecked())
            Toast.makeText(this, "Check Box 1 & 2", Toast.LENGTH_LONG).show();
        else if(c2.isChecked())
            Toast.makeText(this, "Check Box 2", Toast.LENGTH_LONG).show();
        else if(c1.isChecked())
            Toast.makeText(this, "Check Box 1", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Nothing", Toast.LENGTH_LONG).show();
    }
}

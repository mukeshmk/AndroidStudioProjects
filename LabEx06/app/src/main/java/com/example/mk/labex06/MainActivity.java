package com.example.mk.labex06;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressDialog Progress;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.progress);
        b1.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout r1 = (RelativeLayout) findViewById(R.id.activity_main);

        switch (item.getItemId()) {
            case R.id.blue:
                r1.setBackgroundColor(Color.BLUE);
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                r1.setBackgroundColor(Color.RED);
                Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    
}

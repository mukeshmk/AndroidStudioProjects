package com.example.mk.ticketbooking;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener ,AdapterView.OnItemSelectedListener{

    EditText tnm, pnm, page, src, dst;
    Button book;
    CheckBox chk1, chk2;
    RadioButton r1,r2;
    Spinner s;

    int flag=1;
    String arr[] = new String[]{"Upper","Middle","Lower"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tnm = (EditText)findViewById(R.id.tnm);
        pnm = (EditText)findViewById(R.id.pnm);
        page = (EditText)findViewById(R.id.page);
        src = (EditText)findViewById(R.id.src);
        dst = (EditText)findViewById(R.id.dest);

        chk1 = (CheckBox)findViewById(R.id.chk1);
        chk2 = (CheckBox)findViewById(R.id.chk2);

        r1 = (RadioButton)findViewById(R.id.male);
        r2 = (RadioButton)findViewById(R.id.female);

        s = (Spinner)findViewById(R.id.berth);
        ArrayAdapter s1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr);
        s1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s.setAdapter(s1);
        s.setOnItemSelectedListener(this);


        book = (Button)findViewById(R.id.book);
        book.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout r1 = (RelativeLayout)findViewById(R.id.activity_main2);
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

    @Override
    public void onClick(View v) {
        if(!(chk1.isChecked() || chk2.isChecked())){
            Toast.makeText(this, "data missing 1", Toast.LENGTH_LONG).show();
            flag=0;
        }
        if(tnm.getText().toString().equals("")) {
            Toast.makeText(this, "data missing 2", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        if(pnm.getText().toString().equals("")){
            Toast.makeText(this, "data missing 3", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        if(page.getText().toString().equals("")) {
            Toast.makeText(this, "data missing 4", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        if(src.getText().toString().equals("")) {
            Toast.makeText(this, "data missing 5", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        if(dst.getText().toString().equals("")) {
            Toast.makeText(this, "data missing 6", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        if(flag==1){
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("nm",pnm.getText().toString());
            setResult(123,i);
            finish();

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedFromList = (String)s.getItemAtPosition(position);
        Toast.makeText(this, selectedFromList, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "data missing 7", Toast.LENGTH_SHORT).show();
        flag=0;
    }
}

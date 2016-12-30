package com.example.mk.restaurantmng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    EditText guests;
    TextView unm;
    Button book;
    Spinner s;

    int flag=1;
    String arr[] = new String[]{"9.00 AM","9.30 AM","10.00 AM","10.30 AM","11.00 AM","11.30 AM","12.00 PM","12.30 PM","1.00 PM","1.30 PM","2.00 PM","2.30 PM","3.00 PM","3.30 PM","4.00 PM","4.30 PM","5.00 PM","5.30 PM","6.00 PM","6.30 PM","7.00 PM","7.30 PM","8.00 PM","8.30 PM"};
    String un, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Intent i = getIntent();
        un = i.getStringExtra("unm");
        pwd = i.getStringExtra("pwd");


        guests = (EditText)findViewById(R.id.nog);

        unm = (TextView)findViewById(R.id.unm);
        unm.setText(un);

        s = (Spinner)findViewById(R.id.time);
        ArrayAdapter s1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr);
        s1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s.setAdapter(s1);
        s.setOnItemSelectedListener(this);


        book = (Button)findViewById(R.id.book);
        book.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(guests.getText().toString().equals("")) {
            Toast.makeText(this, "Enter no. of guests", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        //if(flag==1){
        //  Intent i = new Intent(this, Booking.class);
        //}
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedFromList = (String)s.getItemAtPosition(position);
        //Toast.makeText(this, selectedFromList, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Select time slot", Toast.LENGTH_SHORT).show();
        flag=0;
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
            case R.id.profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Intent i4 = new Intent(this,MainActivity.class);
                startActivity(i4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}

package com.example.mk.labex03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{

    ListView l;
    Spinner s;
    String arr[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView) findViewById(R.id.list);
        arr = new String[]{"qwer","asdf","zxcv","qazw"};
        ArrayAdapter a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        a.setDropDownViewResource(android.R.layout.simple_list_item_1);
        l.setAdapter(a);
        l.setOnItemClickListener(this);

        s = (Spinner)findViewById(R.id.spin);
        ArrayAdapter s1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr);
        s1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s.setAdapter(s1);
        s.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedFromList = (String)l.getItemAtPosition(position);
        Toast.makeText(this, selectedFromList, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedFromList = (String)s.getItemAtPosition(position);
        Toast.makeText(this, selectedFromList, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

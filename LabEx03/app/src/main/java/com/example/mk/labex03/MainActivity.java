package com.example.mk.labex03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView l;
    String arr[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView) findViewById(R.id.list);
        arr = new String[]{"qwer","asdf","zxcv","qazw"};
        ArrayAdapter a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        ArrayAdapter s = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr);
        l.setAdapter(a);
        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

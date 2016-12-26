package com.example.mk.hotelreservation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    TextView t;
    EditText e1, e2, e3;
    RadioButton r1, r2;
    Spinner s;
    Button b;

    int flag=1, flag2=0;
    String arr[] = new String[]{"Classic","Dexluxe","Exective"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t=(TextView)findViewById(R.id.welcome);
        t.setText("Welcome User");

        e1=(EditText)findViewById(R.id.nm);
        e2=(EditText)findViewById(R.id.no);
        e3=(EditText)findViewById(R.id.beds);

        r1=(RadioButton)findViewById(R.id.ac);
        r2=(RadioButton)findViewById(R.id.nac);

        s = (Spinner)findViewById(R.id.suite);
        ArrayAdapter s1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arr);
        s1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s.setAdapter(s1);
        s.setOnItemSelectedListener(this);


        b=(Button)findViewById(R.id.book);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(e1.getText().toString().equals("")) {
            Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        if(e2.getText().toString().equals("")) {
            Toast.makeText(this, "Please Enter no of People", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        if(e3.getText().toString().equals("")) {
            Toast.makeText(this, "Please Enter no of beds", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        if(!(r1.isChecked() || r2.isChecked())){
            Toast.makeText(this, "Please Enter Room Type", Toast.LENGTH_LONG).show();
            flag=0;
        }
        if(flag==1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Confirm Booking ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Main2Activity.this, "Booking Successfull", Toast.LENGTH_SHORT).show();
                    flag2=11;
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Main2Activity.this, "Not Booked", Toast.LENGTH_SHORT).show();
                    flag2=11;
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        if(flag2==11){
            Intent i = new Intent(this,Main3Activity.class);
            startActivity(i);
            i.putExtra("nm",e1.getText().toString());
            i.putExtra("no",e2.getText().toString());
            i.putExtra("bed",e3.getText().toString());
            i.putExtra("suite",s.toString());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedFromList = (String)s.getItemAtPosition(position);
        Toast.makeText(this, selectedFromList, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "data missing", Toast.LENGTH_SHORT).show();
        flag=0;
    }
}

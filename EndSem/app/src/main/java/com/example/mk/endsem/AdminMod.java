package com.example.mk.endsem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminMod extends AppCompatActivity implements View.OnClickListener{

    EditText eid;
    Button mod;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_mod);

        eid = (EditText)findViewById(R.id.eid);

        mod = (Button)findViewById(R.id.mod);
        mod.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(eid.getText().toString().trim().length()==0)
        {
            Toast.makeText(this, "Enter ID", Toast.LENGTH_SHORT).show();
            return;
        }
        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        Cursor c1=db.rawQuery("SELECT * FROM employee WHERE eid='"+eid.getText()+"'", null);
        if(c1.moveToFirst())
        {
            Intent i = new Intent(this,AdminModify.class);
            i.putExtra("empid",c1.getString(1));
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Error no such Emp ID", Toast.LENGTH_SHORT).show();
        }


    }
}

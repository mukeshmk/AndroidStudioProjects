package com.example.mk.endsem;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminDelete extends AppCompatActivity implements View.OnClickListener{

    EditText empid;
    Button del;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_delete);

        empid = (EditText)findViewById(R.id.eid);

        del = (Button)findViewById(R.id.delete);
        del.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        if(empid.getText().toString().trim().length()==0)
        {
            showMessage("Error", "Please enter Rollno");
            return;
        }
        
        Cursor c1=db.rawQuery("SELECT * FROM employee WHERE eid='"+empid.getText()+"'", null);
        StringBuffer buffer=new StringBuffer();
        if(c1.moveToFirst())
        {
            buffer.append("Name: "+c1.getString(0)+"\n");
            buffer.append("Employee ID: "+c1.getString(1)+"\n");
            buffer.append("Department: "+c1.getString(2)+"\n");
            buffer.append("Phone No: "+c1.getString(3)+"\n");
            buffer.append("Address: "+c1.getString(4)+"\n");

            db.execSQL("DELETE FROM employee WHERE eid='"+empid.getText()+"'");

            showMessage("Record Deleted", buffer.toString());
        }
        else
        {
            showMessage("Error", "Invalid Employee ID");
        }
        clearText();
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        empid.setText("");
    }
}

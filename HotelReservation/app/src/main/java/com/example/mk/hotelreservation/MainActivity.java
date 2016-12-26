package com.example.mk.hotelreservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText e1, e2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.unm);
        e2=(EditText)findViewById(R.id.pwd);

        b=(Button)findViewById(R.id.login);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String u = e1.getText().toString().trim();
        String p = e2.getText().toString().trim();

        if(u.equals("User")&&p.equals("User")){
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this,Main2Activity.class);
            startActivity(i);
            i.putExtra("unm",u);
            i.putExtra("pwd",p);
        }
    }
}

package com.example.mk.ticketbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText un, pwd,ty;
    Button b;

    String u,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        un = (EditText)findViewById(R.id.un);
        pwd = (EditText)findViewById(R.id.pwd);
        ty = (EditText)findViewById(R.id.ty);
        b = (Button)findViewById(R.id.login);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        u = un.getText().toString().trim();
        p = pwd.getText().toString().trim();

        if(u.equals("Admin")&&p.equals("Admin")) {
            Intent i = new Intent(this,Main2Activity.class);
            startActivityForResult(i,123);
            i.putExtra("unm",u);
            i.putExtra("pwd",p);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123) {
            Bundle b = data.getExtras();
            ty.setText("Thank You: "+b.getString("nm"));
        }
    }
}

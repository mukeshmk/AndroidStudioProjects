package com.example.mk.labex07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button b;
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();

        b=(Button)findViewById(R.id.click);
        b.setOnClickListener(this);

        e1 = (EditText)findViewById(R.id.user);
        e2 = (EditText)findViewById(R.id.pwd);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String un = e1.getText().toString().trim();
        String pwd = e2.getText().toString().trim();

        if(un.equals("admin")&&pwd.equals("admin")) {
            Intent i = new Intent(this, Main2Activity.class);
            i.putExtra("unm",un);
            i.putExtra("pwd",pwd);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }
}

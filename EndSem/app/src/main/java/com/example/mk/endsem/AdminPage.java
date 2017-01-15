package com.example.mk.endsem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPage extends AppCompatActivity implements View.OnClickListener{

    Button add, del, mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);

        add = (Button)findViewById(R.id.admin_add);
        add.setOnClickListener(this);

        del = (Button)findViewById(R.id.admin_del);
        del.setOnClickListener(this);

        mod = (Button)findViewById(R.id.admin_mod);
        mod.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.admin_add:
                Intent i1 = new Intent(this,AdminAdd.class);
                startActivity(i1);
                break;
            case R.id.admin_del:
                Intent i2 = new Intent(this,AdminDelete.class);
                startActivity(i2);
                break;
            case R.id.admin_mod:
                Intent i3 = new Intent(this,AdminMod.class);
                startActivity(i3);
                break;
        }
    }
}

package com.example.mk.endsem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeptPage extends AppCompatActivity implements View.OnClickListener{

    Button v1, leave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);

        v1 = (Button)findViewById(R.id.dept_view);
        v1.setOnClickListener(this);

        leave = (Button)findViewById(R.id.dept_leave);
        leave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dept_view:
                Intent i1 = new Intent(this,AdminAdd.class);
                startActivity(i1);
                break;
            case R.id.dept_leave:
                Intent i2 = new Intent(this,AdminDelete.class);
                startActivity(i2);
                break;
        }
    }
}

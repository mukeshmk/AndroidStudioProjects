package com.example.mk.labex09;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText e1,e2,e3;
    Button b1,b2,b3,b4;
    String url, no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText)findViewById(R.id.url);
        e2 = (EditText)findViewById(R.id.no);
        e3 = (EditText)findViewById(R.id.msg);

        b1 = (Button)findViewById(R.id.link);
        b1.setOnClickListener(this);
        b2 = (Button)findViewById(R.id.dial);
        b2.setOnClickListener(this);
        b3 = (Button)findViewById(R.id.call);
        b3.setOnClickListener(this);
        b3 = (Button)findViewById(R.id.sms);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.link:
                url = e1.getText().toString().trim();
                url = "http://" + url;
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i1);
                break;
            case R.id.call:
                no = e2.getText().toString().trim();
                Intent i2 = new Intent(Intent.ACTION_CALL, Uri.parse(no));
                i2.setData(Uri.parse("tel:"+no));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(i2);
                break;
            case R.id.dial:
                no = e2.getText().toString().trim();
                Intent i3 = new Intent(Intent.ACTION_DIAL, Uri.parse(no));
                i3.setData(Uri.parse("tel:"+no));
                startActivity(i3);
                break;
            /*case R.id.sms:
                no = e2.getText().toString().trim();
                String msg = e3.getText().toString().trim();
                Intent i4 = new Intent(getApplication(),MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,i4,0);
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(no,null,msg,pi,null);
                break;*/

        }
    }
}
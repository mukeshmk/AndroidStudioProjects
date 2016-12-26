package com.example.mk.labex10;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    final BluetoothAdapter mbt = BluetoothAdapter.getDefaultAdapter();
    Button b1,b2,b3,w1,w2,w3;
    String url, no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.bt_on);
        b1.setOnClickListener(this);
        b2 = (Button)findViewById(R.id.bt_off);
        b2.setOnClickListener(this);
        b3 = (Button)findViewById(R.id.bt_disc);
        b3.setOnClickListener(this);
        w1 = (Button)findViewById(R.id.wf_on);
        w1.setOnClickListener(this);
        w2 = (Button)findViewById(R.id.wf_off);
        w2.setOnClickListener(this);
        w3 = (Button)findViewById(R.id.wf_disc);
        w3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_on:
                Intent i = new Intent (BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(i,20);
                break;
            case R.id.bt_off:
                mbt.disable();
                break;
            case R.id.bt_disc:
                Intent discoverbt = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(discoverbt,20);
                break;
            case R.id.wf_on:
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
                break;
            case R.id.wf_off:
                wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
                break;
            case R.id.wf_disc:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 20){
            Toast.makeText(this,"Back",Toast.LENGTH_SHORT).show();
        }
    }
}
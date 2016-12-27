package com.example.mk.labex14;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static BroadcastReceiver tickReceiver;

    private TextView hourText;
    private TextView minuteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hourText=(TextView)findViewById(R.id.hourText);
        minuteText=(TextView)findViewById(R.id.minuteText);

        //Set the current time at startup
        hourText.setText(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
        minuteText.setText(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)));

        tickReceiver=new BroadcastReceiver(){

            @Override
            public void onReceive(Context context, Intent intent) {

                if(intent.getAction().compareTo(Intent.ACTION_TIME_TICK)==0)
                {
                    hourText.setText(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
                    minuteText.setText(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)));
                }

            }
        };

        //Register the broadcast receiver to receive TIME_TICK
        registerReceiver(tickReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));



    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregister broadcast receiver.
        if(tickReceiver!=null)
            unregisterReceiver(tickReceiver);
    }
}

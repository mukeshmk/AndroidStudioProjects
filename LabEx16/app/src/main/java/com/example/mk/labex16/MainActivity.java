package com.example.mk.labex16;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        iv = (ImageView) findViewById(R.id.iv);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.values[0] == 0) {

            iv.setImageResource(R.drawable.android_cool);

        } else {

            iv.setImageResource(R.drawable.android_super);

        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

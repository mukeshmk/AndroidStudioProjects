package com.example.mk.labex11;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start1, stop1, pause1;
    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start1 = (Button) findViewById(R.id.start);
        stop1 = (Button) findViewById(R.id.stop);
        pause1 = (Button) findViewById(R.id.pause);

        start1.setOnClickListener(this);
        stop1.setOnClickListener(this);
        pause1.setOnClickListener(this);


        //  final MediaPlayer mp=new MediaPlayer();
        try {
            //you can change the path, here path is external directory(e.g. sdcard) /Music/maine.mp3
            // mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/sdcard/Music/Song.mp3");
            mp.setDataSource("/sdcard/Ringtones/hangouts_message.ogg");
            mp.prepare();
            // mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                mp.start();
                Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pause:
                mp.pause();
                break;
            case R.id.stop:
                mp.stop();
                break;
        }
    }
}

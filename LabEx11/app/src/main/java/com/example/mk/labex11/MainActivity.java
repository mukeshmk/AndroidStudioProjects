package com.example.mk.labex11;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start1, stop1, pause1,gal;
    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start1 = (Button) findViewById(R.id.start);
        stop1 = (Button) findViewById(R.id.stop);
        pause1 = (Button) findViewById(R.id.pause);
        gal = (Button) findViewById(R.id.gal);

        start1.setOnClickListener(this);
        stop1.setOnClickListener(this);
        pause1.setOnClickListener(this);
        gal.setOnClickListener(this);


        //  final MediaPlayer mp=new MediaPlayer();
        try {
            //you can change the path, here path is external directory(e.g. sdcard) /Music/maine.mp3
            // mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/sdcard/Music/Song.mp3");
            mp.setDataSource("/sdcard1/Music/song.mp3");
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
            case R.id.gal:
                Toast.makeText(this, "button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 3);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 3 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                //   Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.iv);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
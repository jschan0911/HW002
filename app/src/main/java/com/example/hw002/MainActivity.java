package com.example.hw002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SoundPool mPool = null;
    int mSoundFile;
    AudioManager mAm;
//    ImageView imageView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        mSoundFile = mPool.load(this, R.raw.ch, 1);
        mAm = (AudioManager)getSystemService(AUDIO_SERVICE);


        findViewById(R.id.button1).setOnClickListener(mClickListener);
        findViewById(R.id.button2).setOnClickListener(mClickListener);
        findViewById(R.id.button3).setOnClickListener(mClickListener);

        findViewById(R.id.button1).setOnLongClickListener(mLongClickListener);
        findViewById(R.id.button2).setOnLongClickListener(mLongClickListener);
        findViewById(R.id.button3).setOnLongClickListener(mLongClickListener);

//        imageView = findViewById(R.id.apple);
        ImageView img =(ImageView)findViewById(R.id.apple);
        img.setVisibility(View.INVISIBLE);
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener(){
            public void onClick (View v){
                switch(v.getId()){
                    case R.id.button1:
                        Toast.makeText(MainActivity.this, "학번: 12201301", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button2:
                        mPool.play(mSoundFile, 1, 1, 0, 0, 1);
                        break;
                    case R.id.button3:
                        Toast.makeText(MainActivity.this, "버튼 이름 바꾸는 곳", Toast.LENGTH_LONG).show();
                        break;

                }

            }

    };

    Button.OnLongClickListener mLongClickListener = new Button.OnLongClickListener(){

        public boolean onLongClick(View v) {

            switch (v.getId()) {
                case R.id.button1:
                    Toast.makeText(MainActivity.this, "이름: 정승찬", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
//                    imageView.setImageResource(R.drawable.apple);
                    ImageView img =(ImageView)findViewById(R.id.apple);
                    if(img.getVisibility()==View.VISIBLE){
                        img.setVisibility(View.INVISIBLE);
                    }else {
                        img.setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.button3:
                    Toast.makeText(MainActivity.this, "버튼 이름 바꾸는 곳", Toast.LENGTH_LONG).show();
                    break;
            }
                return false;
        }
    };
}


//added images to firebase
package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

public class ExecutiveFunctioning extends AppCompatActivity {
    Timer timer;
    ImageView nature;
    String urlnature;
    MediaPlayer mysong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executive_functioning);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        mysong = MediaPlayer.create(ExecutiveFunctioning.this, R.raw.summer);
        mysong.start();

        nature=findViewById(R.id.nature);
        urlnature="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/nature.jpg?alt=media&token=e7c48018-1ea4-4bb3-84fc-4da393c0deab";
        Picasso.with(this).load(urlnature).into(nature, new Callback(){
            @Override
            public void onSuccess() {
                final ImageView image = findViewById(R.id.nature);
                final Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                //please try adding a delay of 2 second here before start of animation
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image.startAnimation(animation1);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                final Intent mainIntent = new Intent(ExecutiveFunctioning.this, ExecutiveFunctioningPart2.class);
                                getApplicationContext().startActivity(mainIntent);
                                ExecutiveFunctioning.this.finish();
                            }
                        }, 5500);
                    }
                }, 1500);
            }

            @Override
            public void onError() {

            }
        });




        timer=new Timer();

    }
    @Override
    protected  void onPause()
    {
        super.onPause();
        mysong.release();
        finish();
    }
}
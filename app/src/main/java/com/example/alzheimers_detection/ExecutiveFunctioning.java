

//added images to firebase
package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ExecutiveFunctioning extends AppCompatActivity {
    ImageView nature;
    String urlnature;
    MediaPlayer mysong;
    OnSwipeTouchListener onSwipeTouchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.executive_functioning);

        final String stage_name="ExecutiveFunctioning";
        final String description = "You are “ xyz the Thief ! ”"+"\nEach coin inside the cave has a number or alphabet engraved on it.\n\nTap these coins to " +
                "collect them into sack such that a number is followed by its corresponding alphabet, in " +
                "increasing order, making an alternate trail.";
        onSwipeTouchListener = new OnSwipeTouchListener(this, findViewById(R.id.ExecutiveFunctioning),stage_name);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        mysong = MediaPlayer.create(ExecutiveFunctioning.this, R.raw.summer);
        mysong.start();

        nature=findViewById(R.id.nature);
        urlnature="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/nature.jpg?alt=media&token=e7c48018-1ea4-4bb3-84fc-4da393c0deab";
        Picasso.with(this).load(urlnature).into(nature);
        Intent intent = getIntent();
        final String Play = intent.getStringExtra("Play");

        if(Play==null||Play.contains("no"))
        {
            new CountDownTimer(10,10){

                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    PopUp_PlayGame p = new PopUp_PlayGame();
                    p.showPopUp(ExecutiveFunctioning.this,description,stage_name);
                }
            }.start();

        }
        else
        {
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
                                    //change_activity(Play);
                                    final Intent mainIntent = new Intent(ExecutiveFunctioning.this, ExecutiveFunctioningPart2.class);
                                    startActivity(mainIntent);
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
        }
    }

    @Override
    protected  void onPause()
    {
        super.onPause();
        mysong.release();
        finish();
    }
}
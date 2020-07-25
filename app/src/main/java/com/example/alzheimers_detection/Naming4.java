package com.example.alzheimers_detection;



import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

public class Naming4 extends AppCompatActivity {
    ProgressBar tort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naming4);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        tort = findViewById(R.id.progressBar14);
        final float[] count = {90};


        final Button button1 =  findViewById(R.id.tort_T);
        final Button button2 = findViewById(R.id.tort_o);
        final  Button button3 = findViewById(R.id.tort_r);
        final Button button4 = findViewById(R.id.tort_t);
        final Button button5 = findViewById(R.id.tort_i);
        final Button button6 = findViewById(R.id.tort_s);
        final Button button7 = findViewById(R.id.tort_e);
           /* Glide.with(this)
                .load(url).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                progressBar14.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar14.setVisibility(View.GONE);
                return false;
            }
        }).into(gify);*/


        button1.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(button1,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +140;


            }


        });
        button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(button2,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] + 140;


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(button3,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +140;


            }


        });
        button4.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(button4,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +140;


            }


        });
        button5.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(button5,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +140;


            }


        });
        button6.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(button6,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +140;


            }


        });
        button7.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(button7,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +140;


            }


        });
    }
    public void nextActivity(View view) {
        Intent intent = new Intent(this, IntroAbstraction.class);
        startActivity(intent);
    }
}
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

public class Naming3 extends AppCompatActivity {
    ProgressBar frog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naming3);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        frog = findViewById(R.id.progressBar13);
        final float[] count = {210};


        final Button butto1 =  findViewById(R.id.frog_f);
        final Button butto2 = findViewById(R.id.frog_r);
        final Button butto3 = findViewById(R.id.frog_o);
        final Button butto4 = findViewById(R.id.frog_g);

         /* Glide.with(this)
                .load(url).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                progressBar13.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar13.setVisibility(View.GONE);
                return false;
            }
        }).into(gify);*/
        butto1.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(butto1,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +180;


            }


        });
        butto2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(butto2,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] + 180;


            }
        });

        butto3.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(butto3,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +180;


            }


        });
        butto4.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(butto4,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +180;


            }


        });
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, Naming4.class);
        startActivity(intent);
    }


}

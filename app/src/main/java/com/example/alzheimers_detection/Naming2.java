package com.example.alzheimers_detection;



import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

public class Naming2 extends AppCompatActivity {
    ProgressBar lion ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naming2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        lion = findViewById(R.id.progressBar12);
        final float[] count = {210};


        final Button butt1 =  findViewById(R.id.lion_l);
        final Button butt2 = findViewById(R.id.lion_o);
        final Button butt3 = findViewById(R.id.lion_i);
        final Button butt4 = findViewById(R.id.lion_n);

          /* Glide.with(this)
                .load(url).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                progressBar12.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar12.setVisibility(View.GONE);
                return false;
            }
        }).into(gify);*/

        butt1.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(butt1,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +180;


            }


        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(butt2,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] + 180;


            }
        });

        butt3.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(butt3,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] +180;


            }


        });
        butt4.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0],320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(butt4,View.X,View.Y ,path);
                    anim.setDuration(1000);
                    anim.start();

                }
                count[0] = count[0] +180;


            }


        });

    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, Naming3.class);
        startActivity(intent);
    }
}
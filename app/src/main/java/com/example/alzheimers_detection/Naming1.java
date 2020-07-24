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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class Naming1 extends AppCompatActivity {

    // Button button;

    ProgressBar camel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naming1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        camel = findViewById(R.id.progressBar11);

        final float[] count = {100};
        /* final EditText e1 = findViewById(R.id.ed1);
        final EditText e2 = findViewById(R.id.ed2);
        final EditText e3 = findViewById(R.id.ed3);
        final EditText e4 = findViewById(R.id.ed4);
        final EditText e5 = findViewById(R.id.ed5);*/


        final Button but1 = findViewById(R.id.camel_c);
        final Button but2 = findViewById(R.id.camel_a);
        final Button but3 = findViewById(R.id.camel_m);
        final Button but4 = findViewById(R.id.camel_e);
        final Button but5 = findViewById(R.id.camel_l);
       /* Glide.with(this)
                .load(url).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                progressBar11.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar11.setVisibility(View.GONE);
                return false;
            }
        }).into(gify);*/

        but1.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0], 320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(but1, View.X, View.Y, path);
                    anim.setDuration(1000);
                    anim.start();
                }


            }


        });
        but2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0], 320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(but2, View.X, View.Y, path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] + 180;


            }
        });

        but3.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0], 320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(but3, View.X, View.Y, path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] + 180;


            }


        });
        but4.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0], 320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(but4, View.X, View.Y, path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] + 180;


            }


        });
        but5.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Path path = new Path();
                    path.moveTo(count[0], 320);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(but5, View.X, View.Y, path);
                    anim.setDuration(1000);
                    anim.start();
                }
                count[0] = count[0] + 180;


            }


        });

    }


    public void nextActivity(View view) {
        Intent intent = new Intent(this, Naming2.class);
        startActivity(intent);
    }
}

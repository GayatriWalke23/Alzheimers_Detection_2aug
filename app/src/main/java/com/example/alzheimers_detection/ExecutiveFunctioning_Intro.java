//added images to firebase storage
package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Picasso;

public class ExecutiveFunctioning_Intro extends AppCompatActivity {
    Button nextfromexecutivefunctioning;
    ImageView coinsgif,caves;
    ProgressBar progressBar;
    String urlcaves,urlcoinsgif;
    Boolean fromHomeScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.executive_functioning_intro);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();



        caves=findViewById(R.id.caves);
        urlcaves="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/caves.jpg?alt=media&token=2eb73383-43d6-4231-b20e-cf5c21986284";
        urlcoinsgif="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/coingif.gif?alt=media&token=8ebc355e-51a3-4bbf-86e4-6645e69215a6";
        coinsgif=findViewById(R.id.coinsgif);
        progressBar=findViewById(R.id.progressBar);

        Picasso.with(this).load(urlcaves).into(caves);

        Glide.with(this)
                .load(urlcoinsgif).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(coinsgif);

        nextfromexecutivefunctioning=findViewById(R.id.nextfromexecutivefunctioning);

        nextfromexecutivefunctioning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent i = new Intent(getApplicationContext(), ExecutiveFunctioning.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);

            }
        });

    }
}
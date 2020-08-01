package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void Playy(View view)
    {
        Intent i=new Intent(getApplicationContext(),Option_Screen.class);
        startActivity(i);
    }

    public void instructions(View view) {
        Intent i=new Intent(getApplicationContext(),Instructions.class);
        startActivity(i);
    }

    public void Results(View view) {
        Intent i=new Intent(getApplicationContext(),Results.class);
        startActivity(i);
    }
}
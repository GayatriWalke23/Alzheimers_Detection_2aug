package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FamilyHistory extends AppCompatActivity {
Button parentsyes,parentsno,siblingsyes,siblingsno,gotologin;

EditText injuries,smoke1,smoke2;

RadioButton onerelative,morethanonerelative;
RadioGroup radiogroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_history);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        parentsno=findViewById(R.id.parentsno);
        parentsyes=findViewById(R.id.parentsyes);
        smoke1=findViewById(R.id.smoke1);
        smoke2=findViewById(R.id.smoke2);
        injuries=findViewById(R.id.injuries);
        siblingsno=findViewById(R.id.siblingsno);
        siblingsyes=findViewById(R.id.siblingsyes);
        onerelative=findViewById(R.id.onerelative);
        morethanonerelative=findViewById(R.id.morethanonerelative);
        gotologin=findViewById(R.id.gotologin);

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });



    }
}
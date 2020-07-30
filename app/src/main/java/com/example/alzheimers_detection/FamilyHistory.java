package com.example.alzheimers_detection;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FamilyHistory extends AppCompatActivity {
    RadioButton greaterthan12years,years12,smokingnever,smokingoften,smokingsometimes,drinkingnever,drinkingsometimes,drinkingoften;
    CheckBox cardiovasculardisease,downsyndrome,headinjury;
    RadioGroup smoking,drinking,years;
    Button relativeyes,relativeno,savechanges;
    public FirebaseAuth mAuth;
    DatabaseReference dbUsers;
    FirebaseUser fuser;
    String uid;
    TextView yes,no;
    int score=6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family_history);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        mAuth = FirebaseAuth.getInstance();
        fuser = mAuth.getCurrentUser();
        uid=fuser.getUid();
        dbUsers= FirebaseDatabase.getInstance().getReference("Users/"+uid);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        smoking= (RadioGroup)findViewById(R.id.smoking);
        years= (RadioGroup)findViewById(R.id.years);
        drinking= (RadioGroup)findViewById(R.id.drinking);

        greaterthan12years=findViewById(R.id.greaterthan12years);
        years12=findViewById(R.id.years12);
        smokingnever=findViewById(R.id.smokingnever);
        smokingoften=findViewById(R.id.smokingoften);
        smokingsometimes=findViewById(R.id.smokingsometimes);
        drinkingnever=findViewById(R.id.drinkingnever);
        drinkingoften=findViewById(R.id.drinkingoften);
        drinkingsometimes=findViewById(R.id.drinkingsometimes);
        headinjury=findViewById(R.id.headinjury);
        downsyndrome=findViewById(R.id.downsyndrome);
        cardiovasculardisease=findViewById(R.id.cardiovasculardisease);
        relativeno=findViewById(R.id.relativeno);
        relativeyes=findViewById(R.id.relativeyes);
        savechanges=findViewById(R.id.savechanges);


        relativeyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes.setText("(Selected)");
                no.setText("");
            }
        });
        relativeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no.setText("(Selected)");
                yes.setText("");
            }
        });
        savechanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!no.getText().equals("") && !yes.getText().equals("")) {
                    relativeyes.setError("Please select one option!!");
                } else {
                    if (relativeyes.isSelected())
                    {
                        dbUsers.child("closerelative").setValue(1);
                        score--;
                    }else dbUsers.child("closerelative").setValue(0);

                    if (!smokingnever.isChecked() && !smokingoften.isChecked() && !smokingsometimes.isChecked()) {
                        smokingnever.setError("Please select one option!!");
                    } else {
                        if (smokingoften.isChecked() || smokingsometimes.isChecked())
                        {
                            dbUsers.child("smoking").setValue(1);
                            score--;
                        }
                        else dbUsers.child("smoking").setValue(0);
                        if (!drinkingnever.isChecked() && !drinkingoften.isChecked() && !drinkingsometimes.isChecked()) {
                            drinkingnever.setError("Please select one option!!");
                        } else {
                            if (drinkingoften.isChecked() || drinkingsometimes.isChecked())
                            {
                                score--;
                                dbUsers.child("drinking").setValue(1);
                            } else  dbUsers.child("drinking").setValue(0);
                            if (!greaterthan12years.isChecked() && !years12.isChecked()) {
                                years12.setError("Please select one option!!");
                            } else {
                                if (years12.isChecked()) {
                                    score--;
                                    dbUsers.child("levelofeducation").setValue(1);
                                } else dbUsers.child("levelofeducation").setValue(0);
                                if (headinjury.isChecked()) {
                                    score--;
                                    dbUsers.child("headinjury").setValue(1);
                                } else dbUsers.child("headinjury").setValue(0);
                                if (cardiovasculardisease.isChecked()) {
                                    score--;
                                    dbUsers.child("cardiovasculardisease").setValue(1);
                                }else dbUsers.child("cardiovasculardisease").setValue(0);
                                if (downsyndrome.isChecked()) {
                                    dbUsers.child("downsyndrome").setValue(1);
                                    score--;
                                }else dbUsers.child("downsyndrome").setValue(0);

                                dbUsers.child("totalfamilyscore").setValue(score);


                                Intent i=new Intent(getApplicationContext(),Login.class);
                                startActivity(i);

                            }

                        }
                    }
                }
            } });


    }
}
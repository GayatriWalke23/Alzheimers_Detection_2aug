package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JournalQuestions extends AppCompatActivity {
ImageView mood1,mood2,mood3,mood4,mood5;
Button submit;
int score=0,set=0;
RatingBar ratingBar;
    public FirebaseAuth mAuth;
    DatabaseReference dbUsers;
    FirebaseUser fuser;
    String uid;
RadioButton sedentary,lethargic,moderatelyactive,highlyactive,focusedwork,distractedwork,regularsleep,irregularsleep,cantsay,bodypainnever,bodypainsometimes,bodypainmostly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal_questions);
        mAuth = FirebaseAuth.getInstance();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        submit=findViewById(R.id.submit);
        ratingBar=findViewById(R.id.ratingBar);
        mood1=findViewById(R.id.mood1);
        mood2=findViewById(R.id.mood2);
        mood3=findViewById(R.id.mood3);
        mood4=findViewById(R.id.mood4);
        mood5=findViewById(R.id.mood5);
        cantsay=findViewById(R.id.cantsay);
        bodypainsometimes=findViewById(R.id.bodypainsometimes);
        bodypainnever=findViewById(R.id.bodypainnever);
        bodypainmostly=findViewById(R.id.bodypainmostly);

        regularsleep=findViewById(R.id.regularsleep);
        irregularsleep=findViewById(R.id.irregularsleep);


        sedentary=findViewById(R.id.sedentary);
        distractedwork=findViewById(R.id.distractedwork);

        focusedwork=findViewById(R.id.focusedwork);
        lethargic=findViewById(R.id.lethargic);
        moderatelyactive=findViewById(R.id.moderatelyactive);
        highlyactive=findViewById(R.id.highlyactive);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (set==0 || ((!moderatelyactive.isChecked()) || (!sedentary.isChecked())|| (!lethargic.isChecked())|| (!highlyactive.isChecked()))||((!distractedwork.isChecked()) || (!focusedwork.isChecked()))||((!cantsay.isChecked())||(!irregularsleep.isChecked())||(!regularsleep.isChecked()))||((!bodypainsometimes.isChecked())||(!bodypainmostly.isChecked())||(!bodypainnever.isChecked())))
                {
                    Toast.makeText(getApplicationContext(),"All the questions are compulsory!",Toast.LENGTH_LONG).show();
                }
                else {
                    fuser = mAuth.getCurrentUser();
                    uid=fuser.getUid();
                    dbUsers= FirebaseDatabase.getInstance().getReference("Users/"+uid);
                    if (set == 1 || set == 2 || set == 3) {
                        score++;
                        dbUsers.child("mood").setValue(1);

                    }
                    if(highlyactive.isChecked() || moderatelyactive.isChecked())
                    {
                        score++;
                        dbUsers.child("imWorkingIfeel").setValue(1);

                    }
                    if(focusedwork.isChecked())
                    {
                        score++;
                        dbUsers.child("carryingOutMyDailyActivities").setValue(1);

                    }
                    if(regularsleep.isChecked())
                    {
                        score++;
                        dbUsers.child("sleepCycle").setValue(1);

                    }
                    if (bodypainnever.isChecked())
                    {
                        score++;
                        dbUsers.child("experienceBodyPain").setValue(1);

                    }
                    float getrating = ratingBar.getRating();

                    if(getrating>=2.5)
                    {
                        score++;
                        dbUsers.child("starRating").setValue(1);

                    }
                    dbUsers.child("totalBehaviouralScore").setValue(score);

                    Intent i =new Intent(getApplicationContext(),Results.class);
                    startActivity(i);
                }


            }
        });
        mood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set=1;

                mood1.setBackgroundColor(Color.GRAY);

            }
        });
        mood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set=2;
                mood2.setBackgroundColor(Color.GRAY);


            }
        }); mood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set=3;

                mood3.setBackgroundColor(Color.GRAY);

            }
        }); mood4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set=4;

                mood4.setBackgroundColor(Color.GRAY);

            }
        }); mood5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set=5;

                mood5.setBackgroundColor(Color.GRAY);

            }
        });


    }
}
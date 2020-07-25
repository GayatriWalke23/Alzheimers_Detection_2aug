package com.example.alzheimers_detection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Results extends AppCompatActivity {
float executivefunctioningScore,namingScore,abstractionScore,calculationScore,orientationScore,immediaterecallScore,attentionScore,visuoperceptionScore,fluencyScore,delayedrecallScore;
int seconds=1;
String uid;
    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        DatabaseReference userDBRef = FirebaseDatabase.getInstance().getReference("Users");

        FirebaseUser fuser;
        mAuth = FirebaseAuth.getInstance();

        fuser = mAuth.getCurrentUser();
        uid=fuser.getUid();
        userDBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.child(uid).getValue(User.class);
                abstractionScore=user.getAbstraction();
                attentionScore=user.getAttention();
                namingScore=user.getNaming();
                calculationScore=user.getCalculation();
                orientationScore=user.getOrientation();
                immediaterecallScore=user.getImmediateRecall();
                delayedrecallScore=user.getDelayedRecall();
                visuoperceptionScore=user.getVisuoperception();
                fluencyScore=user.getFluency();
                executivefunctioningScore=user.getExecutiveFunctioning();
                //testing successful
                Toast.makeText(getApplicationContext()," "+abstractionScore+" "+attentionScore+" "+executivefunctioningScore,Toast.LENGTH_LONG).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("UserListActivity", "Error occured");
            }


        });



        /*seconds=1;
        final Handler handler2=new Handler();
        handler2.post(new Runnable() {
            @Override
            public void run() {
                if(seconds>0)
                {
                    seconds=seconds-1;
                    handler2.postDelayed(this,1000);
                }
                else
                {
                    Toast.makeText(getApplicationContext()," "+abstractionScore+" "+attentionScore+" "+executivefunctioningScore,Toast.LENGTH_LONG).show();
                }
            }
        });*/
    }
}
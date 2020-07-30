package com.example.alzheimers_detection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.util.Base64.DEFAULT;

public class Results extends AppCompatActivity {
    static String filename;
float executivefunctioningScore,namingScore,abstractionScore,calculationScore,orientationScore,immediaterecallScore,attentionScore,visuoperceptionScore,fluencyScore,delayedrecallScore;
int seconds=1,behaviouralResultOrNot=0;// if 1 , user has played behavioural questions .
String uid;
Double totscore,totstages;
float totalFamilyHistoryScore,totalBehaviouralScore;
TextView totalscore;
Bitmap bitmap;
    public FirebaseAuth mAuth;
    int numOfPrevScores;
    int prevScoreArray[]=new int[5];
    LinearLayout graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        final DatabaseReference userDBRef = FirebaseDatabase.getInstance().getReference("Users");

        FirebaseUser fuser;
        mAuth = FirebaseAuth.getInstance();

        totalscore=findViewById(R.id.totalscore);
        //graph=findViewById(R.id.graph);
       //graph.setDrawingCacheEnabled(true);


        fuser = mAuth.getCurrentUser();
        uid=fuser.getUid();
        userDBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.child(uid).getValue(User.class);
                abstractionScore=user.getAbstraction();
                behaviouralResultOrNot=user.getBehaviouralResultOrNot();
                attentionScore=user.getAttention();
                namingScore=user.getNaming();
                calculationScore=user.getCalculation();
                orientationScore=user.getOrientation();
                immediaterecallScore=user.getImmediateRecall();
                delayedrecallScore=user.getDelayedRecall();
                visuoperceptionScore=user.getVisuoperception();
                fluencyScore=user.getFluency();
                totalscore=findViewById(R.id.totalscore);
                executivefunctioningScore=user.getExecutiveFunctioning();
                totalBehaviouralScore=user.getTotalBehaviouralScore();
                totalFamilyHistoryScore=user.getTotalFamilyHistoryScore();



                if(behaviouralResultOrNot==0)//If user has played optional behavioural stage
                {
                    totscore = (double) (abstractionScore + attentionScore + calculationScore + namingScore + visuoperceptionScore + delayedrecallScore + orientationScore + fluencyScore + executivefunctioningScore);
                    totscore = ((0.97) * totscore) + (0.03 * totalFamilyHistoryScore);


                    totalscore.setText("Total Score :"+ ((float)Math.round(totscore * 100) / 100)+"/30"+"\n(Stages+Family)");

                }
                else {//User hasnt played behavioural stage
                    totscore = (double) (abstractionScore + attentionScore + calculationScore + namingScore + visuoperceptionScore + delayedrecallScore + orientationScore + fluencyScore + executivefunctioningScore);
                    totscore = ((0.95) * totscore) + (0.03 * totalFamilyHistoryScore) + (0.02 * totalBehaviouralScore);
                    totalscore.setText("Total Score :"+ ((float)Math.round(totscore * 100) / 100)+"\n(Stages+Family+Behavioural)");
                }


                numOfPrevScores=user.getNumOfScores();

                if(numOfPrevScores==1) userDBRef.child(uid).child("Score1").setValue(((float)Math.round(totscore * 100) / 100));
                else if(numOfPrevScores==2) userDBRef.child(uid).child("Score2").setValue(((float)Math.round(totscore * 100) / 100));
                else if(numOfPrevScores==3) userDBRef.child(uid).child("Score3").setValue(((float)Math.round(totscore * 100) / 100));
                else if(numOfPrevScores==4) userDBRef.child(uid).child("Score4").setValue(((float)Math.round(totscore * 100) / 100));
                else userDBRef.child(uid).child("Score5").setValue(((float)Math.round(totscore * 100) / 100));

                prevScoreArray[0]=user.getScore1();
                prevScoreArray[1]=user.getScore2();
                prevScoreArray[2]=user.getScore3();
                prevScoreArray[3]=user.getScore4();
                prevScoreArray[4]=user.getScore5();


                //ALL PREV SCORE VALUES HAVE COME INTO ARRAY
                //testing successful
                //Toast.makeText(getApplicationContext()," "+abstractionScore+" "+attentionScore+" "+executivefunctioningScore,Toast.LENGTH_LONG).show();




                //vaibhavi code start
                setBar(findViewById(R.id.set1), (int)executivefunctioningScore*100, R.color.fill_5, R.color.empty_5, "Executive Functioning");

                setBar(findViewById(R.id.set2), (int)((namingScore/4)*100), R.color.fill_4, R.color.empty_4, "Naming");

                setBar(findViewById(R.id.set3), (int)((abstractionScore/3)*100), R.color.fill_3, R.color.empty_3, "Abstraction");

                setBar(findViewById(R.id.set4), (int)((calculationScore/3)*100), R.color.fill_2, R.color.empty_2, "Calculation");

                setBar(findViewById(R.id.set5),(int)((orientationScore/6)*100), R.color.fill_1, R.color.empty_1,"Orientation");

                setBar(findViewById(R.id.set6), (int)immediaterecallScore, R.color.fill_5, R.color.empty_5,"Immediate Recall");

                setBar(findViewById(R.id.set7), (int)((attentionScore/3)*100), R.color.fill_4, R.color.empty_4, "Attention");

                setBar(findViewById(R.id.set8), (int)((visuoperceptionScore/6)*100), R.color.fill_3, R.color.empty_3,"Visuoperception");

                setBar(findViewById(R.id.set9), (int)((fluencyScore/2)*100), R.color.fill_2, R.color.empty_2,"Fluency");

                setBar(findViewById(R.id.set10),(int)((delayedrecallScore/5)*100), R.color.fill_1, R.color.empty_1, "Delayed Recall");

               //Vaibhavi code end

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("UserListActivity", "Error occured");
            }


        });


        //Handler: After 1 second make drawable bitmap of the graphbar
        seconds=5;
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
                    /*
                    bitmap = Bitmap.createBitmap(graph.getDrawingCache());
                    Log.d("bitmap",""+bitmap);
                    testimage.setImageBitmap(bitmap);
                    testimage.setVisibility(View.VISIBLE);
                    testimage.invalidate();
                    */

                    filename=""+uid+".png";
                    try (FileOutputStream out = new FileOutputStream(filename)) {
                        // bmp is your Bitmap instance
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String filename = ""+uid+".png";
        File sd = Environment.getExternalStorageDirectory();
        File dest = new File(sd+filename);
        try {
            FileOutputStream out = new FileOutputStream(dest);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setBar(View set, int score, int fc, int ec, String stagename){
        ProgressBar horizontalProgressBar =set.findViewById(R.id.horizontal_progress_bar);
        TextView name = set.findViewById(R.id.title);
        TextView sc = set.findViewById(R.id.percent);

        name.setText(stagename);
        sc.setText(score + "%");
        int fillColor = ContextCompat.getColor(this,fc);
        int emptyColor = ContextCompat.getColor(this, ec);
        int separatorColor = ContextCompat.getColor(this, R.color.transparent);

        SegmentedProgressDrawable progressDrawable = new SegmentedProgressDrawable(3, fillColor, emptyColor, separatorColor);
        horizontalProgressBar.setProgressDrawable(progressDrawable);
        horizontalProgressBar.setProgress(score);
    }

}
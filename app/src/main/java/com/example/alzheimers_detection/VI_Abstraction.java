package com.example.alzheimers_detection;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.UtteranceProgressListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class VI_Abstraction extends AppCompatActivity {
    Speak sp;
    ArrayList<String[]> answer = new ArrayList<>();

    String[] questions;
    String[] option_for_1;
    String[] option_for_2;
    String[] que_no ={"one","two"};
    String[] correct_answer ={"down","right"};
    String[] Score_points={"zero","one","two"};
    int score;
    int question_number;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vi_abstraction);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        sp = new Speak(this.getApplicationContext());

        Intent intent = getIntent();

        String que = intent.getStringExtra("Quetion");
        String ans = intent.getStringExtra("Answer");
        String point = intent.getStringExtra("Score");
        res = getResources();
        questions =res.getStringArray(R.array.Abstraction_que);
        option_for_1=res.getStringArray(R.array.Abstraction_Option1);
        option_for_2=res.getStringArray(R.array.Abstraction_Option2);
        answer.add(option_for_1);
        answer.add(option_for_2);

        if(que==null)
            question_number =0;
        else{
            if(que.contains("one"))
                question_number =0;
            else if(que.contains("two"))
                question_number =1;
        }


        if(point==null)
            score=0;
        else
        {
            if(point.contains("zero")) score=0;
            else if(point.contains("one")) score=1;
            else if(point.contains("two"))   score=2;             //GET tens value of score
        }


        if(que==null&&ans==null)
        {
            call_question();             //for first time

        }
        if(ans==null)
        {
            //Toast.makeText(this, "NULL ans", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(ans.contains("up"))
            {
                call_question();
            }

            if(!ans.contains("up"))
            {

                if(ans.contains(correct_answer[question_number]))
                    score=score+1;
                question_number++;
                if(question_number >=2) {
                    // next activity and total score!
                    startActivity(new Intent(getApplicationContext(),VI_Delayed_Recall_intro.class));
                }
                if(question_number <que_no.length)
                    call_question();
            }

        }
    }

    void call_left()
    {
        View left = findViewById(R.id.left);
        left.setVisibility(View.VISIBLE);
        speak(getString(R.string.Swipeleft).concat(answer.get(question_number)[0]),0,1,0,0,0,0);
    }
    void call_right()
    {
        final View down = findViewById(R.id.down);
        final View right = findViewById(R.id.right);
        down.setVisibility(View.GONE);
        right.setVisibility(View.VISIBLE);
        speak(getString(R.string.Swipeleft).concat(answer.get(question_number)[2]),0,0,0,1,0,0);


    }
    void call_up()
    {
        final View up = findViewById(R.id.up);
        final View right = findViewById(R.id.right);
        right.setVisibility(View.GONE);
        up.setVisibility(View.VISIBLE);
        speak(getString(R.string.Swipeup),0,0,0,0,1,0);
    }
    void call_down()
    {
        final View down = findViewById(R.id.down);
        final View left = findViewById(R.id.left);
        left.setVisibility(View.GONE);
        down.setVisibility(View.VISIBLE);
        speak(getString(R.string.Swipedown).concat(answer.get(question_number)[1]),0,0,1,0,0,0);
    }

    void enter_response()
    {
        speak(getString(R.string.Enter_response),0,0,0,0,0,1);
    }
    private void call_question()
    {
        speak(questions[question_number],1,0,0,0,0,0);
    }
    private void get_answer()
    {
        final Intent myIntent = new Intent(this, VI_Abstraction_ans.class);
        myIntent.putExtra("Que_no",que_no[question_number]);
        myIntent.putExtra("Score",Score_points[score]);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(myIntent);
    }
    void speak(String say, final int q,final int o1,final int o2,final int o3,final int o4,final int na){
        //call speakOut function
        sp.speakOut(say); //need minimum api level 21

        //to slow down the speed
        sp.changeSpeed(0.9f);

        //set Progresslistener to keep track of tts
        sp.getListener().setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String s) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getApplicationContext(), "Started" + keyword, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onDone(String s) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(q==1) call_left();
                        else if(o1==1)  call_down();
                        else if(o2==1)  call_right();
                        else if(o3==1) call_up();
                        else if(o4==1) enter_response();
                        else if(na==1) get_answer();
                    }
                });
            }

            @Override
            public void onError(String s) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
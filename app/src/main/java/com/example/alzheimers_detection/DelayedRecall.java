


//added images to firebase storage
package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DelayedRecall extends AppCompatActivity {
    private QuestionLibrary myQuestionLibrary = new QuestionLibrary();
    ImageView next;
    ImageView caterpillar;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    int counter=0;
    private String mAnswer,urlcaterpillar,urlnext;

    private int mQuestion_number = 0;
    private int mScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_recall);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        next=findViewById(R.id.next);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.option1);
        mButtonChoice2 = (Button) findViewById(R.id.option2);
        mButtonChoice3 = (Button) findViewById(R.id.option3);
        caterpillar=findViewById(R.id.caterpillar);
        urlcaterpillar="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/caterpillar.jpg?alt=media&token=faffd502-6614-4125-93b8-50de67fe0546";
        urlnext="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/nextgreenbutton.png?alt=media&token=60064096-a57e-4aa0-8cb7-511e933d97ca";
        Picasso.with(this).load(urlnext).into(next);
        Picasso.with(this).load(urlcaterpillar).into(caterpillar);
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonChoice1.setBackgroundResource(R.drawable.roundbuttonimmediaterecall2);
                mButtonChoice2.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);
                mButtonChoice3.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);

            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonChoice2.setBackgroundResource(R.drawable.roundbuttonimmediaterecall2);
                mButtonChoice1.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);
                mButtonChoice3.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);

            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonChoice3.setBackgroundResource(R.drawable.roundbuttonimmediaterecall2);
                mButtonChoice1.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);
                mButtonChoice2.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.roundbuttonimmediaterecall2).getConstantState()))
                {
                    if(mButtonChoice1.getText().toString().equals(myQuestionLibrary.mCorrect_answer[counter]))
                    {
                        mScore+=0.5;
                    }
                    updateQuestion();
                }
                else if(mButtonChoice2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.roundbuttonimmediaterecall2).getConstantState()))
                {
                    if(mButtonChoice2.getText().toString().equals(myQuestionLibrary.mCorrect_answer[counter]))
                    {
                        mScore+=0.5;
                    }
                    updateQuestion();
                }
                else if(mButtonChoice3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.roundbuttonimmediaterecall2).getConstantState()))
                {
                    if(mButtonChoice3.getText().toString().equals(myQuestionLibrary.mCorrect_answer[counter]))
                    {
                        mScore+=0.5;
                    }
                    updateQuestion();
                }

                if(counter==6)
                {
                    Intent i=new Intent(getApplicationContext(),HomeScreen.class);
                    startActivity(i);
                }
            }
        });
    }
    public  void  updateQuestion()
    {

        counter++;
        if (counter<6) {
            mQuestionView.setText(myQuestionLibrary.mQuestions[counter]);
            mButtonChoice1.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);
            mButtonChoice2.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);
            mButtonChoice3.setBackgroundResource(R.drawable.roundbuttonimmediaterecall);
            mButtonChoice1.setText(myQuestionLibrary.mChoice[counter][0]);
            mButtonChoice2.setText(myQuestionLibrary.mChoice[counter][1]);
            mButtonChoice3.setText(myQuestionLibrary.mChoice[counter][2]);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"score"+mScore,Toast.LENGTH_LONG).show();
        }
    }
}
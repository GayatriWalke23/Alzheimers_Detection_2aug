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
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FamilyHistory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family_history);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        final Button yes = findViewById(R.id.button2);
        yes.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater =
                        (LayoutInflater)getBaseContext()
                                .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.popup_familyhistory, null);
                final PopupWindow popupWindow =
                        new PopupWindow(
                                popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);

                AbsoluteLayout layout = findViewById(R.id.parentView);
                //to set height and width of a popup
                int height = layout.getHeight();
                popupWindow.setHeight(height/2);
                int width = layout.getWidth();
                popupWindow.setWidth(width);

                Button cancel = (Button)popupView.findViewById(R.id.cancel);

                //PopupWindow popup = new PopupWindow(contentView, width, height);
                popupWindow.setBackgroundDrawable(null);
                // popupWindow.showAsDropDown(anchor);


                //when user clicks on okay button
                popupView.findViewById(R.id.okay).setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // dayTv.setText(popupSpinner.getSelectedItem().toString());
                        popupWindow.dismiss();
                    }});

                //when user clicks on cancel button
                cancel.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }});

                popupWindow.showAsDropDown(yes,0,0, Gravity.CENTER);
                //popupWindow.showAsDropDown(yes, 10, 0);
            }
        });

    }

    void next_Activity()
    {
        Intent i=new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }
}
package com.example.alzheimers_detection;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.util.Calendar;

public class Orientation extends AppCompatActivity {
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)

        private static final String TAG = "MainActivity";
        private DatePickerDialog.OnDateSetListener dateSetListener;
        private int year, month, day;
        int score;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_orientation);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();

            final ListsForSpinner list = new ListsForSpinner();
            final boolean[] stateSet = {false};

            //date textview listener
            final TextView dateView = (TextView) findViewById(R.id.textView31);
            dateView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DatePickerDialog dialog =  new DatePickerDialog(Orientation.this,
                            android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateSetListener,
                            2013,5,15);

                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                }
            });

            dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int yyyy, int mm, int dd) {
                    mm++;
                   dateView.setText(dd + "/" + mm + "/" + yyyy);
                   year = yyyy;
                   month = mm;
                   day = dd;
                }
            };

            //day textview listener
            final TextView dayTv = findViewById(R.id.textView33);
            final String[] weekDays = list.weekDays();

            dayTv.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    LayoutInflater layoutInflater =
                            (LayoutInflater)getBaseContext()
                                    .getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.orientation_popup, null);
                    final PopupWindow popupWindow = new PopupWindow(
                            popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    popupWindow.setOutsideTouchable(true);
                    Button cancel = (Button)popupView.findViewById(R.id.cancel);
                    TextView tv = popupView.findViewById(R.id.popuptv);
                    tv.setText("Select a Day");
                    final Spinner popupSpinner = (Spinner)popupView.findViewById(R.id.daysSpinner);
                    ArrayAdapter<String> adapter =
                            new ArrayAdapter<String>(Orientation.this,
                                    android.R.layout.simple_spinner_item, weekDays);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    popupSpinner.setAdapter(adapter);
                    popupView.findViewById(R.id.okay).setOnClickListener(new Button.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            dayTv.setText(popupSpinner.getSelectedItem().toString());
                            popupWindow.dismiss();
                        }});
                    cancel.setOnClickListener(new Button.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }});
                    popupWindow.showAsDropDown(dayTv, 50, -30);
                }
            });

            //listener for state
            final TextView stateTv = findViewById(R.id.textView34);
            final String[] states = list.states();
            stateTv.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    LayoutInflater layoutInflater =
                            (LayoutInflater)getBaseContext()
                                    .getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.orientation_popup, null);
                    final PopupWindow popupWindow = new PopupWindow(
                            popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    popupWindow.setOutsideTouchable(true);
                    Button cancel = (Button)popupView.findViewById(R.id.cancel);
                    TextView tv = popupView.findViewById(R.id.popuptv);
                    tv.setText("Select a State");
                    final Spinner popupSpinner = (Spinner)popupView.findViewById(R.id.daysSpinner);
                    ArrayAdapter<String> adapter =
                            new ArrayAdapter<>(Orientation.this,
                                    android.R.layout.simple_spinner_item, states);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    popupSpinner.setAdapter(adapter);
                    popupView.findViewById(R.id.okay).setOnClickListener(new Button.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            stateTv.setText(popupSpinner.getSelectedItem().toString());
                            popupWindow.dismiss();
                            stateSet[0] = true;
                        }});
                    cancel.setOnClickListener(new Button.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }});
                    popupWindow.showAsDropDown(dayTv, 50, -30);
                }
            });

            //listener for city
            final TextView cityTv = findViewById(R.id.textView29);

            cityTv.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {

                    if(!stateSet[0]) {
                        Toast toast=Toast.makeText(getApplicationContext(),"Select a State first",Toast.LENGTH_LONG);
                        toast.show();

                    } else {
                        String state = stateTv.getText().toString().trim();
                        final String[] cities = list.getCitiesArray(state);

                        LayoutInflater layoutInflater =
                                (LayoutInflater) getBaseContext()
                                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupView = layoutInflater.inflate(R.layout.orientation_popup, null);
                        final PopupWindow popupWindow = new PopupWindow(
                                popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                        popupWindow.setOutsideTouchable(true);
                        Button cancel = (Button) popupView.findViewById(R.id.cancel);
                        TextView tv = popupView.findViewById(R.id.popuptv);
                        tv.setText("Select a City");
                        final Spinner popupSpinner = (Spinner) popupView.findViewById(R.id.daysSpinner);
                        ArrayAdapter<String> adapter =
                                new ArrayAdapter<>(Orientation.this,
                                        android.R.layout.simple_spinner_item, cities);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        popupSpinner.setAdapter(adapter);
                        popupView.findViewById(R.id.okay).setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                cityTv.setText(popupSpinner.getSelectedItem().toString());
                                popupWindow.dismiss();
                            }
                        });
                        cancel.setOnClickListener(new Button.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                popupWindow.dismiss();
                            }
                        });
                        popupWindow.showAsDropDown(dayTv, 50, -30);
                    }
                }
            });

        }

        void calculateScore(){
            Calendar cal = Calendar.getInstance();

            if(year == cal.get(Calendar.YEAR))
                score++;

            if(month == cal.get(Calendar.MONTH) + 1)
                score++;

            if(day == cal.get(Calendar.DATE))
                score++;

            TextView dayOfWeek = findViewById(R.id.textView33);
            ListsForSpinner list = new ListsForSpinner();
            String week[] = list.weekDays();
            if(dayOfWeek.getText().toString().equalsIgnoreCase(week[cal.get(Calendar.DAY_OF_WEEK) - 1]))
                score++;

            String address[] = getAddress().split(" ");

            TextView state = findViewById(R.id.textView34);
            if(address[1].equalsIgnoreCase(state.getText().toString()))
                score++;

            TextView city = findViewById(R.id.textView29);
            if(address[0].equalsIgnoreCase(city.getText().toString()))
                score++;

        }

        String getAddress(){
            LocationAPI location = new LocationAPI(Orientation.this);
            String address = "";
            try {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                    ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
                }
            } catch (Exception e){
                e.printStackTrace();
            }

            try {
                address = location.getLocation().trim();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return address;
        }
}





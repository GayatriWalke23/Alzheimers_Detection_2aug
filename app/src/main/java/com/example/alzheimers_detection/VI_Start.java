package com.example.alzheimers_detection;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class VI_Start extends AppCompatActivity {
    Locale myLocale;
    //String currentLanguage = "en";
    int currLang;
    Spinner spinner ;
   static int currentLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vi_start);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        // getActionBar().hide();
        spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(this.getString(R.string.selectlanguage));
        arrayList.add(this.getString(R.string.english));
        arrayList.add(this.getString(R.string.hindi));


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 1:
                        setLocale("en",1);
                        break;
                    case 2:
                        setLocale("hi",2);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        Button btn = findViewById(R.id.button);

       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent myIntent=new Intent(getApplicationContext(), VI_Memory_intro.class);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(myIntent);

            }
        });
    }


        public void setLocale(String localeName, int localnum) {
            String s = null;
          // if (currLang != localnum) {
                myLocale = new Locale(localeName);
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                Intent refresh = new Intent(this, VI_Start.class);
                refresh.putExtra(s, localeName);
                startActivity(refresh);
                currLang = localnum;
           // } else {
                //Toast.makeText(VI_Start.this, "Language already selected!", Toast.LENGTH_SHORT).show();
            //}
        }

        public void onBackPressed() {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }

}

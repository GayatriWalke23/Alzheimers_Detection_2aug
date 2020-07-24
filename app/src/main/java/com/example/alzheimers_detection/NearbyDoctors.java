package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class NearbyDoctors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_doctors);

        LocationAPI location = new LocationAPI(NearbyDoctors.this);
        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            String text[] = location.getLocation().trim().split(" ");
            String city = text[0].trim();

            if (city != "") {
                WebView w = findViewById(R.id.web);
                String doctor = "neurologist";
                String link = "https://www.practo.com/search?results_type=doctor&q=%5B%7B%22word%22%3A%22"
                        + doctor + "%22%2C%22autocompleted%22%3Atrue%2C%22category%22%3A%22subspeciality%22%7D%5D&city=" + city;

                w.loadUrl(link);
                w.getSettings().setJavaScriptEnabled(true);
                w.setWebViewClient(new WebViewClient());
            } else {
                try {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    String term = "neurologist near me";
                    intent.putExtra(SearchManager.QUERY, term);
                    startActivity(intent);
                } catch (Exception e) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
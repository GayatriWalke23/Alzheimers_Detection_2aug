package com.example.alzheimers_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        WebView w = findViewById(R.id.web_news);
        String link = "https://www.google.com/search?q=latest+news+on+alzheimer%27s+disease&rlz=1C1SQJL_enIN855IN855&source=lnms&tbm=nws&sa=X&ved=2ahUKEwiws7uRmOvqAhWC7HMBHXBNAvUQ_AUoAXoECA0QAw&biw=1707&bih=803";

        w.loadUrl(link);
        w.getSettings().setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());

    }
}

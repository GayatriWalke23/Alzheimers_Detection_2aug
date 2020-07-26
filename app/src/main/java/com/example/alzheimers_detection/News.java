package com.example.alzheimers_detection;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;


public class News extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

                WebView w = findViewById(R.id.web_news);
                String link = "https://www.google.com/search?q=latest+news+on+alzheimer%27s+disease&rlz=1C1SQJL_enIN855IN855&source=lnms&tbm=nws&sa=X&ved=2ahUKEwiws7uRmOvqAhWC7HMBHXBNAvUQ_AUoAXoECA0QAw&biw=1707&bih=803";

                w.loadUrl(link);
                w.getSettings().setJavaScriptEnabled(true);
                w.setWebViewClient(new WebViewClient());

                   /* Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    String term = "neurologist near me";
                    intent.putExtra(SearchManager.QUERY, term);
                    startActivity(intent);*/

    }
}

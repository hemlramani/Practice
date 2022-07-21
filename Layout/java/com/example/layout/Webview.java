package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Webview extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        web= findViewById(R.id.web);

        web.loadUrl("http://www.topsint.com/topserp/");
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
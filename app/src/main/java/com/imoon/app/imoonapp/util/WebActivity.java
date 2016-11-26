package com.imoon.app.imoonapp.util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.imoon.app.imoonapp.R;

public class WebActivity extends AppCompatActivity {
    WebView wv_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        wv_test = (WebView) findViewById(R.id.wv_test);
        wv_test.setWebViewClient(new WebViewClient()); // 이걸 안해주면 새창이 뜸
        wv_test.setWebChromeClient(new WebChromeClient());
        //wv_test.loadUrl("http://www.naver.com");
        wv_test.loadUrl("file:///android_asset/html/index.html");



        WebSettings webSettings = wv_test.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}

package com.example.kiosk_bvtt;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    int SPLASH_TIME_OUT=3000;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadingDialog loadingDialog=new LoadingDialog(MainActivity.this);
        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.clearCache(true);
        webview.getSettings().setJavaScriptEnabled(true);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//        loadingDialog.startLoadingDialog();
                webview.loadUrl("https://www.youtube.com/");


                finish();
            }
        },SPLASH_TIME_OUT);
        Log.i(TAG,"Exiting onCreate");
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


    @Override
    public void onBackPressed() {
        if(webview.canGoBack())
        {
            webview.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
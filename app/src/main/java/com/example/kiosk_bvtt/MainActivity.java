package com.example.kiosk_bvtt;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    int SPLASH_TIME_OUT=3000;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webview);
        String url;
        Intent intent = getIntent();
        String a = intent.getStringExtra("url");
//        CustomWebClient customWebClient = new CustomWebClient();
//        boolean a = customWebClient.shouldOverrideUrlLoading(webview,"https://www.youtube.com000/");
        if(a==null || a.equals("")) {
            //link mặc định đầu vào web
            url = "https://www.youtube.com/watch?v=";
        } else {
            url = a;
        }
        webview.setWebViewClient(new WebViewClient());
        webview.clearCache(true);
        webview.getSettings().setJavaScriptEnabled(true);

        webview.loadUrl(url);
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                Log.v("abcd","tttt");

                Intent intent = new Intent(MainActivity.this,ScreenTemp.class);
                startActivity(intent);

            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Log.v("abcd","hhhhh");
                super.onLoadResource(view, url);

                return true;
            }

            public void onPageFinished(WebView view, String url) {
//                if (dialog.isShowing()) {
//                    dialog.dismiss();
//
//                }
//                Intent intent = new Intent(MainActivity.this,ScreenTemp.class);
//                startActivity(intent);
            }
        });
        webview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) view;
                    String abc = String.valueOf(i);



                    switch(i) {
                        case 4:
                            Log.v("aaaa", "aaaaa");
                            if (webView.canGoBack()) {

                                webView.goBack();
                                return true;
                            } else {
                                Intent intent = new Intent(MainActivity.this,URL.class);
                                startActivity(intent);
                                finish();

                            }
                            break;
                    }
            }
                return  false;}}

                );

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
package com.example.kiosk_bvtt;

import android.util.Log;
import android.util.Patterns;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CustomWebClient extends WebViewClient {

    private static final String TAG = "WebWiewActivity";

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.setWebViewClient(new WebViewClient());
        view.clearCache(true);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
        WebSettings webSettings=view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return false;
    }

//    @Override
//    public void onReceivedHttpError (WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
//        Toast.makeText(view.getContext(), "HTTP error "+errorResponse.getStatusCode(), Toast.LENGTH_LONG).show();
//    }

//    @Override
//    public void onPageFinished(String url) {
//        // url validation
//        if (!Patterns.WEB_URL.matcher(url).matches()) {
//
//        }
//    }
}

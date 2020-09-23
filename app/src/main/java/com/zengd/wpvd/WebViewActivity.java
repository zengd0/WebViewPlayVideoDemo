package com.zengd.wpvd;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class WebViewActivity extends AppCompatActivity {
    private VideoEnabledWebView webView;
    private LinearLayout parent;
    private FrameLayout videoLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (VideoEnabledWebView) findViewById(R.id.webView);
        parent = (LinearLayout) findViewById(R.id.parent);
        videoLayout = (FrameLayout) findViewById(R.id.videoLayout);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
            }

            @Override
            public void onPageFinished(WebView view, String url) {
            }
        });
        webView.setWebChromeClient(new VideoEnabledWebChromeClient(this, parent, videoLayout));
        //load url
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}

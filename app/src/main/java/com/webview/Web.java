package com.webview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {
private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        wv= (WebView) findViewById(R.id.wvr);
        wv.setWebViewClient(new MyWebViewClient());
        wv.setWebChromeClient(new MyWebChromeClient());
        wv.getSettings().setJavaScriptEnabled(true);

        wv.loadUrl("https://m.baidu.com");
    }

    class  MyWebChromeClient extends WebChromeClient{

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }
class MyWebViewClient extends WebViewClient{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        wv.loadUrl(request.getUrl().toString());
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {

        //wv.loadUrl("javascript:alert('hello')");
        super.onPageFinished(view, url);
    }
}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK&&wv.canGoBack()){
            wv.goBack();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

package com.zhanggb.VideoPlayerDemo.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.zhanggb.VideoPlayerDemo.R;

/**
 * @author zhanggaobo
 * @since 04/28/2016
 */
public class WebviewVideoActivity extends Activity {

    private Context context;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_video);
        this.context = this;
        initView();
        setupWebView();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.webview);

    }

    private void setupWebView() {

//        File file = context.getCacheDir();
//        if (file != null && file.exists() && file.isDirectory()) {
//            for (File item : file.listFiles()) {
//                item.delete();
//            }
//            file.delete();
//        }
//
//        context.deleteDatabase("webview.db");
//        context.deleteDatabase("webviewCache.db");

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
//        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setUseWideViewPort(true);

        settings.setLoadWithOverviewMode(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                webView.loadUrl("http://10.1.64.224:7777/smile/android_h5_video.jsp?videoUrl=http%3A%2F%2F7xr5p3.media1.z0.glb.clouddn.com%2Fcourse%2F20160408145230301%2F1460098350300.mp4%3Fe%3D1462439941%26token%3DE4JQ5uyim9xIpCruyRJkwpd-8aOovO_-iur7OKrz%3A-5gLw98eYE-wZ12V6aMZjdQ69ew%3D#?type=showVideoBottomBar");
                Log.d("url: ", url);
                return true;
//                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.d("onPageStarted  url: ", url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d("onPageFinished  url: ", url);
                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                Log.d("onLoadResource  url: ", url);
                super.onLoadResource(view, url);
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });

//        webView.loadUrl("http://player.youku.com/embed/XMjg5ODQxMTg4");
        webView.loadUrl("http://10.1.64.224:7777/smile/android_h5_video.jsp?videoUrl=http%3A%2F%2F7xr5p3.media1.z0.glb.clouddn.com%2Fcourse%2F20160408145230301%2F1460098350300.mp4%3Fe%3D1462439941%26token%3DE4JQ5uyim9xIpCruyRJkwpd-8aOovO_-iur7OKrz%3A-5gLw98eYE-wZ12V6aMZjdQ69ew%3D#?type=showVideoBottomBar");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            webView.loadData("", "text/html; charset=UTF-8", null);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        webView.onResume();
    }
}
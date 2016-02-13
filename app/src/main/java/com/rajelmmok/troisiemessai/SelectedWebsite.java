package com.rajelmmok.troisiemessai;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;


public class SelectedWebsite extends Activity {
    TextView tvLabel;
    WebView web;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_website);

        tvLabel=(TextView)findViewById(R.id.tvLabel);
        web=(WebView)findViewById(R.id.webView);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        loadDomainNameOnTextView();
        loadWebsiteOnWebView();
    }

    public String loadSelectedDomain(){
        Intent intent= getIntent();
        String domain=intent.getStringExtra("domain");
        return domain;
    }

    public void loadDomainNameOnTextView(){
        tvLabel.setText(loadSelectedDomain());
    }

    public void loadWebsiteOnWebView(){
        web.setWebViewClient(new MyWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://" + loadSelectedDomain());
    }

    //my implemented web client
    private class MyWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        startActivity(new Intent(this, OurWebsites.class));
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selected_website, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

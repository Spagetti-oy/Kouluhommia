package com.example.nettiselain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText addressInput;
    //osa näistä turhia mutta en ehtinyt poistaa kaikkia
    String address, currentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressInput = (EditText) findViewById(R.id.addressInput);
        currentAddress = (addressInput.getText().toString());

        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://" + currentAddress);

    }

    public void goToPage(View v) {
        address = (addressInput.getText().toString());

        String filename = "index.html";
        if (address.equals(filename)) {
            web.loadUrl("file:///android_asset/index.html");
        }

        else {
            web.loadUrl("http://" + address);
            currentAddress = web.getUrl();
        }
    }

    public void refresh(View v) {
        web.reload();
    }

    public void goPageBack(View v) {
        web.goBack();
        addressInput.setText(web.getOriginalUrl());
    }

    public void goPageNext(View v) {
        web.goForward();
        addressInput.setText(web.getOriginalUrl());
    }

    public void javascriptShoutout(View v) {
        web.evaluateJavascript("shoutOut()", null);
    }

    public void javascriptInitialize(View v) {
        web.evaluateJavascript("initialize()", null);
    }

}

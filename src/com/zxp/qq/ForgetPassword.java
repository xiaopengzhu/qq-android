package com.zxp.qq;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ForgetPassword extends Activity{
    private WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget_password);
		webview = (WebView)findViewById(R.id.webView1);
		webview.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
			
		});
		WebSettings ws = webview.getSettings();
		ws.setJavaScriptEnabled(true);
		ws.setUseWideViewPort(true);
		ws.setLoadWithOverviewMode(true);
		webview.loadUrl("http://lux.vipstatic.com/content/20141128eqiq_m/index.html");
	}

}

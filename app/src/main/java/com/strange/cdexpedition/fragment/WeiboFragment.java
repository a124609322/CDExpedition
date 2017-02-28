package com.strange.cdexpedition.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.strange.cdexpedition.R;

/**
 * Created by AngerYman on 2017/2/27.
 */

public class WeiboFragment extends Fragment {

    private View view;

    public WeiboFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weibo,container, false);
        WebView webView = (WebView) this.view.findViewById(R.id.weibowebview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://weibo.com/cdlytxd2017");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

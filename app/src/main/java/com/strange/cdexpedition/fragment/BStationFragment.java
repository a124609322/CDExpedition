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

public class BStationFragment extends Fragment {

    private View view;

    public BStationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_b,container, false);
        WebView webView = (WebView) this.view.findViewById(R.id.bwebview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://space.bilibili.com/82220085/#!/");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

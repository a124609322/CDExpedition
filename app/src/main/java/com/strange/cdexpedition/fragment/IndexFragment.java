package com.strange.cdexpedition.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.strange.cdexpedition.R;


public class IndexFragment extends Fragment {

    private View view = null;

    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_index, container, false);

        //设置actionbar
        /*Toolbar toolbar = (Toolbar) this.view.findViewById(R.id.index_toolbar);
        toolbar.setTitle("");*/
       /* ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);*/

        WebView webView = (WebView) this.view.findViewById(R.id.tiebawebview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://tieba.baidu.com/f?kw=%E6%88%90%E9%83%BD%E7%81%B5%E5%BC%82%E6%8E%A2%E9%99%A9%E9%98%9F");
        return this.view;
    }

}

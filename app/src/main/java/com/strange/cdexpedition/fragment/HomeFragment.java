package com.strange.cdexpedition.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.baoyz.actionsheet.ActionSheet;
import com.strange.cdexpedition.R;
import com.strange.cdexpedition.activity.demo.Demo01Activity;
import com.strange.cdexpedition.activity.demo.MapActivity;
import com.strange.cdexpedition.adapter.PageAdapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by AngerYman on 2017/2/27.
 */
@ContentView(value = R.layout.fragment_home)
public class HomeFragment extends Fragment {

    private View view;

    @ViewInject(R.id.opengaodeditu)
    private View open;

    @ViewInject(R.id.home_viewpager)
    private ViewPager viewPager;

    @ViewInject(R.id.home_viewpagerstrip)
    private PagerSlidingTabStrip tabs;

    private PagerTabStrip pagerTabStrip = null;

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = x.view().inject(this,inflater,container);
        viewPager.setAdapter(new PageAdapter(getChildFragmentManager()));
        tabs.setViewPager(viewPager);
        return view;
    }

    @Event(R.id.opengaodeditu)
    private void open(View v){
        Intent intent = new Intent(getActivity(), MapActivity.class);
        startActivity(intent);
    }

}

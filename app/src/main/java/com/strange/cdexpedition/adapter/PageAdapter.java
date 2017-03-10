package com.strange.cdexpedition.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.strange.cdexpedition.fragment.Demo01Fragment;
import com.strange.cdexpedition.fragment.Demo02Fragment;
import com.strange.cdexpedition.fragment.Demo03Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AngerYman on 2017/3/7.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private String[] titles = {"页面一", "页面二", "页面三"};

    private List<Fragment> fragments = null;

    private FragmentManager fm;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
        fragments = new ArrayList<Fragment>();
        fragments.add(new Demo01Fragment());
        fragments.add(new Demo02Fragment());
        fragments.add(new Demo03Fragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

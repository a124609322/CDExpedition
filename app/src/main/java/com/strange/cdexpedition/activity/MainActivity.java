package com.strange.cdexpedition.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.strange.cdexpedition.R;
import com.strange.cdexpedition.commom.ActivityUtils;
import com.strange.cdexpedition.fragment.BStationFragment;
import com.strange.cdexpedition.fragment.HomeFragment;
import com.strange.cdexpedition.fragment.IndexFragment;
import com.strange.cdexpedition.fragment.WeiboFragment;
import com.strange.cdexpedition.fragment.YoukuFragment;

import org.xutils.view.annotation.ContentView;

@ContentView(value=R.layout.activity_main)
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private boolean isExit = false;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottombar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorAccent)
                .setText("5")
                .setHideOnSelect(true);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.baidu, "百度"))
                .addItem(new BottomNavigationItem(R.drawable.youku, "优酷").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.home, "首页").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.weibo, "微博").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.bilibili, "哔哩哔哩").setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(2)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
        changeFragment(new HomeFragment());
    }

    private void changeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finalApp();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void finalApp(){
        if(isExit){
            ActivityUtils.finishAll();
            System.exit(0);
        }else{
            isExit = true;
            handler.sendEmptyMessageDelayed(0,2000);
            Toast.makeText(MainActivity.this,"再次点击将退出程序！",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTabSelected(int position) {
        switch (position){
            case 0:
                changeFragment(new IndexFragment());
                break;
            case 1:
                changeFragment(new YoukuFragment());
                break;
            case 2:
                changeFragment(new HomeFragment());
                break;
            case 3:
                changeFragment(new WeiboFragment());
                break;
            case 4:
                changeFragment(new BStationFragment());
                break;
            default:
        }
    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {

    }
}

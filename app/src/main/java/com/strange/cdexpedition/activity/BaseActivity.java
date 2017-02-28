package com.strange.cdexpedition.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.strange.cdexpedition.commom.ActivityUtils;

/**
 * Created by AngerYman on 2017/2/27.
 */

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtils.finsh(this);
    }
}

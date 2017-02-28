package com.strange.cdexpedition.commom;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AngerYman on 2017/2/27.
 */

public class ActivityUtils {

    private static List<Activity> activityList = new ArrayList<Activity>();

    public static void add(Activity activity){
        activityList.add(activity);
    }

    public static void finsh(Activity activity){
        activityList.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity : activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}

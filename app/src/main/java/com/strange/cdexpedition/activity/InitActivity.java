package com.strange.cdexpedition.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.strange.cdexpedition.R;

public class InitActivity extends BaseActivity {

    private static final String TAG = "InitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
    }

    @Override
    protected void onResume() {
        super.onPostResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startMain();
                } catch (InterruptedException e) {
                    Log.e(TAG,e.getMessage(),e);
                }
            }
        }).start();
    }

    private void startMain(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(InitActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}

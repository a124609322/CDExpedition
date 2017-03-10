package com.strange.cdexpedition.activity.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.strange.cdexpedition.R;
import com.strange.cdexpedition.adapter.WomanAdapter;
import com.strange.cdexpedition.vo.Woman;

import java.util.ArrayList;
import java.util.List;

public class Demo01Activity extends AppCompatActivity {

    private XRecyclerView xRecyclerView;

    private List<Woman> womanList;

    private  WomanAdapter womanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo01);
        xRecyclerView = (XRecyclerView) findViewById(R.id.listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Demo01Activity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        womanList = new ArrayList<Woman>();
        Woman woman = new Woman();
        woman.setName("美女1");
        woman.setPhoto(R.drawable.woman1);
        womanList.add(woman);
        woman = new Woman();
        woman.setName("美女1");
        woman.setPhoto(R.drawable.woman1);
        womanList.add(woman);
        woman = new Woman();
        woman.setName("美女1");
        woman.setPhoto(R.drawable.woman1);
        womanList.add(woman);
        woman = new Woman();
        woman.setName("美女1");
        woman.setPhoto(R.drawable.woman1);
        womanList.add(woman);
        woman = new Woman();
        woman.setName("美女1");
        woman.setPhoto(R.drawable.woman1);
        womanList.add(woman);

        womanAdapter = new WomanAdapter(womanList);
        xRecyclerView.setAdapter(womanAdapter);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        //设置增加或删除条目的动画
        xRecyclerView.setItemAnimator( new DefaultItemAnimator());
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Woman woman = new Woman();
                woman.setName("美女2");
                woman.setPhoto(R.drawable.woman2);
                womanAdapter.addData(woman);
                //xRecyclerView.loadMoreComplete();
            }
        });
    }
}

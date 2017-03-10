package com.strange.cdexpedition.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.strange.cdexpedition.R;
import com.strange.cdexpedition.adapter.WomanAdapter;
import com.strange.cdexpedition.vo.Woman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AngerYman on 2017/3/7.
 */

public class Demo03Fragment extends Fragment {

    private View view;

    private List<Woman> womanList;

    private TextView foot;

    private WomanAdapter womanAdapter;

    private XRecyclerView xRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.viewpager_page3,container,false);
        foot = new TextView(getContext());
        foot.setText("正在加载中");
        foot.setGravity(Gravity.CENTER);
        xRecyclerView = (XRecyclerView) view.findViewById(R.id.listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
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

        womanAdapter = new WomanAdapter(womanList);
        xRecyclerView.setAdapter(womanAdapter);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                womanAdapter.refreshData();
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Woman woman = new Woman();
                woman.setName("美女2");
                woman.setPhoto(R.drawable.woman2);
                womanAdapter.addData(woman);
                xRecyclerView.loadMoreComplete();
            }
        });
        return view;
    }
}

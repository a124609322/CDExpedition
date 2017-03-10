package com.strange.cdexpedition.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.strange.cdexpedition.R;
import com.strange.cdexpedition.hoder.LocalImageHolderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AngerYman on 2017/3/7.
 */

public class Demo01Fragment extends Fragment {

    private View view;

    private List<Integer> imagelist = new ArrayList<Integer>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imagelist.add(R.drawable.image1);
        imagelist.add(R.drawable.image2);
        imagelist.add(R.drawable.image3);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.viewpager_page1,container,false);
        ConvenientBanner convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, imagelist)
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator,R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(3000)
                .setPointViewVisible(true).setCanLoop(true);
        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(),"点击"+position,Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:

                }
            }
        });
        return view;
    }
}

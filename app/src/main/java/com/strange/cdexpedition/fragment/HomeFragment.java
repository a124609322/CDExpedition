package com.strange.cdexpedition.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.baoyz.actionsheet.ActionSheet;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.strange.cdexpedition.R;
import com.strange.cdexpedition.adapter.WomanAdapter;
import com.strange.cdexpedition.hoder.LocalImageHolderView;
import com.strange.cdexpedition.vo.Woman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AngerYman on 2017/2/27.
 */

public class HomeFragment extends Fragment implements ActionSheet.ActionSheetListener {

    private View view;

    private List<View> viewList = null;

    private List<String> titleList = null;

    private List<Integer> imagelist = new ArrayList<Integer>();

    private PagerTabStrip pagerTabStrip = null;

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container, false);
        LayoutInflater li = getLayoutInflater(savedInstanceState).from(view.getContext());
        View page1 = li.inflate(R.layout.viewpager_page1,null);
        View page2 = li.inflate(R.layout.viewpager_page2,null);
        View page3 = li.inflate(R.layout.viewpager_page3,null);
        viewList = new ArrayList<View>();
        titleList = new ArrayList<String>();
        viewList.add(page1);
        titleList.add("page1");
        viewList.add(page2);
        titleList.add("page2");
        viewList.add(page3);
        titleList.add("page3");
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.home_viewpager);
        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };
        viewPager.setAdapter(pagerAdapter);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip)view.findViewById(R.id.home_viewpagerstrip);
        tabs.setViewPager(viewPager);

        imagelist.add(R.drawable.image1);
        imagelist.add(R.drawable.image2);
        imagelist.add(R.drawable.image3);
        ConvenientBanner convenientBanner = (ConvenientBanner) page1.findViewById(R.id.convenientBanner);
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

        picture = (ImageView) page2.findViewById(R.id.page2_header);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View.OnClickListener listener = this;
                ActionSheet.createBuilder(getActivity(), getActivity().getSupportFragmentManager())
                        .setCancelButtonTitle("退出")
                        .setOtherButtonTitles("拍照", "相册")
                        .setCancelableOnTouchOutside(true)
                        .setListener(HomeFragment.this)
                        .show();
            }
        });
        XRecyclerView xRecyclerView = (XRecyclerView) page3.findViewById(R.id.listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        List<Woman> womanList = new ArrayList<Woman>();
        Woman woman = new Woman();
        woman.setName("美女1");
        woman.setPhoto(R.drawable.woman1);
        womanList.add(woman);
        woman = new Woman();
        woman.setName("美女2");
        woman.setPhoto(R.drawable.woman2);
        womanList.add(woman);
        WomanAdapter womanAdapter = new WomanAdapter(womanList);
        xRecyclerView.setAdapter(womanAdapter);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //refresh data here
            }

            @Override
            public void onLoadMore() {
                // load more data here
            }
        });
        return view;
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
        switch (index){
            case 0:{
                takephoto();
                break;
            }
            case 1:{
                pickpictures();
                break;
            }
        }
    }


    public static final int CUT_PICTURE = 1;

    public static final int SHOW_PICTURE = 2;

    private ImageView picture;

    private Uri imageUri;

    private void takephoto(){
        //创建File对象，用于存储拍照后的图片
        //将此图片存储于SD卡的根目录下
        File outputImage = new File(Environment.getExternalStorageDirectory(),
                "output_image.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将File对象转换成Uri对象
        //Uri表标识着图片的地址
        imageUri = Uri.fromFile(outputImage);
        //隐式调用照相机程序
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        //拍下的照片会被输出到output_image.jpg中去
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        //此处是使用的startActivityForResult（）
        //因此在拍照完后悔有结果返回到onActivityResult（）中去，返回值即为<span style="font-size: 13.3333px; font-family: Arial, Helvetica, sans-serif;">CUT_PICTURE</span>
        //onActivityResult（）中主要是实现图片裁剪
        startActivityForResult(intent, CUT_PICTURE);
    }

    private void pickpictures(){
        File outputImage = new File(Environment.getExternalStorageDirectory(),
                "output_image.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageUri = Uri.fromFile(outputImage);
        Intent intent = new Intent(Intent.ACTION_PICK,null);
        //此处调用了图片选择器
        //如果直接写intent.setDataAndType("image/*");
        //调用的是系统图库
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        //intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, CUT_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CUT_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    //此处启动裁剪程序
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    if(null == data){
                        intent.setDataAndType(imageUri, "image/*");
                    }else{
                        intent.setDataAndType(data.getData(), "image/*");
                    }
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, SHOW_PICTURE);
                }
                break;
            case SHOW_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    try {
                        //将output_image.jpg对象解析成Bitmap对象，然后设置到ImageView中显示出来
                        Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver()
                                .openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }
}

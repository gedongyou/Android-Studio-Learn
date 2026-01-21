package com.example.model_d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import Adapter.vpAdapter;


public class wzcxFragment extends Fragment {


    public wzcxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wzcx, container, false);


        ViewPager vp = view.findViewById(R.id.vp);
        TabLayout tl = view.findViewById(R.id.tl);

        int[] imgArr = {R.drawable.hzltx, R.drawable.hzltx, R.drawable.hzltx, R.drawable.hzltx};
        int[] imgArr1 = {R.drawable.hzltx, R.drawable.hzl, R.drawable.fg, R.drawable.fg1};
        String[] nameArr = {"违章视频1", "违章视频2", "违章视频3", "违章视频4"};
        String[] nameArr1 = {"违章照片1", "违章照片2", "违章照片3", "违章照片4"};

        int[] VideoResId = {R.raw.cxk, R.raw.abc, R.raw.cs, R.raw.efg};
        int[] ImgResId = {R.drawable.hzltx, R.drawable.hzl, R.drawable.fg, R.drawable.fg1};


        String[] tabArr = {"违章视频", "违章照片"};
        List<int[]> imgList = new ArrayList();
        imgList.add(imgArr);
        imgList.add(imgArr1);


        List<String[]> nameList = new ArrayList();
        nameList.add(nameArr);
        nameList.add(nameArr1);

        List<int[]> mediaList = new ArrayList<>();
        mediaList.add(VideoResId);
        mediaList.add(ImgResId);

        vpAdapter adapter = new vpAdapter(getContext(), tabArr, imgList, nameList, mediaList);

        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);

        return view;
    }
}
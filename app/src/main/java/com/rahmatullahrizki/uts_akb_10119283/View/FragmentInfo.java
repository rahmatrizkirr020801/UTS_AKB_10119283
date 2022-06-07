package com.rahmatullahrizki.uts_akb_10119283.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.rahmatullahrizki.uts_akb_10119283.Presenter.SlidePagerAdapter;
import com.rahmatullahrizki.uts_akb_10119283.R;

import java.util.ArrayList;
import java.util.List;

// selasa 7 juni 2022, 1011983, Rahmatullah Rizki, IF7
public class FragmentInfo extends Fragment{
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_beranda, null, false);
        List<Fragment> list = new ArrayList<>();

        list.add(new PageFragment1());
        list.add(new PageFragment2());

        pager = view.findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getChildFragmentManager(), list);
        pager.setAdapter(pagerAdapter);
        return view;
    }



}

package com.example.mystepper;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
import java.util.Objects;

/**
 * Created by Md Minhajul Islam on 11/04/2023.
 */
public class StepPagerAdapter extends FragmentStateAdapter {
    private List<Step> stepList;

    public StepPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Step> stepList) {
        super(fragmentActivity);
        this.stepList = stepList;
    }

//    public StepPagerAdapter(@NonNull Fragment fragment, List<Step> stepList) {
//        super(fragment);
//        this.stepList = stepList;
//    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        StepSegment fragment = new StepSegment();
//        String selectedGroup = Objects.requireNonNull(Objects.requireNonNull(tabLayout.getTabAt(position)).getText()).toString();
        for (Step s : stepList) {
            fragment.setCallback(s);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return stepList.size();
    }
}


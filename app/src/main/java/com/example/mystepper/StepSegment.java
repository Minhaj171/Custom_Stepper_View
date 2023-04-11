package com.example.mystepper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mystepper.databinding.FragmentStepSegmentBinding;

public class StepSegment extends Fragment {
    private FragmentStepSegmentBinding binding;
    private Step step;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStepSegmentBinding.inflate(inflater, container, false);
        binding.textView.setText(step.getTitle());
       return binding.getRoot();
    }

    public void setCallback(Step s) {
        this.step = s;
    }
}
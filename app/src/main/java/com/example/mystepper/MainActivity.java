package com.example.mystepper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.mystepper.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IStepClick, View.OnClickListener {
    private ActivityMainBinding binding;
    private int currentPos;
    private RAdapter adapter;
    private  List<Step> stepList;
    private LinearLayoutManager layoutManager;
    private Step step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnNext.setOnClickListener(this);
        binding.btnPrevious.setOnClickListener(this);

      //  ovalTextView = findViewById(R.id.oval_text);
       // ovalTextView.setShowImage(true);
      //  ovalTextView.setImageDrawable(getResources().getDrawable(R.drawable.baseline_done_24));

        setTabLayout();
    }

    private void setTabLayout() {
        stepList = new ArrayList<>();
        stepList.add(new Step(1, "Personal Info", false, 0));
        stepList.add(new Step(2, "Network Info", false, 1));
        stepList.add(new Step(3, "Service Info", false, 2));

        adapter = new RAdapter(stepList, binding.viewPager2, this, this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(int position, Step step) {
        currentPos = position;
        this.step = step;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            if (currentPos <= stepList.size()){
                int position = currentPos + 1;
                layoutManager.smoothScrollToPosition(binding.recyclerView, null, position);
                adapter.setCurrentUserPosition(position, step);
            }
        }else if (v.getId() == R.id.btnPrevious){
            if (currentPos != 0){
                int position = currentPos - 1;
                layoutManager.smoothScrollToPosition(binding.recyclerView, null, position);
                adapter.setCurrentUserPosition(position, step);
            }
        }
    }
}
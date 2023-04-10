package com.example.mystepper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.mystepper.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

      //  ovalTextView = findViewById(R.id.oval_text);
       // ovalTextView.setShowImage(true);
      //  ovalTextView.setImageDrawable(getResources().getDrawable(R.drawable.baseline_done_24));

        setTabLayout();
    }

    private void setTabLayout() {
        List<Step> stepList = new ArrayList<>();
        stepList.add(new Step(1, "Personal Info", false, 0));
        stepList.add(new Step(2, "Network Info", false, 1));
        stepList.add(new Step(3, "Service Info", false, 2));

        RAdapter adapter = new RAdapter(stepList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        binding.recyclerView.setAdapter(adapter);
    }


}
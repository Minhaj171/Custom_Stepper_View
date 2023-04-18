package com.example.mystepper;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mystepper.databinding.ItemRowBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/04/2023.
 */
public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {
    private List<Step> stepList;
    private boolean isLastPos;
    private boolean isFirstPos;
    private static int currentUserPosition = 0;
    private static int previousPosition;
    private ViewPager2 viewPager2;
    private MainActivity mainActivity;
    private IStepClick iStepClick;

    public RAdapter(List<Step> stepList, ViewPager2 viewPager2, MainActivity mainActivity, IStepClick iStepClick){
        this.stepList = stepList;
        this.viewPager2 = viewPager2;
        this.mainActivity = mainActivity;
        this.iStepClick = iStepClick;
    }

    @NonNull
    @Override
    public RAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRowBinding view = ItemRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RAdapter.ViewHolder holder, int position) {
        Step step = stepList.get(position);
        if (position == currentUserPosition) { // check if current position is the same as the user's position
            boolean isFirstPos = position == 0;
            boolean isLastPos = position == getItemCount() - 1;
            boolean isCurrentPos = position == currentUserPosition;
            //holder.bindView(step, isLastPos, isFirstPos);

            holder.bindView(true, step);

            List<Step> stepList1 = new ArrayList<>();
            stepList1.add(step);

            StepPagerAdapter pagerAdapter = new StepPagerAdapter(mainActivity, stepList1);
            viewPager2.setAdapter(pagerAdapter);
            iStepClick.onItemClick(position, step);
            if (isLastPos){
                holder.binding.viewLine.setVisibility(View.GONE);
            }
        }else {
            holder.bindView(false, step);
        }

    }


    @Override
    public int getItemCount() {
        return stepList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRowBinding binding;

        public ViewHolder(ItemRowBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void bindView(boolean isCurrentPos, Step step){
            binding.ovalText.setText(String.valueOf(step.getId()));
            binding.textView.setText(step.getTitle());
            if (isCurrentPos){
                binding.textView.setTextColor(Color.BLACK);
                binding.ovalText.setBackgroundPaintColor(0xFF03A9F4);
            }else if (previousPosition < currentUserPosition){
                binding.ovalText.setShowImage(true);
                binding.ovalText.setImageDrawable(ResourcesCompat.getDrawable(itemView.getResources(), R.drawable.baseline_done_24, null));
                binding.ovalText.setBackgroundPaintColor(0xFFD3D3D3);
            }else {
                binding.ovalText.setBackgroundPaintColor(0xFFD3D3D3);
            }
        }
    }

    public void setCurrentUserPosition(int position, Step step) {
        if (stepList.isEmpty() || position > stepList.size()) {
            return;
        }
        int previousUserPosition = currentUserPosition;
        currentUserPosition = position;
        previousPosition = position - 1;
        if (previousUserPosition >= 0 && previousUserPosition < stepList.size()) {
            notifyItemChanged(previousUserPosition);
        }
        notifyItemChanged(currentUserPosition);
    }


    public void setPreviousPosition(int position){
        notifyItemChanged(position);
    }
}

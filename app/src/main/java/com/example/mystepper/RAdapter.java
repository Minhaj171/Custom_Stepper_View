package com.example.mystepper;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mystepper.databinding.ItemRowBinding;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/04/2023.
 */
public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {
    private List<Step> stepList;
    private boolean isLastPos;
    private boolean isFirstPos;

    public RAdapter(List<Step> stepList){
        this.stepList = stepList;
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
        isFirstPos = position == 0;

        if (position == getItemCount() - 1){
            isLastPos = true;
        }
        holder.bindView(step, isLastPos, isFirstPos);
    }

    @Override
    public int getItemCount() {
        return stepList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ItemRowBinding binding;
        public ViewHolder(@NonNull ItemRowBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }


        public void bindView(Step step, boolean isLastPos, boolean isFirstPos) {
            binding.ovalText.setText(String.valueOf(step.getId()));
            binding.textView.setText(step.getTitle());
           // binding.ovalText.setBackgroundPaintColor(0xFFD3D3D3);
            if (isFirstPos){
                binding.textView.setTextColor(Color.BLACK);
                binding.ovalText.setBackgroundPaintColor(0xFF03A9F4);
            }else {
                binding.ovalText.setBackgroundPaintColor(0xFFD3D3D3);
                //0xFF03A9F4
            }

            if (isLastPos){
                binding.viewLine.setVisibility(View.GONE);
            }
        }
    }
}

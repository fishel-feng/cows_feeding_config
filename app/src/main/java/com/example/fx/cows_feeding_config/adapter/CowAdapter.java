package com.example.fx.cows_feeding_config.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Cow;

import java.util.List;

/**
 * Created by fx on 2017/9/11.
 */

public class CowAdapter extends RecyclerView.Adapter<CowAdapter.ViewHolder> implements View.OnClickListener {

    private List<Cow> cowList;

    private OnItemClickListener onItemClickListener;

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View cowView;

        TextView tvCowVariety;
        TextView tvCowWeight;
        TextView tvCowMilkProduction;

        public ViewHolder(View itemView) {
            super(itemView);
            cowView = itemView;
            tvCowVariety = itemView.findViewById(R.id.tv_1);
            tvCowWeight = itemView.findViewById(R.id.tv_2);
            tvCowMilkProduction = itemView.findViewById(R.id.tv_3);
        }
    }

    public CowAdapter(List<Cow> cowList) {
        this.cowList = cowList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cow cow = cowList.get(position);
        holder.tvCowVariety.setText(cow.getVariety());
        holder.tvCowWeight.setText(String.valueOf(cow.getWeight()));
        holder.tvCowMilkProduction.setText(String.valueOf(cow.getMilkProduction()));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return cowList.size();
    }


}

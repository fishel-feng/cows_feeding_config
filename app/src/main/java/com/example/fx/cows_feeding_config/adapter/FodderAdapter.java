package com.example.fx.cows_feeding_config.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

import java.util.List;

/**
 * Created by fx on 2017/9/11.
 */

public class FodderAdapter extends RecyclerView.Adapter<FodderAdapter.ViewHolder> implements View.OnClickListener {

    private List<Fodder> fodderList;

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
        View fodderView;

        TextView tvFodderName;
        TextView tvFodderType;
        TextView tvFodderPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            fodderView = itemView;
            tvFodderName = itemView.findViewById(R.id.tv_1);
            tvFodderType = itemView.findViewById(R.id.tv_2);
            tvFodderPrice = itemView.findViewById(R.id.tv_3);
        }
    }

    public FodderAdapter(List<Fodder> fodderList) {
        this.fodderList = fodderList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fodder fodder = fodderList.get(position);
        holder.tvFodderName.setText(fodder.getName());
        holder.tvFodderType.setText(fodder.getType() == 1 ? "粗饲料" : "精饲料");
        holder.tvFodderPrice.setText(fodder.getPrice()!=0?String.valueOf(fodder.getPrice()):"暂无价格");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return fodderList.size();
    }


}

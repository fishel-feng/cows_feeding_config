package com.example.fx.cows_feeding_config.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fx on 2017/9/13.
 */

public class FodderListAdapter extends RecyclerView.Adapter<FodderListAdapter.ViewHolder> implements View.OnClickListener {

    private List<Fodder> fodderList;

    private List<Fodder> fodderInfoList = new ArrayList<>();
    private List<Fodder> fodderRemoveList = new ArrayList<>();

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
        CheckBox ckFodder;

        public ViewHolder(View itemView) {
            super(itemView);
            fodderView = itemView;
            tvFodderName = itemView.findViewById(R.id.tv_1);
            tvFodderType = itemView.findViewById(R.id.tv_2);
            tvFodderPrice = itemView.findViewById(R.id.tv_3);
            ckFodder = itemView.findViewById(R.id.ck_fodder);
        }
    }

    public FodderListAdapter(List<Fodder> fodderList) {
        this.fodderList = fodderList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Fodder fodder = fodderList.get(position);
        holder.tvFodderName.setText(fodder.getName());
        holder.tvFodderType.setText(fodder.getType() == 1 ? "粗饲料" : "精饲料");
        holder.tvFodderPrice.setText(fodder.getPrice() != 0 ? String.valueOf(fodder.getPrice()) : "暂无价格");
        if (fodderList.get(position).isChecked()) {
            holder.ckFodder.setChecked(true);
        }
        if (!fodderList.get(position).isChecked()) {
            holder.ckFodder.setChecked(false);
        }
        final Fodder[] click = new Fodder[1];
        holder.ckFodder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                click[0] = fodderList.get(position);
                if (b) {
                    fodderInfoList.add(click[0]);
                    if (fodderRemoveList.contains(click[0])) {
                        fodderRemoveList.remove(click[0]);
                    }
                }
            }
        });
        holder.ckFodder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!((CheckBox) view).isChecked()) {
                    if (fodderInfoList.contains(click[0])) {
                        fodderInfoList.remove(click[0]);
                    }
                    fodderRemoveList.add(click[0]);
                }
            }
        });
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return fodderList.size();
    }

    public List<Fodder> getFodderInfoList() {
        return fodderInfoList;
    }

    public List<Fodder> getFodderRemoveList() {
        return fodderRemoveList;
    }

}

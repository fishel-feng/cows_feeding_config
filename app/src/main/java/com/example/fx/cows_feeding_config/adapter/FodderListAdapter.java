package com.example.fx.cows_feeding_config.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.entity.Fodder;

import java.util.List;

/**
 * Created by fx on 2017/9/13.
 */

public class FodderListAdapter extends RecyclerView.Adapter<FodderListAdapter.ViewHolder> {

    private List<Fodder> fodderList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox ckFodder;
        TextView fodderName;
        TextView fodderType;
        TextView fodderPrice;

        public ViewHolder(View itemView) {
            super(itemView);
//            TODO
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

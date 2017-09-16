package com.example.fx.cows_feeding_config.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.gson.FodderResult;

import java.util.List;

/**
 * Created by fx on 2017/9/16.
 */

public class ResultAdapter extends ArrayAdapter<FodderResult> {

    private int resourceId;

    public ResultAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<FodderResult> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FodderResult fodderResult = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvResultName = view.findViewById(R.id.tv_result_name);
            viewHolder.tvResultDosage = view.findViewById(R.id.tv_result_dosage);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (fodderResult != null) {
            viewHolder.tvResultName.setText(fodderResult.name);
        }
        if (fodderResult != null) {
            viewHolder.tvResultDosage.setText(fodderResult.dosage);
        }
        return view;
    }

    class ViewHolder {
        TextView tvResultName;
        TextView tvResultDosage;
    }
}

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
import com.example.fx.cows_feeding_config.entity.Fodder;

import java.util.List;

/**
 * Created by fx on 2017/9/11.
 */

public class ItemAdapter extends ArrayAdapter<Fodder> {

    private int resourceId;

    public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Fodder> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fodder fodder = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvFodderName = view.findViewById(R.id.tv_fodder_name);
            viewHolder.tvFodderType = view.findViewById(R.id.tv_fodder_type);
            viewHolder.tvFodderPrice = view.findViewById(R.id.tv_fodder_price);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (fodder != null) {
            viewHolder.tvFodderName.setText(fodder.getName());
            viewHolder.tvFodderType.setText(fodder.getType() == 1 ? "粗饲料" : "精饲料");
            viewHolder.tvFodderPrice.setText(String.valueOf(fodder.getPrice()));
        }
        return view;
    }


    private class ViewHolder {

        TextView tvFodderName;

        TextView tvFodderType;

        TextView tvFodderPrice;
    }
}

package com.example.fx.cows_feeding_config.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.fx.cows_feeding_config.entity.Fodder;

/**
 * Created by fx on 2017/9/11.
 */

public class ItemAdapter extends ArrayAdapter<Fodder> {

    public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Fodder[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}

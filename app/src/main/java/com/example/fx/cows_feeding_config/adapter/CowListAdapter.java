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
import com.example.fx.cows_feeding_config.entity.Cow;

import java.util.List;

/**
 * Created by fx on 2017/9/13.
 */

public class CowListAdapter extends ArrayAdapter<Cow> {

    private int resourceId;

    public CowListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Cow> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cow cow=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.tv1=view.findViewById(R.id.tv_1);
            viewHolder.tv2=view.findViewById(R.id.tv_2);
            viewHolder.tv3=view.findViewById(R.id.tv_3);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.tv1.setText(cow.getVariety());
        viewHolder.tv2.setText(String.valueOf(cow.getWeight()));
        viewHolder.tv3.setText(String.valueOf(cow.getMilkProtein()));
        return view;
    }

    class ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }
}

package com.example.fx.cows_feeding_config.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

import java.util.List;

/**
 * Created by fx on 2017/9/14.
 */

public class FodderInfoAdapter extends ArrayAdapter<Fodder> {

    private int resourceId;

    private Fodder fodder;

    private ViewHolder viewHolder;

    public FodderInfoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Fodder> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        fodder = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvFodder = view.findViewById(R.id.tv_fodder);
            viewHolder.etPrice = view.findViewById(R.id.et_price);
            viewHolder.etDosage = view.findViewById(R.id.et_dosage);
            viewHolder.etMax = view.findViewById(R.id.et_max);
            viewHolder.etMin = view.findViewById(R.id.et_min);
            viewHolder.spVariable = view.findViewById(R.id.sp_variable);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (fodder != null) {
            viewHolder.tvFodder.setText(fodder.getName());
            viewHolder.etPrice.setText(String.valueOf(fodder.getPrice()));
        }
        return view;
    }

    public void setContent() {
        fodder.setPrice(viewHolder.etPrice.getText() == null ? Double.valueOf(String.valueOf(viewHolder.etPrice.getText())) : 0);
        fodder.setDosage(viewHolder.etDosage.getText() == null ? Double.valueOf(String.valueOf(viewHolder.etDosage.getText())) : 0);
        fodder.setMaxDosage(viewHolder.etMax.getText() == null ? Double.valueOf(String.valueOf(viewHolder.etMax.getText())) : 0);
        fodder.setMinDosage(viewHolder.etMin.getText() == null ? Double.valueOf(String.valueOf(viewHolder.etMin.getText())) : 0);
        fodder.setVariable(viewHolder.spVariable.getSelectedItemPosition() == 1);
    }

    class ViewHolder {
        TextView tvFodder;
        EditText etPrice;
        EditText etDosage;
        EditText etMax;
        EditText etMin;
        Spinner spVariable;
    }
}

package com.example.fx.cows_feeding_config.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.fx.cows_feeding_config.gson.FodderResult;

import java.util.List;

/**
 * Created by fx on 2017/9/16.
 */

public class ResultAdapter extends ArrayAdapter<FodderResult> {
    public ResultAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<FodderResult> objects) {
        super(context, resource, objects);
    }
}

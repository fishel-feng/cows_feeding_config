package com.example.fx.cows_feeding_config.gson;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fx on 2017/9/16.
 */

public class Result implements Serializable {

    public String code;

    public String price;

    @SerializedName("fodder")
    public List<FodderResult> fodderResults;
}

package com.example.fx.cows_feeding_config.util;

import com.example.fx.cows_feeding_config.entity.Cow;
import com.example.fx.cows_feeding_config.entity.Fodder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by fx on 2017/9/15.
 */

public class ObjectToJsonUtil {

    public static JSONObject objectToJson(List<Fodder> fodders, Cow cow, int coarse, int concentrate) throws JSONException {
        JSONObject result = new JSONObject();
        JSONArray fodderArray = new JSONArray();
        JSONObject cowObject = new JSONObject();
        result.put("fodder", fodderArray);
        result.put("cow", cowObject);
        result.put("coarse", coarse);
        result.put("concentrate", concentrate);
        for (int i = 0; i < fodders.size(); i++) {
            JSONObject fodderObject = new JSONObject();
            Fodder fodder = fodders.get(i);
            fodderObject.put("name", fodder.getName());
            fodderObject.put("type", fodder.getType());
            fodderObject.put("dry_matter", fodder.getDryMatter());
            fodderObject.put("calcium", fodder.getCalcium());
            fodderObject.put("phosphorus", fodder.getPhosphorus());
            fodderObject.put("energy", fodder.getEnergy());
            fodderObject.put("crude_protein", fodder.getCrudeProtein());
            fodderObject.put("price", fodder.getPrice());
            fodderObject.put("variable", fodder.isVariable());
            fodderObject.put("dosage", fodder.getDosage());
            fodderObject.put("max_dosage", fodder.getMaxDosage());
            fodderObject.put("min_dosage", fodder.getMinDosage());
            fodderArray.put(fodderObject);
        }
        cowObject.put("variety", cow.getVariety());
        cowObject.put("weight", cow.getWeight());
        cowObject.put("weight_change", cow.getWeightChange());
        cowObject.put("milk_production", cow.getMilkProduction());
        cowObject.put("milk_fat", cow.getMilkFat());
        cowObject.put("milk_protein", cow.getMilkProtein());
        cowObject.put("lactation_weeks", cow.getLactationWeeks());
        return result;
    }
}

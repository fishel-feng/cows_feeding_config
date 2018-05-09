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
        result.put("coarse", String.valueOf(coarse));
        result.put("concentrate", String.valueOf(concentrate));
        for (int i = 0; i < fodders.size(); i++) {
            JSONObject fodderObject = new JSONObject();
            Fodder fodder = fodders.get(i);
            fodderObject.put("name", fodder.getName());
            fodderObject.put("type", String.valueOf(fodder.getType()));
            fodderObject.put("dry_matter", String.valueOf(fodder.getDryMatter()));
            fodderObject.put("crude_protein", String.valueOf(fodder.getCrudeProtein()));
            fodderObject.put("energy", String.valueOf(fodder.getEnergy()));
            fodderObject.put("calcium", String.valueOf(fodder.getCalcium()));
            fodderObject.put("phosphorus", String.valueOf(fodder.getPhosphorus()));
            fodderObject.put("sodium", String.valueOf(fodder.getSodium()));
            fodderObject.put("chlorine", String.valueOf(fodder.getChlorine()));
            fodderObject.put("potassium", String.valueOf(fodder.getPotassium()));
            fodderObject.put("magnesium", String.valueOf(fodder.getMagnesium()));
            fodderObject.put("sulphur", String.valueOf(fodder.getSulphur()));
            fodderObject.put("crude_fat", String.valueOf(fodder.getCrudeFat()));
            fodderObject.put("price", String.valueOf(fodder.getPrice()));
            fodderObject.put("variable", String.valueOf(fodder.isVariable()));
            fodderObject.put("dosage", String.valueOf(fodder.getDosage()));
            fodderObject.put("max_dosage", String.valueOf(fodder.getMaxDosage()));
            fodderObject.put("min_dosage", String.valueOf(fodder.getMinDosage()));
            fodderArray.put(fodderObject);
        }
        cowObject.put("variety", cow.getVariety());
        cowObject.put("weight", String.valueOf(cow.getWeight()));
        cowObject.put("milk_days", String.valueOf(cow.getMilkDays()));
        cowObject.put("milk_production", String.valueOf(cow.getMilkProduction()));
        cowObject.put("milk_week", String.valueOf(cow.getMilkWeek()));
        cowObject.put("milk_fat", String.valueOf(cow.getMilkFat()));
        return result;
    }
}

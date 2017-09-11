package com.example.fx.cows_feeding_config.entity;

import org.litepal.crud.DataSupport;

/**
 * Created by fx on 2017/9/11.
 */

public class Cow extends DataSupport {

    private int id;

    private String variety;

    private double weight;

    private double milkProduction;

    private double milkFat;

    private double milkProtein;

    private double lactationWeeks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMilkProduction() {
        return milkProduction;
    }

    public void setMilkProduction(double milkProduction) {
        this.milkProduction = milkProduction;
    }

    public double getMilkFat() {
        return milkFat;
    }

    public void setMilkFat(double milkFat) {
        this.milkFat = milkFat;
    }

    public double getMilkProtein() {
        return milkProtein;
    }

    public void setMilkProtein(double milkProtein) {
        this.milkProtein = milkProtein;
    }

    public double getLactationWeeks() {
        return lactationWeeks;
    }

    public void setLactationWeeks(double lactationWeeks) {
        this.lactationWeeks = lactationWeeks;
    }
}

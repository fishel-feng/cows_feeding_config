package com.example.fx.cows_feeding_config.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by fx on 2017/9/11.
 */

public class Cow extends DataSupport implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.variety);
        dest.writeDouble(this.weight);
        dest.writeDouble(this.milkProduction);
        dest.writeDouble(this.milkFat);
        dest.writeDouble(this.milkProtein);
        dest.writeDouble(this.lactationWeeks);
    }

    public Cow() {
    }

    protected Cow(Parcel in) {
        this.id = in.readInt();
        this.variety = in.readString();
        this.weight = in.readDouble();
        this.milkProduction = in.readDouble();
        this.milkFat = in.readDouble();
        this.milkProtein = in.readDouble();
        this.lactationWeeks = in.readDouble();
    }

    public static final Creator<Cow> CREATOR = new Creator<Cow>() {
        @Override
        public Cow createFromParcel(Parcel source) {
            return new Cow(source);
        }

        @Override
        public Cow[] newArray(int size) {
            return new Cow[size];
        }
    };
}

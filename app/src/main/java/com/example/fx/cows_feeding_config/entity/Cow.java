package com.example.fx.cows_feeding_config.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by fx on 2017/9/11.
 */

public class Cow extends DataSupport implements Parcelable {

    private int id;

    // 品种
    private String variety;

    // 体重
    private double weight;

    // 产奶天数
    private double milkDays;

    // 产奶量
    private double milkProduction;

    // 泌乳周
    private double milkWeek;

    // 乳脂率
    private double milkFat;

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

    public double getMilkDays() {
        return milkDays;
    }

    public void setMilkDays(double milkDays) {
        this.milkDays = milkDays;
    }

    public double getMilkProduction() {
        return milkProduction;
    }

    public void setMilkProduction(double milkProduction) {
        this.milkProduction = milkProduction;
    }

    public double getMilkWeek() {
        return milkWeek;
    }

    public void setMilkWeek(double milkWeek) {
        this.milkWeek = milkWeek;
    }

    public double getMilkFat() {
        return milkFat;
    }

    public void setMilkFat(double milkFat) {
        this.milkFat = milkFat;
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
        dest.writeDouble(this.milkDays);
        dest.writeDouble(this.milkProduction);
        dest.writeDouble(this.milkWeek);
        dest.writeDouble(this.milkFat);
    }

    public Cow() {
    }

    protected Cow(Parcel in) {
        this.id = in.readInt();
        this.variety = in.readString();
        this.weight = in.readDouble();
        this.milkDays = in.readDouble();
        this.milkProduction = in.readDouble();
        this.milkWeek = in.readDouble();
        this.milkFat = in.readDouble();
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

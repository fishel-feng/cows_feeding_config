package com.example.fx.cows_feeding_config.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by fx on 2017/9/11.
 */

public class Fodder extends DataSupport implements Parcelable {

    private int id;

    private String name;

    //类型 1粗饲料2精饲料
    private int type;

    private double dryMatter;

    private double calcium;

    private double phosphorus;

    private double energy;

    private double crudeProtein;

    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDryMatter() {
        return dryMatter;
    }

    public void setDryMatter(double dryMatter) {
        this.dryMatter = dryMatter;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getCrudeProtein() {
        return crudeProtein;
    }

    public void setCrudeProtein(double crudeProtein) {
        this.crudeProtein = crudeProtein;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.type);
        dest.writeDouble(this.dryMatter);
        dest.writeDouble(this.calcium);
        dest.writeDouble(this.phosphorus);
        dest.writeDouble(this.energy);
        dest.writeDouble(this.crudeProtein);
        dest.writeDouble(this.price);
    }

    public Fodder() {
    }

    protected Fodder(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.type = in.readInt();
        this.dryMatter = in.readDouble();
        this.calcium = in.readDouble();
        this.phosphorus = in.readDouble();
        this.energy = in.readDouble();
        this.crudeProtein = in.readDouble();
        this.price = in.readDouble();
    }

    public static final Creator<Fodder> CREATOR = new Creator<Fodder>() {
        @Override
        public Fodder createFromParcel(Parcel source) {
            return new Fodder(source);
        }

        @Override
        public Fodder[] newArray(int size) {
            return new Fodder[size];
        }
    };
}

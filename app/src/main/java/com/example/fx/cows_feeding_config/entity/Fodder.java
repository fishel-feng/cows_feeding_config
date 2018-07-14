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

    //类型 1精饲料 2粗饲料 3添加剂
    private int type;

    // 干物质
    private double dryMatter;

    // 粗蛋白
    private double crudeProtein;

    // 能量
    private double energy;

    // 钙
    private double calcium;

    // 磷
    private double phosphorus;

    // 钠
    private double sodium;

    // 氯
    private double chlorine;

    // 钾
    private double potassium;

    // 镁
    private double magnesium;

    // 硫
    private double sulphur;

    // 粗脂肪
    private double crudeFat;

    private double price;

    protected boolean variable;

    protected double dosage;

    protected double maxDosage;

    protected double minDosage;

    protected boolean isChecked;

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

    public double getCrudeProtein() {
        return crudeProtein;
    }

    public void setCrudeProtein(double crudeProtein) {
        this.crudeProtein = crudeProtein;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
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

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getChlorine() {
        return chlorine;
    }

    public void setChlorine(double chlorine) {
        this.chlorine = chlorine;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    public double getSulphur() {
        return sulphur;
    }

    public void setSulphur(double sulphur) {
        this.sulphur = sulphur;
    }

    public double getCrudeFat() {
        return crudeFat;
    }

    public void setCrudeFat(double crudeFat) {
        this.crudeFat = crudeFat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVariable() {
        return variable;
    }

    public void setVariable(boolean variable) {
        this.variable = variable;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    public double getMaxDosage() {
        return maxDosage;
    }

    public void setMaxDosage(double maxDosage) {
        this.maxDosage = maxDosage;
    }

    public double getMinDosage() {
        return minDosage;
    }

    public void setMinDosage(double minDosage) {
        this.minDosage = minDosage;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Fodder() {
    }

    public Fodder(String name, int type, double dryMatter, double crudeProtein, double energy, double calcium, double phosphorus, double sodium, double chlorine, double potassium, double magnesium, double sulphur, double crudeFat) {
        this.name = name;
        this.type = type;
        this.dryMatter = dryMatter;
        this.crudeProtein = crudeProtein;
        this.energy = energy;
        this.calcium = calcium;
        this.phosphorus = phosphorus;
        this.sodium = sodium;
        this.chlorine = chlorine;
        this.potassium = potassium;
        this.magnesium = magnesium;
        this.sulphur = sulphur;
        this.crudeFat = crudeFat;
    }

    public Fodder(String name, int type, double dryMatter, double crudeProtein, double energy, double calcium, double phosphorus, double sodium, double chlorine, double potassium, double magnesium, double sulphur, double crudeFat, double price) {
        this.name = name;
        this.type = type;
        this.dryMatter = dryMatter;
        this.crudeProtein = crudeProtein;
        this.energy = energy;
        this.calcium = calcium;
        this.phosphorus = phosphorus;
        this.sodium = sodium;
        this.chlorine = chlorine;
        this.potassium = potassium;
        this.magnesium = magnesium;
        this.sulphur = sulphur;
        this.crudeFat = crudeFat;
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
        dest.writeDouble(this.crudeProtein);
        dest.writeDouble(this.energy);
        dest.writeDouble(this.calcium);
        dest.writeDouble(this.phosphorus);
        dest.writeDouble(this.sodium);
        dest.writeDouble(this.chlorine);
        dest.writeDouble(this.potassium);
        dest.writeDouble(this.magnesium);
        dest.writeDouble(this.sulphur);
        dest.writeDouble(this.crudeFat);
        dest.writeDouble(this.price);
        dest.writeByte(this.variable ? (byte) 1 : (byte) 0);
        dest.writeDouble(this.dosage);
        dest.writeDouble(this.maxDosage);
        dest.writeDouble(this.minDosage);
        dest.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
    }

    protected Fodder(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.type = in.readInt();
        this.dryMatter = in.readDouble();
        this.crudeProtein = in.readDouble();
        this.energy = in.readDouble();
        this.calcium = in.readDouble();
        this.phosphorus = in.readDouble();
        this.sodium = in.readDouble();
        this.chlorine = in.readDouble();
        this.potassium = in.readDouble();
        this.magnesium = in.readDouble();
        this.sulphur = in.readDouble();
        this.crudeFat = in.readDouble();
        this.price = in.readDouble();
        this.variable = in.readByte() != 0;
        this.dosage = in.readDouble();
        this.maxDosage = in.readDouble();
        this.minDosage = in.readDouble();
        this.isChecked = in.readByte() != 0;
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

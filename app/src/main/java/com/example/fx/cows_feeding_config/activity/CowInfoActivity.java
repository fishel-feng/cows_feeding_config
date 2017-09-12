package com.example.fx.cows_feeding_config.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Cow;

public class CowInfoActivity extends AppCompatActivity {

    private android.widget.EditText etVariety;
    private android.widget.EditText etWeight;
    private android.widget.EditText etWeightChange;
    private android.widget.EditText etMilkProduction;
    private android.widget.EditText etMilkFat;
    private android.widget.EditText etMilkProtein;
    private android.widget.EditText etLactationWeeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_info);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.etLactationWeeks = (EditText) findViewById(R.id.et_lactation_weeks);
        this.etMilkProtein = (EditText) findViewById(R.id.et_milk_protein);
        this.etMilkFat = (EditText) findViewById(R.id.et_milk_fat);
        this.etMilkProduction = (EditText) findViewById(R.id.et_milk_production);
        this.etWeightChange = (EditText) findViewById(R.id.et_weight_change);
        this.etWeight = (EditText) findViewById(R.id.et_weight);
        this.etVariety = (EditText) findViewById(R.id.et_variety);
    }

    private void initData() {
        Cow cow = getIntent().getParcelableExtra("cow");
        etVariety.setText(String.valueOf(cow.getVariety()));
        etWeight.setText(String.valueOf(cow.getWeight()));
        etWeightChange.setText(String.valueOf(cow.getWeightChange()));
        etMilkProduction.setText(String.valueOf(cow.getMilkProduction()));
        etMilkFat.setText(String.valueOf(cow.getMilkFat()));
        etMilkProtein.setText(String.valueOf(cow.getMilkProtein()));
        etLactationWeeks.setText(String.valueOf(cow.getLactationWeeks()));
    }

    private void initEvent() {

    }
}

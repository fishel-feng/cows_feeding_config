package com.example.fx.cows_feeding_config.activity.cow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Cow;

public class CowAddActivity extends AppCompatActivity {

    private EditText etVariety;
    private EditText etWeight;
    private EditText etWeightChange;
    private EditText etMilkProduction;
    private EditText etMilkFat;
    private EditText etMilkProtein;
    private EditText etLactationWeeks;
    private Button btnSubmitCow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_add);
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
        this.btnSubmitCow = (Button) findViewById(R.id.btn_submit_cow);
    }

    private void initData() {
        Cow cow = getIntent().getParcelableExtra("cow");
        if (cow != null) {
            etVariety.setText(String.valueOf(cow.getVariety()));
            etWeight.setText(String.valueOf(cow.getWeight()));
            etWeightChange.setText(String.valueOf(cow.getWeightChange()));
            etMilkProduction.setText(String.valueOf(cow.getMilkProduction()));
            etMilkFat.setText(String.valueOf(cow.getMilkFat()));
            etMilkProtein.setText(String.valueOf(cow.getMilkProtein()));
            etLactationWeeks.setText(String.valueOf(cow.getLactationWeeks()));
        }
    }

    private void initEvent() {
        btnSubmitCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 提交动作
            }
        });
    }
}

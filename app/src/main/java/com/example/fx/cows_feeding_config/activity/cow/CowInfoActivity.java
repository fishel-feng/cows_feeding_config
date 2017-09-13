package com.example.fx.cows_feeding_config.activity.cow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Cow;

public class CowInfoActivity extends AppCompatActivity {

    private TextView etVariety;
    private TextView etWeight;
    private TextView etWeightChange;
    private TextView etMilkProduction;
    private TextView etMilkFat;
    private TextView etMilkProtein;
    private TextView etLactationWeeks;
    private Button btnChangeCow;
    private Button btnDeleteCow;

    private Cow cow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_info);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.etLactationWeeks = (TextView) findViewById(R.id.tv_lactation_weeks);
        this.etMilkProtein = (TextView) findViewById(R.id.tv_milk_protein);
        this.etMilkFat = (TextView) findViewById(R.id.tv_milk_fat);
        this.etMilkProduction = (TextView) findViewById(R.id.tv_milk_production);
        this.etWeightChange = (TextView) findViewById(R.id.tv_weight_change);
        this.etWeight = (TextView) findViewById(R.id.tv_weight);
        this.etVariety = (TextView) findViewById(R.id.tv_variety);
        this.btnChangeCow = (Button) findViewById(R.id.btn_change_cow);
        this.btnDeleteCow = (Button) findViewById(R.id.btn_delete_cow);
    }

    private void initData() {
        cow = getIntent().getParcelableExtra("cow");
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
        btnChangeCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CowInfoActivity.this, CowAddActivity.class);
                intent.putExtra("fodder", cow);
                startActivity(intent);
            }
        });
        btnDeleteCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 删除事件
            }
        });
    }
}

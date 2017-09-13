package com.example.fx.cows_feeding_config.activity.cow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Cow;

import org.litepal.crud.DataSupport;

public class CowAddActivity extends AppCompatActivity {

    private EditText etVariety;
    private EditText etWeight;
    private EditText etWeightChange;
    private EditText etMilkProduction;
    private EditText etMilkFat;
    private EditText etMilkProtein;
    private EditText etLactationWeeks;
    private Button btnSubmitCow;

    private Cow cow;

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
        btnSubmitCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cow target;
                if (cow != null) {
                    target = DataSupport.where("id = ?", String.valueOf(cow.getId())).find(Cow.class).get(0);
                } else {
                    target = new Cow();
                }
                if ("".equals(etVariety.getText().toString().trim())) {
                    Toast.makeText(CowAddActivity.this, "奶牛品种不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                target.setVariety(etVariety.getText().toString());
                target.setWeight(!"".equals(etWeight.getText().toString().trim()) ? Double.valueOf(etWeight.getText().toString()) : 0);
                target.setWeightChange(!"".equals(etWeightChange.getText().toString().trim()) ? Double.valueOf(etWeightChange.getText().toString()) : 0);
                target.setMilkProduction(!"".equals(etMilkProduction.getText().toString().trim()) ? Double.valueOf(etMilkProduction.getText().toString()) : 0);
                target.setMilkFat(!"".equals(etMilkFat.getText().toString().trim()) ? Double.valueOf(etMilkFat.getText().toString()) : 0);
                target.setMilkProtein(!"".equals(etMilkProtein.getText().toString().trim()) ? Double.valueOf(etMilkProtein.getText().toString()) : 0);
                target.setLactationWeeks(!"".equals(etLactationWeeks.getText().toString().trim()) ? Double.valueOf(etLactationWeeks.getText().toString()) : 0);
                target.save();
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                bundle.putParcelable("target", target);
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}

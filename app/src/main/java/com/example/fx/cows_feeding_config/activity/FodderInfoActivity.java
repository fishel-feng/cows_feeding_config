package com.example.fx.cows_feeding_config.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

public class FodderInfoActivity extends AppCompatActivity {

    private android.widget.EditText etName;
    private android.widget.Spinner spType;
    private android.widget.EditText etDryMatter;
    private android.widget.EditText etCalcium;
    private android.widget.EditText etPhosphorus;
    private android.widget.EditText etEnergy;
    private android.widget.EditText etCrudeProtein;
    private android.widget.EditText etPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fodder_info);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.etPrice = (EditText) findViewById(R.id.et_price);
        this.etCrudeProtein = (EditText) findViewById(R.id.et_crude_protein);
        this.etEnergy = (EditText) findViewById(R.id.et_energy);
        this.etPhosphorus = (EditText) findViewById(R.id.et_phosphorus);
        this.etCalcium = (EditText) findViewById(R.id.et_calcium);
        this.etDryMatter = (EditText) findViewById(R.id.et_dry_matter);
        this.spType = (Spinner) findViewById(R.id.sp_type);
        this.etName = (EditText) findViewById(R.id.et_name);
    }

    private void initData() {
        Fodder fodder = getIntent().getParcelableExtra("fodder");
        etName.setText(fodder.getName());
        spType.setSelection(fodder.getType() - 1);
        etDryMatter.setText(String.valueOf(fodder.getDryMatter()));
        etCalcium.setText(String.valueOf(fodder.getCalcium()));
        etPhosphorus.setText(String.valueOf(fodder.getPhosphorus()));
        etEnergy.setText(String.valueOf(fodder.getEnergy()));
        etCrudeProtein.setText(String.valueOf(fodder.getCrudeProtein()));
        etPrice.setText(String.valueOf(fodder.getPrice()));
    }

    private void initEvent() {

    }
}

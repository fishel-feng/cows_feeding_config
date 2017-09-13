package com.example.fx.cows_feeding_config.activity.fodder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

/**
 * Created by fx on 2017/9/13.
 */

public class FodderAddActivity extends AppCompatActivity {

    private EditText etName;
    private Spinner spType;
    private EditText etDryMatter;
    private EditText etCalcium;
    private EditText etPhosphorus;
    private EditText etEnergy;
    private EditText etCrudeProtein;
    private EditText etPrice;
    private Button btnSubmitFodder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fodder_add);
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
        this.btnSubmitFodder = (Button) findViewById(R.id.btn_submit_fodder);
    }

    private void initData() {
        Fodder fodder = getIntent().getParcelableExtra("fodder");
        if (fodder != null) {
            etName.setText(fodder.getName());
            spType.setSelection(fodder.getType() - 1);
            etDryMatter.setText(String.valueOf(fodder.getDryMatter()));
            etCalcium.setText(String.valueOf(fodder.getCalcium()));
            etPhosphorus.setText(String.valueOf(fodder.getPhosphorus()));
            etEnergy.setText(String.valueOf(fodder.getEnergy()));
            etCrudeProtein.setText(String.valueOf(fodder.getCrudeProtein()));
            etPrice.setText(String.valueOf(fodder.getPrice()));
        }
    }

    private void initEvent() {
        btnSubmitFodder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 提交动作
            }
        });
    }
}

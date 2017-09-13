package com.example.fx.cows_feeding_config.activity.fodder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

import org.litepal.crud.DataSupport;

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

    private Fodder fodder;

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
        fodder = getIntent().getParcelableExtra("fodder");
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
                Fodder target;
                if (fodder != null) {
                    target = (Fodder) DataSupport.where("id = ?", String.valueOf(fodder.getId())).find(Fodder.class);
                } else {
                    target = new Fodder();
                }
                if ("".equals(etName.getText().toString().trim())) {
                    Toast.makeText(FodderAddActivity.this, "饲料名称不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                target.setName(etName.getText().toString());
                target.setType(spType.getSelectedItemPosition() + 1);
                target.setDryMatter(!"".equals(etDryMatter.getText().toString().trim()) ? Double.valueOf(etDryMatter.getText().toString()) : 0);
                target.setCalcium(!"".equals(etCalcium.getText().toString().trim()) ? Double.valueOf(etCalcium.getText().toString()) : 0);
                target.setPhosphorus(!"".equals(etPhosphorus.getText().toString().trim()) ? Double.valueOf(etPhosphorus.getText().toString()) : 0);
                target.setEnergy(!"".equals(etEnergy.getText().toString().trim()) ? Double.valueOf(etEnergy.getText().toString()) : 0);
                target.setCrudeProtein(!"".equals(etCrudeProtein.getText().toString().trim()) ? Double.valueOf(etCrudeProtein.getText().toString()) : 0);
                target.setPrice(!"".equals(etPrice.getText().toString().trim()) ? Double.valueOf(etPrice.getText().toString()) : 0);
                target.save();
            }
        });
    }
}

package com.example.fx.cows_feeding_config.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

public class FodderInfoActivity extends AppCompatActivity {


    private android.widget.TextView tvName;
    private android.widget.TextView tvType;
    private android.widget.TextView tvDryMatter;
    private android.widget.TextView tvCalcium;
    private android.widget.TextView tvPhosphorus;
    private android.widget.TextView tvEnergy;
    private android.widget.TextView tvCrudeProtein;
    private android.widget.TextView tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fodder_info);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.tvPrice = (TextView) findViewById(R.id.tv_price);
        this.tvCrudeProtein = (TextView) findViewById(R.id.tv_crude_protein);
        this.tvEnergy = (TextView) findViewById(R.id.tv_energy);
        this.tvPhosphorus = (TextView) findViewById(R.id.tv_phosphorus);
        this.tvCalcium = (TextView) findViewById(R.id.tv_calcium);
        this.tvDryMatter = (TextView) findViewById(R.id.tv_dry_matter);
        this.tvType = (TextView) findViewById(R.id.tv_type);
        this.tvName = (TextView) findViewById(R.id.tv_name);
    }

    private void initData() {
        Fodder fodder = getIntent().getParcelableExtra("fodder");
        if (fodder != null) {
            tvName.setText(fodder.getName());
            tvType.setText(fodder.getType() == 1 ? "粗饲料" : "精饲料");
            tvDryMatter.setText(String.valueOf(fodder.getDryMatter()));
            tvCalcium.setText(String.valueOf(fodder.getCalcium()));
            tvPhosphorus.setText(String.valueOf(fodder.getPhosphorus()));
            tvEnergy.setText(String.valueOf(fodder.getEnergy()));
            tvCrudeProtein.setText(String.valueOf(fodder.getCrudeProtein()));
            tvPrice.setText(fodder.getPrice() != 0 ? String.valueOf(fodder.getPrice()) : "暂无价格");
        }
    }

    private void initEvent() {

    }
}

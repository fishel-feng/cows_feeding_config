package com.example.fx.cows_feeding_config.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.activity.cow.CowActivity;
import com.example.fx.cows_feeding_config.activity.fodder.FodderActivity;
import com.example.fx.cows_feeding_config.activity.optimize.OptimizeActivity;
import com.example.fx.cows_feeding_config.entity.Fodder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFodder;
    private Button btnCow;
    private Button btnOptimize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.btnOptimize = (Button) findViewById(R.id.btn_optimize);
        this.btnCow = (Button) findViewById(R.id.btn_cow);
        this.btnFodder = (Button) findViewById(R.id.btn_fodder);
    }


    private void initData() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("share", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (isFirstRun) {
            new Fodder("甜菜渣",1,0.883,0.088,1.41,8,0.8,2.7,1.6,8.5,2,2.6,0.01,0).save();
            new Fodder("啤酒糟",2,0.218,0.0062,0.4,0.8,1.3,0,0.3,1,0.5,0.7,0.11,0).save();
            new Fodder("豆饼",2,0.896,0.415,2.23,3.2,5.9,0.4,0.9,19,2.7,3,0.073,0).save();
            new Fodder("大豆",2,0.91,0.319,2.48,2.4,5.8,0.1,0.5,18.1,2.3,2.9,0.173,0).save();
            new Fodder("玉米",2,0.881,0.083,1.81,0.4,2.6,0.2,0.7,3.7,1.1,0.9,0.037,0).save();
            new Fodder("高粱",2,0.886,0.103,1.73,0.6,3.1,0.1,0.5,4.2,1.5,1,0.028,0).save();
            new Fodder("大豆干草",1,0.842,0.192,1.25,13.1,2.6,0.3,4.6,21.6,2.8,2.8,0.018,0).save();
            new Fodder("黄玉米青贮",1,0.235,0.023,0.35,0.7,0.6,0,0.7,3.1,0.4,0.3,0.006,0).save();
            new Fodder("高粱青贮",1,0.288,0.031,0.33,1.8,0.7,0.1,1.6,7.4,0.9,0.4,0.01,0).save();
            new Fodder("小麦秸",1,0.927,0.045,0.77,2.9,0.9,1.1,5.6,14.4,1.3,1,0.015,0).save();
            new Fodder("植物油",2,1,0,5.65,0,0,0,0,0,0,0,0.999,0).save();
            new Fodder("鲱鱼鱼粉",2,0.912,0.5875,2.23,48.7,27.8,6.2,7.3,6.7,1.8,10.6,0.095,0).save();
            new Fodder("带绒全棉籽",2,0.901,0.212,1.77,1.5,5.4,0.2,0.5,10.2,3.3,2.1,0.174,0).save();
            new Fodder("小麦麸",2,0.891,0.154,1.55,1.2,10.5,0.4,1.4,11.8,4.7,1.9,0.038,0).save();
            new Fodder("尿素",2,1,2.81,0,0,0,0,0,0,0,0,0,0).save();
            new Fodder("棉籽壳",2,0.89,0.055,0.35,1.6,1.1,0.2,0.5,10.3,1.5,0.5,0.022,0).save();
            new Fodder("混播干草",1,0.843,0.155,1.22,8.5,2.6,0.3,6.2,23.9,2.2,2.4,0.02,0).save();
            new Fodder("油菜籽粕",2,0.903,0.341,1.7,6.8,9.9,0.6,0.4,12.7,4.8,6.6,0.049,0).save();
            new Fodder("磷酸氢钙",3,1,0,0,182.6,144.8,0.5,0,0.6,0.9,0,0,0).save();
            new Fodder("碳酸氢钠",3,1,0,0,0,0,270,0,0,0,0,0,0).save();
            new Fodder("碳酸钙",3,1,0,0,390,0.4,0.5,0,0,0.5,0,0,0).save();
            new Fodder("稻糠",2,0.906,0.14,1.9,0.6,16.1,0.3,0.8,14.2,7.3,1.7,0.138,0).save();
            new Fodder("马铃薯秧",1,0.354,0.038,0.69,1.7,1,0.9,0.7,3.7,0.4,0.4,0.038,0).save();
            editor.putBoolean("isFirstRun", false);
            editor.apply();
        }
    }

    private void initEvent() {
        btnFodder.setOnClickListener(this);
        btnCow.setOnClickListener(this);
        btnOptimize.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_fodder:
                startActivity(new Intent(this, FodderActivity.class));
                break;
            case R.id.btn_cow:
                startActivity(new Intent(this, CowActivity.class));
                break;
            case R.id.btn_optimize:
                startActivity(new Intent(this, OptimizeActivity.class));
                break;
            default:
        }
    }
}

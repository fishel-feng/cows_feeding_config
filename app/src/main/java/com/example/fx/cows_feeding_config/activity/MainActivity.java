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
            new Fodder("甜菜渣", 1, 10.3, 0.10, 0.03, 0.21, 6).save();
            new Fodder("啤酒糟", 2, 13.6, 0.06, 0.08, 0.27, 26).save();
            new Fodder("胡麻饼", 2, 88.8, 0.00, 0.00, 2.52, 239).save();
            new Fodder("豆饼", 2, 91.0, 0.00, 0.00, 2.79, 355).save();
            new Fodder("大豆", 2, 90.8, 0.31, 0.48, 3.07, 219).save();
            new Fodder("玉米", 2, 89.2, 0.00, 0.00, 2.94, 74).save();
            new Fodder("高粱", 2, 87.3, 0.02, 0.38, 2.45, 46).save();
            new Fodder("玉米叶", 1, 91.6, 0.08, 0.12, 1.80, 22).save();
            new Fodder("玉米秸", 1, 93.3, 0.00, 0.00, 1.91, 27).save();
            new Fodder("谷草", 1, 90.7, 0.34, 0.03, 1.23, 26).save();
            new Fodder("羊草", 1, 91.6, 0.37, 0.18, 1.35, 37).save();
            new Fodder("苏丹草", 1, 85.8, 0.33, 0.14, 1.44, 61).save();
            new Fodder("雀麦草", 1, 94.3, 0.00, 0.00, 1.06, 24).save();
            new Fodder("苜蓿干草(野生)", 1, 93.1, 0.00, 0.00, 1.50, 104).save();
            new Fodder("苜蓿干草(紫花苜蓿)", 1, 93.9, 0.00, 0.00, 1.88, 138).save();
            new Fodder("大豆干草", 1, 94.6, 1.50, 0.70, 1.32, 71).save();
            new Fodder("稗草", 1, 93.4, 0.00, 0.00, 1.12, 7).save();
            new Fodder("甜菜", 2, 9.9, 0.03, 0.00, 0.18, 0).save();
            new Fodder("南瓜", 2, 10.0, 0.00, 0.00, 0.28, 11).save();
            new Fodder("胡萝卜(黄色)", 2, 13.4, 0.07, 0.00, 0.41, 9).save();
            new Fodder("胡萝卜(红色)", 2, 13.7, 0.06, 0.05, 0.41, 10).save();
            new Fodder("玉米青贮", 1, 29.2, 0.09, 0.08, 0.49, 8).save();
            new Fodder("玉米青割", 1, 22.9, 0.00, 0.02, 0.45, 9).save();
            new Fodder("玉米青割(乳熟期)", 1, 17.9, 0.06, 0.04, 0.35, 7).save();
            new Fodder("野青草", 1, 18.9, 0.24, 0.03, 0.33, 20).save();
            new Fodder("燕麦青割", 1, 25.5, 0.09, 0.06, 0.45, 23).save();
            new Fodder("马铃薯秧", 1, 12.1, 0.23, 0.02, 0.12, 11).save();
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
        }
    }
}

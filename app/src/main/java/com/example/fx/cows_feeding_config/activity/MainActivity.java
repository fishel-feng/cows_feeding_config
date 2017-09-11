package com.example.fx.cows_feeding_config.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.fx.cows_feeding_config.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFodder;
    private Button btnCow;
    private Button btnOptimize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        this.btnOptimize = (Button) findViewById(R.id.btn_optimize);
        this.btnCow = (Button) findViewById(R.id.btn_cow);
        this.btnFodder = (Button) findViewById(R.id.btn_fodder);
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

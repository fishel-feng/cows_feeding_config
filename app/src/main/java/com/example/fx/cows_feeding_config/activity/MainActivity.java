package com.example.fx.cows_feeding_config.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.fx.cows_feeding_config.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.Button data;
    private android.widget.Button need;
    private android.widget.Button optimize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        this.optimize = (Button) findViewById(R.id.optimize);
        this.need = (Button) findViewById(R.id.need);
        this.data = (Button) findViewById(R.id.data);
    }

    private void initEvent() {
        data.setOnClickListener(this);
        need.setOnClickListener(this);
        optimize.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.data:
                startActivity(new Intent(this, DataActivity.class));
                break;
            case R.id.need:
                startActivity(new Intent(this, NeedActivity.class));
                break;
            case R.id.optimize:
                startActivity(new Intent(this, OptimizeActivity.class));
                break;
        }
    }
}

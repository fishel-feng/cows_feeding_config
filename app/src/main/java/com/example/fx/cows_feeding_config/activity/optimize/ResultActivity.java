package com.example.fx.cows_feeding_config.activity.optimize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.ResultAdapter;
import com.example.fx.cows_feeding_config.gson.Result;

public class ResultActivity extends AppCompatActivity {

    private android.widget.ListView lvResult;
    private android.widget.TextView tvTotalPrice;

    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.tvTotalPrice = (TextView) findViewById(R.id.tv_total_price);
        this.lvResult = (ListView) findViewById(R.id.lv_result);
    }

    private void initData() {
        result = (Result) getIntent().getSerializableExtra("result");
        lvResult.setAdapter(new ResultAdapter(this, R.layout.result_item, result.fodderResults));
        tvTotalPrice.setText("饲料总价格为："+result.price);
    }

    private void initEvent() {

    }
}

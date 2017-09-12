package com.example.fx.cows_feeding_config.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.entity.Fodder;

public class FodderInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fodder_info);
        Intent intent=getIntent();
        Fodder fodder=intent.getParcelableExtra("fodder");
//        TextView textView= (TextView) findViewById(R.id.aaaaa);
//        textView.setText(fodder.getName());
    }
}

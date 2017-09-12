package com.example.fx.cows_feeding_config.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.CowAdapter;
import com.example.fx.cows_feeding_config.entity.Cow;

import java.util.ArrayList;
import java.util.List;

public class CowActivity extends AppCompatActivity {

    private RecyclerView rvCow;

    private List<Cow> cowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        rvCow = (RecyclerView) findViewById(R.id.rv_cow);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvCow.setLayoutManager(layoutManager);
    }

    private void initData() {
//        cowList = DataSupport.findAll(Cow.class);
        cowList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Cow cow = new Cow();
            cow.setVariety("1");
            cowList.add(cow);
            Cow cow2 = new Cow();
            cow2.setVariety("12");
            cowList.add(cow2);
            Cow cow22 = new Cow();
            cow22.setVariety("122");
            cowList.add(cow22);
        }
    }

    private void initEvent() {
        CowAdapter adapter = new CowAdapter(cowList);
        rvCow.setAdapter(adapter);
        adapter.setOnItemClickListener(new CowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Cow cow = cowList.get(position);
                Intent intent = new Intent(CowActivity.this, CowInfoActivity.class);
                intent.putExtra("cow", cow);
                startActivity(intent);
            }
        });
    }
}

package com.example.fx.cows_feeding_config.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.FodderAdapter;
import com.example.fx.cows_feeding_config.entity.Fodder;

import java.util.ArrayList;
import java.util.List;

public class FodderActivity extends AppCompatActivity {

    private RecyclerView rvFodder;

    private List<Fodder> fodderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fodder);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        rvFodder = (RecyclerView) findViewById(R.id.rv_fodder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvFodder.setLayoutManager(layoutManager);
    }

    private void initData() {
//        fodderList = DataSupport.findAll(Fodder.class);
        fodderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Fodder fodder = new Fodder();
            fodder.setName("1");
            fodderList.add(fodder);
            Fodder fodder1 = new Fodder();
            fodder1.setName("11");
            fodderList.add(fodder1);
            Fodder fodder11 = new Fodder();
            fodder11.setName("111");
            fodderList.add(fodder11);
        }
    }

    private void initEvent() {
        FodderAdapter adapter = new FodderAdapter(fodderList);
        rvFodder.setAdapter(adapter);
        adapter.setOnItemClickListener(new FodderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Fodder fodder=fodderList.get(position);
                Intent intent=new Intent(FodderActivity.this,FodderInfoActivity.class);
                intent.putExtra("fodder",fodder);
                startActivity(intent);
            }
        });
    }
}

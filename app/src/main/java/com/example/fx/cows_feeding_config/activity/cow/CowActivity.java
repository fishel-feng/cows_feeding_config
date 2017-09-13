package com.example.fx.cows_feeding_config.activity.cow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.CowAdapter;
import com.example.fx.cows_feeding_config.entity.Cow;

import org.litepal.crud.DataSupport;

import java.util.List;

public class CowActivity extends AppCompatActivity {

    private RecyclerView rvCow;
    private Button btnAddCow;

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
        btnAddCow= (Button) findViewById(R.id.btn_add_cow);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvCow.setLayoutManager(layoutManager);
    }

    private void initData() {
        cowList = DataSupport.findAll(Cow.class);
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
        btnAddCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CowActivity.this,CowAddActivity.class));
            }
        });
    }
}

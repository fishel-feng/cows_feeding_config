package com.example.fx.cows_feeding_config.activity.optimize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.FodderListAdapter;
import com.example.fx.cows_feeding_config.entity.Fodder;

import org.litepal.crud.DataSupport;

import java.util.List;

public class FodderSelectActivity extends AppCompatActivity {

    private RecyclerView rvCheck;
    private Button btnSubmitCheck;

    private List<Fodder> fodderList;

    private FodderListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fodder_select);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        rvCheck = (RecyclerView) findViewById(R.id.rv_check);
        btnSubmitCheck = (Button) findViewById(R.id.btn_submit_check);
        rvCheck.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        fodderList = DataSupport.findAll(Fodder.class);
    }

    private void initEvent() {
        adapter = new FodderListAdapter(fodderList);
        rvCheck.setAdapter(adapter);
        adapter.setOnItemClickListener(new FodderListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO: 2017/9/14 alertdialog
            }
        });
        btnSubmitCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/9/14 getFooderinfolist 销毁
            }
        });
    }
}

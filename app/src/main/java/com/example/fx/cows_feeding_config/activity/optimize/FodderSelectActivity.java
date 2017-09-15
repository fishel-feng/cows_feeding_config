package com.example.fx.cows_feeding_config.activity.optimize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.FodderListAdapter;
import com.example.fx.cows_feeding_config.entity.Fodder;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
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
        adapter = new FodderListAdapter(fodderList);
        rvCheck.setAdapter(adapter);
        List<Fodder> fodderInfoList = getIntent().getParcelableArrayListExtra("infoList");
        List<Fodder> fodderRemoveList = adapter.getFodderRemoveList();
        if (fodderInfoList != null) {
            for (Fodder fodder : fodderList) {
                for (Fodder fodderInfo : fodderInfoList) {
                    if (fodder.getId() == fodderInfo.getId()) {
                        fodder.setChecked(true);
                    }
                }
            }
        }
        if (fodderRemoveList != null) {
            for (Fodder fodder : fodderList) {
                for (Fodder fodderRemove : fodderRemoveList) {
                    if (fodder.getId() == fodderRemove.getId()) {
                        fodder.setChecked(true);
                    }
                }
            }
        }
        // TODO 取消选中
    }

    private void initEvent() {
        adapter.setOnItemClickListener(new FodderListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO: 2017/9/14 alertdialog
            }
        });
        btnSubmitCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                bundle.putParcelableArrayList("fodderInfoList", (ArrayList<? extends Parcelable>) adapter.getFodderInfoList());
                bundle.putParcelableArrayList("fodderRemoveList", (ArrayList<? extends Parcelable>) adapter.getFodderRemoveList());
                bundle.putInt("coarse", adapter.getCoarse());
                bundle.putInt("concentrate", adapter.getConcentrate());
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}

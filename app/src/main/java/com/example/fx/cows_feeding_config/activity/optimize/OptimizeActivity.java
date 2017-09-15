package com.example.fx.cows_feeding_config.activity.optimize;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.CowListAdapter;
import com.example.fx.cows_feeding_config.adapter.FodderInfoAdapter;
import com.example.fx.cows_feeding_config.entity.Cow;
import com.example.fx.cows_feeding_config.entity.Fodder;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fx on 2017/9/13.
 */

public class OptimizeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSelectCow;
    private Button btnSelectFodder;
    private ListView lvSelectFodder;
    private Button btn1;
    private Button btn2;

    private List<Cow> cowList;
    private List<Fodder> fodderInfoList = new ArrayList<>();

    private FodderInfoAdapter adapter;

    private Cow cow;

    //粗饲料
    private int coarse;

    //精饲料
    private int concentrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimize);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        this.btnSelectCow = (Button) findViewById(R.id.btn_select_cow);
        this.btnSelectFodder = (Button) findViewById(R.id.btn_select_fodder);
        this.lvSelectFodder = (ListView) findViewById(R.id.lv_select_fodder);
        this.btn1 = (Button) findViewById(R.id.btn_1);
        this.btn2 = (Button) findViewById(R.id.btn_2);
    }

    private void initData() {
        cowList = DataSupport.findAll(Cow.class);
        adapter = new FodderInfoAdapter(OptimizeActivity.this, R.layout.info_item, fodderInfoList);
        lvSelectFodder.setAdapter(adapter);
    }

    private void initEvent() {
        btnSelectCow.setOnClickListener(this);
        btnSelectFodder.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_select_cow:
                AlertDialog.Builder cowBuilder = new AlertDialog.Builder(this);
                cowBuilder.setSingleChoiceItems(new CowListAdapter(this, R.layout.item, cowList), 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ListView listView = ((AlertDialog) dialogInterface).getListView();
                        cow = (Cow) listView.getAdapter().getItem(i);
                        dialogInterface.dismiss();
                        btnSelectCow.setText(cow.getVariety() + "重" + cow.getWeight() + "产乳" + cow.getMilkProduction());
                    }
                }).create().show();
                break;
            case R.id.btn_select_fodder:
                Intent intent = new Intent(OptimizeActivity.this, FodderSelectActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                intent.putParcelableArrayListExtra("infoList", (ArrayList<? extends Parcelable>) fodderInfoList);
                startActivityForResult(intent, 8);
                break;
            case R.id.btn_1:
                adapter.setContent();
                break;
            case R.id.btn_2:
                // TODO
                adapter.setContent();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 8 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            ArrayList<Fodder> selectList = bundle.getParcelableArrayList("fodderInfoList");
            ArrayList<Fodder> fodderRemoveList = bundle.getParcelableArrayList("fodderRemoveList");
            if (selectList != null) {
                for (Fodder fodder : selectList) {
                    fodderInfoList.add(fodder);
                }
            }
            List<Fodder> temp = new ArrayList<>();
            if (fodderRemoveList != null) {
                for (Fodder fodder : fodderRemoveList) {
                    for (Fodder fodderInfo : fodderInfoList) {
                        if (fodder.getId() == fodderInfo.getId()) {
                            temp.add(fodderInfo);
                        }
                    }
                }
            }
            for (Fodder t : temp) {
                fodderInfoList.remove(t);
            }
            int coarseNum = 0;
            int concentrateNum = 0;
            for (Fodder fodder : fodderInfoList) {
                if (fodder.getType() == 1) {
                    coarseNum++;
                } else if (fodder.getType() == 2) {
                    concentrateNum++;
                }
            }
            coarse = coarseNum;
            concentrate = concentrateNum;
            btnSelectFodder.setText("选择粗饲料" + coarseNum + "种,精饲料" + concentrateNum + "种，单位kg");
            adapter.notifyDataSetChanged();
        }
    }
}


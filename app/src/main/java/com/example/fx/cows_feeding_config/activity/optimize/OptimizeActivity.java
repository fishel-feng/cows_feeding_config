package com.example.fx.cows_feeding_config.activity.optimize;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.CowListAdapter;
import com.example.fx.cows_feeding_config.entity.Cow;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by fx on 2017/9/13.
 */

public class OptimizeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSelectCow;

    private List<Cow> cowList;

    private Cow cow;

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
    }

    private void initData() {
        cowList = DataSupport.findAll(Cow.class);
    }

    private void initEvent() {
        btnSelectCow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_select_cow:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setSingleChoiceItems(new CowListAdapter(this, R.layout.item, cowList), 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ListView listView = ((AlertDialog) dialogInterface).getListView();
                        cow = (Cow) listView.getAdapter().getItem(i);
                        dialogInterface.dismiss();
                        btnSelectCow.setText(cow.getVariety() + "重" + cow.getWeight() + "产乳" + cow.getMilkProduction());
                    }
                }).create().show();
                break;
        }
    }
}

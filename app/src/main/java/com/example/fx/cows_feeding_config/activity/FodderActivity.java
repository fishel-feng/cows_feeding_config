package com.example.fx.cows_feeding_config.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.ItemAdapter;
import com.example.fx.cows_feeding_config.entity.Fodder;

import org.litepal.crud.DataSupport;

import java.util.List;

public class FodderActivity extends AppCompatActivity {

    private ListView lvFodder;

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
        lvFodder = (ListView) findViewById(R.id.lv_fodder);
    }

    private void initData() {
        fodderList = DataSupport.select("name", "type", "price").find(Fodder.class);
    }

    private void initEvent() {
        ItemAdapter adapter = new ItemAdapter(this, R.layout.item, fodderList);
        lvFodder.setAdapter(adapter);
    }
}

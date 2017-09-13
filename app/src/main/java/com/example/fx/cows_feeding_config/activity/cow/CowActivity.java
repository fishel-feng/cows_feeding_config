package com.example.fx.cows_feeding_config.activity.cow;

import android.app.Activity;
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

    private CowAdapter adapter;

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
        btnAddCow = (Button) findViewById(R.id.btn_add_cow);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvCow.setLayoutManager(layoutManager);
    }

    private void initData() {
        cowList = DataSupport.findAll(Cow.class);
    }

    private void initEvent() {
        adapter = new CowAdapter(cowList);
        rvCow.setAdapter(adapter);
        adapter.setOnItemClickListener(new CowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Cow cow = cowList.get(position);
                Intent intent = new Intent(CowActivity.this, CowInfoActivity.class);
                intent.putExtra("cow", cow);
                intent.putExtra("position", position);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, 6);
            }
        });
        btnAddCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CowActivity.this, CowAddActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, 5);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            cowList.add((Cow) bundle.getParcelable("target"));
            adapter.notifyDataSetChanged();
        }
        if (requestCode == 6 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            Cow newCow = bundle.getParcelable("newCow");
            int position = bundle.getInt("click");
            if (newCow != null) {
                cowList.set(position, newCow);
            }
            adapter.notifyDataSetChanged();
        }
        if (requestCode == 6 && resultCode == Activity.RESULT_CANCELED) {
            cowList.remove(data.getExtras().getInt("del"));
            adapter.notifyDataSetChanged();
        }
    }
}

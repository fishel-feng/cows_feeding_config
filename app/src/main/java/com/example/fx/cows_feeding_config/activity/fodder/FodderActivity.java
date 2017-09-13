package com.example.fx.cows_feeding_config.activity.fodder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.fx.cows_feeding_config.R;
import com.example.fx.cows_feeding_config.adapter.FodderAdapter;
import com.example.fx.cows_feeding_config.entity.Fodder;

import org.litepal.crud.DataSupport;

import java.util.List;

public class FodderActivity extends AppCompatActivity {

    private RecyclerView rvFodder;
    private Button btnAddFodder;

    private List<Fodder> fodderList;

    private FodderAdapter adapter;

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
        btnAddFodder = (Button) findViewById(R.id.btn_add_fodder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvFodder.setLayoutManager(layoutManager);
    }

    private void initData() {
        fodderList = DataSupport.findAll(Fodder.class);
    }

    private void initEvent() {
        adapter = new FodderAdapter(fodderList);
        rvFodder.setAdapter(adapter);
        adapter.setOnItemClickListener(new FodderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Fodder fodder = fodderList.get(position);
                Intent intent = new Intent(FodderActivity.this, FodderInfoActivity.class);
                intent.putExtra("fodder", fodder);
                intent.putExtra("position", position);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, 2);
            }
        });
        btnAddFodder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FodderActivity.this, FodderAddActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            fodderList.add((Fodder) bundle.getParcelable("target"));
            adapter.notifyDataSetChanged();
        }
        if (requestCode == 2 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            Fodder newFodder = bundle.getParcelable("newFodder");
            int position = bundle.getInt("click");
            if (newFodder != null) {
                fodderList.set(position, newFodder);
            }
            adapter.notifyDataSetChanged();
        }
        if (requestCode == 2 && resultCode == Activity.RESULT_CANCELED) {
            fodderList.remove(data.getExtras().getInt("del"));
            adapter.notifyDataSetChanged();
        }
    }
}

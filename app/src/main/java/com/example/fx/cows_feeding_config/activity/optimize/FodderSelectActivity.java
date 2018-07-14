package com.example.fx.cows_feeding_config.activity.optimize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    }

    private void initEvent() {
        adapter.setOnItemClickListener(new FodderListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FodderSelectActivity.this);
                View v = View.inflate(FodderSelectActivity.this, R.layout.info_dialog, null);
                builder.setView(v);
                builder.setCancelable(true);
                TextView tvPrice = v.findViewById(R.id.tv_dialog_price);
                TextView tvCrudeProtein = v.findViewById(R.id.tv_dialog_crude_protein);
                TextView tvEnergy = v.findViewById(R.id.tv_dialog_energy);
                TextView tvPhosphorus = v.findViewById(R.id.tv_dialog_phosphorus);
                TextView tvSodium = v.findViewById(R.id.tv_dialog_sodium);
                TextView tvChlorine = v.findViewById(R.id.tv_dialog_chlorine);
                TextView tvPotassium = v.findViewById(R.id.tv_dialog_potassium);
                TextView tvMagnesium = v.findViewById(R.id.tv_dialog_magnesium);
                TextView tvSulphur = v.findViewById(R.id.tv_dialog_sulphur);
                TextView tvCrudeFat = v.findViewById(R.id.tv_dialog_crude_fat);
                TextView tvCalcium = v.findViewById(R.id.tv_dialog_calcium);
                TextView tvDryMatter = v.findViewById(R.id.tv_dialog_dry_matter);
                TextView tvType = v.findViewById(R.id.tv_dialog_type);
                TextView tvName = v.findViewById(R.id.tv_dialog_name);
                Fodder fodder = fodderList.get(position);
                tvName.setText(fodder.getName());
                tvType.setText(fodder.getType() == 1 ? "精饲料" : fodder.getType() == 2 ? "粗饲料" : "添加剂");
                tvDryMatter.setText(String.valueOf(fodder.getDryMatter()));
                tvCrudeProtein.setText(String.valueOf(fodder.getCrudeProtein()));
                tvEnergy.setText(String.valueOf(fodder.getEnergy()));
                tvCalcium.setText(String.valueOf(fodder.getCalcium()));
                tvPhosphorus.setText(String.valueOf(fodder.getPhosphorus()));
                tvSodium.setText(String.valueOf(fodder.getSodium()));
                tvChlorine.setText(String.valueOf(fodder.getChlorine()));
                tvPotassium.setText(String.valueOf(fodder.getPotassium()));
                tvMagnesium.setText(String.valueOf(fodder.getMagnesium()));
                tvSulphur.setText(String.valueOf(fodder.getSulphur()));
                tvCrudeFat.setText(String.valueOf(fodder.getCrudeFat()));
                tvPrice.setText(fodder.getPrice() != 0 ? String.valueOf(fodder.getPrice()) : "暂无价格");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btnSubmitCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                bundle.putParcelableArrayList("fodderInfoList", (ArrayList<? extends Parcelable>) adapter.getFodderInfoList());
                bundle.putParcelableArrayList("fodderRemoveList", (ArrayList<? extends Parcelable>) adapter.getFodderRemoveList());
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
